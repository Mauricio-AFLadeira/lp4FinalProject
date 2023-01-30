package com.example.lp4.service;

import com.example.lp4.exception.RegraNegocioException;
import com.example.lp4.model.entity.Categoria;
import com.example.lp4.model.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository repository;

//    public CategoriaService(CategoriaRepository repository){
//        this.repository=repository;
//    }

    public List<Categoria> getCategoria(){
        return repository.findAll();
    }

    public Optional<Categoria> getCategoriaById(Long id){
        return repository.findById(id);
    }

    @Transactional
    public Categoria salvar(Categoria categoria){
        validar(categoria);
        return repository.save(categoria);
    }

    @Transactional
    public void excluir(Categoria categoria){
        Objects.requireNonNull(categoria.getId());
        repository.delete(categoria);
    }

    public void validar(Categoria categoria){

        if (categoria.getNome()==null || categoria.getNome().trim().equals("")){
            throw new RegraNegocioException("Categoria sem nome!");
        }

    }
}
