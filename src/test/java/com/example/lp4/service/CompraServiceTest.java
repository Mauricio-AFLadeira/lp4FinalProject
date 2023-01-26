package com.example.lp4.service;

import com.example.lp4.exception.RegraNegocioException;
import com.example.lp4.model.entity.Compra;
import com.example.lp4.model.entity.Fornecedor;
import org.checkerframework.checker.units.qual.C;
import org.easymock.EasyMock;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class CompraServiceTest {
    private CompraService service;

    @BeforeEach
    void init() {
        this.service = new CompraService();
    }

    @Test
    public void testValidarCompraSemData() {
        Compra compra = new Compra();
        compra.setFornecedor(EasyMock.createMock(Fornecedor.class));
        EasyMock.expect(compra.getFornecedor().getId()).andReturn(1L);
        EasyMock.replay(compra.getFornecedor());

        assertThrows(RegraNegocioException.class, () -> {
            service.validar(compra);
        });
    }

    @Test
    public void testValidarCompraSemFornecedor() {
        Compra compra = new Compra();
        Date data = new Date();
        compra.setDataDaCompra(data);

        try {
            this.service.validar(compra);
            fail();
        } catch (NullPointerException e) {
            assertEquals("Cannot invoke \"com.example.lp4.model.entity.Fornecedor.getId()\" because the return value of \"com.example.lp4.model.entity.Compra.getFornecedor()\" is null", e.getMessage());
        }
    }

    @Test
    public void testValidarCompraValida() {
        Compra compra = new Compra();
        Date data = new Date();
        compra.setDataDaCompra(data);
        compra.setFornecedor(EasyMock.createMock(Fornecedor.class));
        EasyMock.expect(compra.getFornecedor().getId()).andReturn(1L);
        EasyMock.replay(compra.getFornecedor());
        assertDoesNotThrow(() -> service.validar(compra));
    }

    @Test
    public void testValidarCompraFornecedorIdNulo() {
        Compra compra = new Compra();
        Date data = new Date();
        compra.setDataDaCompra(data);
        compra.setFornecedor(EasyMock.createMock(Fornecedor.class));
        EasyMock.expect(compra.getFornecedor().getId()).andReturn(null);
        EasyMock.replay(compra.getFornecedor());

        assertThrows(RegraNegocioException.class, () -> {
            service.validar(compra);
        });
    }
}