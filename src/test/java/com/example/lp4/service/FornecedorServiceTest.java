package com.example.lp4.service;

import com.example.lp4.exception.RegraNegocioException;
import com.example.lp4.model.entity.Fornecedor;
import com.example.lp4.model.repository.FornecedorRepository;
import org.easymock.EasyMock;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

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
        Fornecedor fornecedor = new Fornecedor();
        fornecedor.setCnpj("2323222.323.23.2/2");
        fornecedor.setTelefone("232323");
        fornecedor.setEmail(null);
        fornecedor.setNome("fornecedor");
        fornecedor.setResponsavel("Juca");

        assertThrows(RegraNegocioException.class, () -> {
            fornecedorService.validar(fornecedor);
        });
    }

    @Test
    public void naoDeveValidarTelefoneNulo() {
        Fornecedor fornecedor = new Fornecedor();
        fornecedor.setCnpj("2323222.323.23.2/2");
        fornecedor.setTelefone(null);
        fornecedor.setEmail("fddffd");
        fornecedor.setNome("fornecedor");
        fornecedor.setResponsavel("Juca");

        assertThrows(RegraNegocioException.class, () -> {
            fornecedorService.validar(fornecedor);
        });

    }

    @Test
    public void naoDeveValidarResponsavelNulo() {
        Fornecedor fornecedor = new Fornecedor();
        fornecedor.setCnpj("2323222.323.23.2/2");
        fornecedor.setTelefone("3090-3232");
        fornecedor.setEmail("fddffd");
        fornecedor.setNome("fornecedor");
        fornecedor.setResponsavel(null);


        assertThrows(RegraNegocioException.class, () -> {
            fornecedorService.validar(fornecedor);
        });
    }

    @Test
    public void naoDeveValidarNomeNulo() {
        Fornecedor fornecedor = new Fornecedor();
        fornecedor.setCnpj("2323222.323.23.2/2");
        fornecedor.setTelefone("323-23232");
        fornecedor.setEmail("fddffd");
        fornecedor.setNome(null);
        fornecedor.setResponsavel("Juca");

        assertThrows(RegraNegocioException.class, () -> {
            fornecedorService.validar(fornecedor);
        });
    }

}