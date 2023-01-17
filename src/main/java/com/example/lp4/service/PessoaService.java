package com.example.lp4.service;

import com.example.lp4.model.entity.Pessoa;
import com.example.lp4.model.repository.PessoaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class PessoaService {

    private PessoaRepository repository;

    public PessoaService(PessoaRepository repository){
        this.repository=repository;
    }

    public List<Pessoa> getPessoa(){
        return repository.findAll();
    }

    public Optional<Pessoa> getPessoaById(Long id){
        return repository.findById(id);
    }

    @Transactional
    public Pessoa salvar(Pessoa Pessoa){
        return repository.save(Pessoa);
    }

    @Transactional
    public void excluir(Pessoa Pessoa){
        Objects.requireNonNull(Pessoa.getId());
        repository.delete(Pessoa);
    }

}
