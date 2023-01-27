package com.example.lp4.service;

import com.example.lp4.exception.RegraNegocioException;
import com.example.lp4.model.entity.Marca;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.expect;
import static org.junit.jupiter.api.Assertions.*;

class MarcaServiceTest {

    private MarcaService marcaService;

    @BeforeEach
    void init() {
        this.marcaService = new MarcaService();
    }

    @Test
    void deveLancarExcecaoQuandoNomeMarcaForNulo() {
        Marca marca = new Marca();
        marca.setNome(null);
        assertThrows(RegraNegocioException.class, () -> marcaService.validar(marca));
    }

    @Test
    void deveLancarExcecaoQuandoNomeMarcaForVazio() {
        Marca marca = new Marca();
        marca.setNome("");
        assertThrows(RegraNegocioException.class, () -> marcaService.validar(marca));
    }

    @Test
    void naoDeveLancarExcecaoQuandoNomeMarcaForValido() {
        Marca marca = new Marca();
        marca.setNome("Amanco");
        assertDoesNotThrow(() -> marcaService.validar(marca));
    }

}