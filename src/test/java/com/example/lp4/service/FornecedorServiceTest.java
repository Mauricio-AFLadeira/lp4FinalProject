package com.example.lp4.service;

import com.example.lp4.exception.RegraNegocioException;
import com.example.lp4.model.entity.Fornecedor;
import org.easymock.EasyMock;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.easymock.EasyMock.*;
import static org.junit.jupiter.api.Assertions.*;

class FornecedorServiceTest {

    private FornecedorService fornecedorService;

    @BeforeEach
    void init() {
        this.fornecedorService = new FornecedorService();
    }

    @Test
    public void naoDeveValidarCnpjNulo() {
        Fornecedor fornecedor = createMock(Fornecedor.class);
        expect(fornecedor.getCnpj()).andReturn(null);
        expect(fornecedor.getNome()).andReturn("Juca");
        expect(fornecedor.getResponsavel()).andReturn("joao");
        expect(fornecedor.getTelefone()).andReturn("21212-313");
        expect(fornecedor.getCnpj()).andReturn("1213131313");
        expect(fornecedor.getEmail()).andReturn("sas@fggdf.com");
        replay(fornecedor);

        assertThrows(RegraNegocioException.class, () -> {
            fornecedorService.validar(fornecedor);
        });
    }

    @Test
    public void naoDeveValidarEmailNulo() {
        Fornecedor fornecedor = createMock(Fornecedor.class);
        expect(fornecedor.getNome()).andReturn("Juca");
        expect(fornecedor.getResponsavel()).andReturn("joao");
        expect(fornecedor.getTelefone()).andReturn("21212-313");
        expect(fornecedor.getCnpj()).andReturn("1213131313");
        expect(fornecedor.getEmail()).andReturn(null);
        replay(fornecedor);

        assertThrows(RegraNegocioException.class, () -> {
            fornecedorService.validar(fornecedor);
        });
//        EasyMock.verify(fornecedor);
        reset(fornecedor);
    }

    @Test
    public void naoDeveValidarTelefoneNulo() {
        Fornecedor fornecedor = EasyMock.createMock(Fornecedor.class);
        expect(fornecedor.getTelefone()).andReturn(null);
        expect(fornecedor.getCnpj()).andReturn("1213131313");
        expect(fornecedor.getEmail()).andReturn("sas@fggdf.com");
        replay(fornecedor);

        assertThrows(RegraNegocioException.class, () -> {
            fornecedorService.validar(fornecedor);
        });
        reset(fornecedor);
//        EasyMock.verify(fornecedor);

    }

    @Test
    public void naoDeveValidarResponsavelNulo() {
        Fornecedor fornecedor = EasyMock.createMock(Fornecedor.class);
        expect(fornecedor.getResponsavel()).andReturn(null);
        expect(fornecedor.getTelefone()).andReturn("21212-313");
        expect(fornecedor.getCnpj()).andReturn("1213131313");
        expect(fornecedor.getEmail()).andReturn("sas@fggdf.com");
        replay(fornecedor);


        assertThrows(RegraNegocioException.class, () -> {
            fornecedorService.validar(fornecedor);
        });
//        EasyMock.verify(fornecedor);
        reset(fornecedor);
    }

    @Test
    public void naoDeveValidarNomeNulo() {
        Fornecedor fornecedor = EasyMock.createMock(Fornecedor.class);
        expect(fornecedor.getNome()).andReturn(null);
        expect(fornecedor.getResponsavel()).andReturn("joao");
        expect(fornecedor.getTelefone()).andReturn("21212-313");
        expect(fornecedor.getCnpj()).andReturn("1213131313");
        expect(fornecedor.getEmail()).andReturn("sas@fggdf.com");
        replay(fornecedor);

        assertThrows(RegraNegocioException.class, () -> {
            fornecedorService.validar(fornecedor);
        });
//        EasyMock.verify(fornecedor);
        reset(fornecedor);
    }

}