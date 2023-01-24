package com.example.lp4.service;

import com.example.lp4.model.entity.Marca;
import com.example.lp4.model.repository.MarcaRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.easymock.EasyMock.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class MarcaServiceTest {

    private MarcaService marcaService;

    @BeforeAll
    void init() {
        this.marcaService = new MarcaService();
    }
    @Test
    public void testaCriarMarcaComSucesso(){
        List<Marca> listaProvas = new ArrayList<>();

        MarcaRepository marcaRepositoryMock = createMock(MarcaRepository.class);
        expect(marcaRepositoryMock.findAll()).andReturn(listaProvas);
        replay(marcaRepositoryMock);

        List<Marca> retorno = this.marcaService.getMarcas(marcaRepositoryMock);

        assertEquals(listaProvas, retorno);
    }

}