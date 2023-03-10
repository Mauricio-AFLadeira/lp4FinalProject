package com.example.lp4.api.dto;

import com.example.lp4.model.entity.Produto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProdutoDTO {

    private Long id;
    private String nome;
    private String descricao;
    private Integer valorUnitario;
    private String estoque;
    private Long idCategoria;
    private Long idMarca;

    public static ProdutoDTO create(Produto produto){
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(produto, ProdutoDTO.class);
    }
}
