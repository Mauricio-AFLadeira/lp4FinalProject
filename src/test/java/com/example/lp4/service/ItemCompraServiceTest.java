package com.example.lp4.service;

import com.example.lp4.exception.RegraNegocioException;
import com.example.lp4.model.entity.Compra;
import com.example.lp4.model.entity.ItemCompra;
import com.example.lp4.model.entity.Produto;
import org.easymock.EasyMock;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.easymock.EasyMock.*;
import static org.junit.jupiter.api.Assertions.*;

class ItemCompraServiceTest {

    private ItemCompraService service;

    @BeforeEach
    void init(){
        this.service = new ItemCompraService();
    }

    @Test
    public void naoDeveValidarItemCompraSemCompraRelacionada() {
        ItemCompra itemCompra = new ItemCompra();
        itemCompra.setQtdeProduto(12);

        Compra compra = createMock(Compra.class);
        expect(compra.getId()).andReturn(null);

        Produto produto = createMock(Produto.class);
        expect(produto.getId()).andReturn(1L);

        replay(compra, produto);

        itemCompra.setCompra(compra);
        itemCompra.setProduto(produto);

        Assertions.assertThrows(RegraNegocioException.class, () -> {
            service.validar(itemCompra);
        });
    }

    @Test
    public void naoDeveValidarItemCompraSemProdutoRelacionada() {
        ItemCompra itemCompra = new ItemCompra();
        itemCompra.setQtdeProduto(12);

        Compra compra = createMock(Compra.class);
        expect(compra.getId()).andReturn(1L);

        Produto produto = createMock(Produto.class);
        expect(produto.getId()).andReturn(null);

        replay(compra, produto);

        itemCompra.setCompra(compra);
        itemCompra.setProduto(produto);

        Assertions.assertThrows(RegraNegocioException.class, () -> {
            service.validar(itemCompra);
        });
    }

    @Test
    public void naoDeveValidarItemCompraSemQtdeComprada() {

        ItemCompra itemCompra = new ItemCompra();
        itemCompra.setQtdeProduto(null);

        Compra compra = createMock(Compra.class);
        expect(compra.getId()).andReturn(1L);

        Produto produto = createMock(Produto.class);
        expect(produto.getId()).andReturn(1L);

        replay(compra, produto);

        itemCompra.setCompra(compra);
        itemCompra.setProduto(produto);

        Assertions.assertThrows(RegraNegocioException.class, () -> {
            service.validar(itemCompra);
        });
    }

    @Test
    public void deveValidarItemCompra() {

        ItemCompra itemCompra = new ItemCompra();
        itemCompra.setQtdeProduto(12);


        Compra compra = createMock(Compra.class);
        expect(compra.getId()).andReturn(1L);

        Produto produto = createMock(Produto.class);
        expect(produto.getId()).andReturn(1L);

        replay(compra, produto);

        itemCompra.setCompra(compra);
        itemCompra.setProduto(produto);

        assertDoesNotThrow(() -> service.validar(itemCompra));
    }

}