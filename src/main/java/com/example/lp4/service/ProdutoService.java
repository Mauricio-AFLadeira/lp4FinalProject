package com.example.lp4.service;

import com.example.lp4.exception.RegraNegocioException;
import com.example.lp4.model.entity.Produto;
import com.example.lp4.model.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository repository;

//    public ProdutoService(ProdutoRepository repository){
//        this.repository=repository;
//    }

    public List<Produto> getProdutos(){
        return repository.findAll();
    }

    public Optional<Produto> getProdutoById(Long id){
        return repository.findById(id);
    }

    @Transactional
    public Produto salvar(Produto produto){
        validar(produto);
        return repository.save(produto);
    }

    @Transactional
    public void excluir(Produto produto){
        Objects.requireNonNull(produto.getId());
        repository.delete(produto);
    }

    public void validar(Produto produto) {
        if (produto.getNome()==null || produto.getNome().trim().equals("")){
            throw new RegraNegocioException("nome do produto não especificado");
        }
        if (produto.getValorUnitario()==null || produto.getValorUnitario()==0){
            throw new RegraNegocioException("preço não especificado ou sem valor");
        }
        if (produto.getCategoria().getId()==null){
            throw new RegraNegocioException("categoria não relacionada ao produto");
        }
        if (produto.getMarca().getId()==null){
            throw new RegraNegocioException("marca não relacionada ao produto");
        }

    }
}
