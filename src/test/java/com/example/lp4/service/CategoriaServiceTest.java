package com.example.lp4.service;

import com.example.lp4.exception.RegraNegocioException;
import com.example.lp4.model.entity.Categoria;
import com.example.lp4.model.repository.CategoriaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

import static org.easymock.EasyMock.*;
import static org.junit.jupiter.api.Assertions.*;

class CategoriaServiceTest {

    private CategoriaService categoriaService;

    @BeforeEach
    void init() {
        this.categoriaService = new CategoriaService();
    }

    @Test
    void deveLancarExcecaoQuandoNomeCategoriaForNulo() {
        Categoria categoria = new Categoria();
        categoria.setNome(null);
        assertThrows(RegraNegocioException.class, () -> categoriaService.validar(categoria));
    }

    @Test
    void deveLancarExcecaoQuandoNomeCategoriaForVazio() {
        Categoria categoria = new Categoria();
        categoria.setNome("");
        assertThrows(RegraNegocioException.class, () -> categoriaService.validar(categoria));
    }

    @Test
    void naoDeveLancarExcecaoQuandoNomeCategoriaForValido() {
        Categoria categoria = new Categoria();
        categoria.setNome("Amanco");
        assertDoesNotThrow(() -> categoriaService.validar(categoria));
    }

}