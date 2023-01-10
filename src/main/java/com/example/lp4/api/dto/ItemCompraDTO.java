package com.example.lp4.api.dto;

import com.example.lp4.model.entity.ItemCompra;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemCompraDTO {

    private  Long id;
    private Integer qtdeProduto;
    private Long idCompra;
    private Long idProduto;

    public static ItemCompraDTO create(ItemCompra itemCompra){
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(itemCompra, ItemCompraDTO.class);
    }
}
