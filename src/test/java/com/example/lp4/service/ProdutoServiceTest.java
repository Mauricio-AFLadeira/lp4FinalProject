package com.example.lp4.service;

import com.example.lp4.exception.RegraNegocioException;
import com.example.lp4.model.entity.Categoria;
import com.example.lp4.model.entity.Marca;
import com.example.lp4.model.entity.Produto;
import org.easymock.EasyMock;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.easymock.EasyMock.*;
import static org.junit.jupiter.api.Assertions.*;

class ProdutoServiceTest {

    private ProdutoService produtoService;

    @BeforeEach
    void init(){
        this.produtoService = new ProdutoService();
    }

    @Test
    public void naoDeveValidarProdutoSemNome(){
        Produto produto = new Produto();
        produto.setNome(null);
        produto.setValorUnitario(111);

        Marca marca = createMock(Marca.class);
        expect(marca.getId()).andReturn(1L);

        Categoria categoria = createMock(Categoria.class);
        expect(categoria.getId()).andReturn(1L);

        replay(marca, categoria);

        produto.setCategoria(categoria);
        produto.setMarca(marca);

        Assertions.assertThrows(RegraNegocioException.class, () -> {
            produtoService.validar(produto);
        });
    }

    @Test
    public void naoDeveValidarProdutoSemValor(){
        Produto produto = new Produto();
        produto.setNome("produto");
        produto.setValorUnitario(null);

        Marca marca = createMock(Marca.class);
        expect(marca.getId()).andReturn(1L);

        Categoria categoria = createMock(Categoria.class);
        expect(categoria.getId()).andReturn(1L);

        replay(marca, categoria);

        produto.setCategoria(categoria);
        produto.setMarca(marca);

        Assertions.assertThrows(RegraNegocioException.class, () -> {
            produtoService.validar(produto);
        });
    }

    @Test
    public void naoDeveValidarCategoriaNula() {
        Produto produto = new Produto();
        produto.setNome("produto");
        produto.setValorUnitario(111);


        Marca marca = createMock(Marca.class);
        expect(marca.getId()).andReturn(1L);

        Categoria categoria = createMock(Categoria.class);
        expect(categoria.getId()).andReturn(null);

        replay(marca, categoria);

        produto.setCategoria(categoria);
        produto.setMarca(marca);

        Assertions.assertThrows(RegraNegocioException.class, () -> {
            produtoService.validar(produto);
        });
    }

    @Test
    public void naoDeveValidarMarcaNula() {
        Produto produto = new Produto();
        produto.setNome("produto");
        produto.setValorUnitario(111);


        Marca marca = createMock(Marca.class);
        expect(marca.getId()).andReturn(null);

        Categoria categoria = createMock(Categoria.class);
        expect(categoria.getId()).andReturn(1L);

        replay(marca, categoria);

        produto.setCategoria(categoria);
        produto.setMarca(marca);

        Assertions.assertThrows(RegraNegocioException.class, () -> {
            produtoService.validar(produto);
        });
    }

}