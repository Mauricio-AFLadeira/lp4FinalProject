package com.example.lp4.service;

import com.example.lp4.exception.RegraNegocioException;
import com.example.lp4.model.entity.Marca;
import com.example.lp4.model.repository.MarcaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class MarcaService {

    private MarcaRepository repository;

    public MarcaService(MarcaRepository repository){
        this.repository=repository;
    }

    public List<Marca> getMarcas() {
        return repository.findAll();
    }

    public Optional<Marca> getMarcaById(Long id) {
        return repository.findById(id);
    }

    @Transactional
    public Marca salvar(Marca marca) {
        validar(marca);
        return repository.save(marca);
    }

    @Transactional
    public void excluir(Marca marca) {
        Objects.requireNonNull(marca.getId());
        repository.delete(marca);
    }

    public void validar(Marca marca) {

        if (marca.getNome()==null || marca.getNome().trim().equals("")){
            throw new RegraNegocioException("Insira um nome para a marca");
        }
    }

}
