package com.example.lp4.api.dto;

import com.example.lp4.model.entity.Categoria;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoriaDTO {

    private Long id;
    private String nome;
    private Long idCategoriaPai;

    public static CategoriaDTO create(Categoria categoria){
        //ModelMapper modelMapper = new ModelMapper();
        //return modelMapper.map(categoria, CategoriaDTO.class);
        CategoriaDTO dto = new CategoriaDTO();
        dto.setId(categoria.getId());
        dto.setNome(categoria.getNome());
        if(categoria.getCategoriaPai()!=null) {
            dto.setIdCategoriaPai(categoria.getCategoriaPai().getId());
        }
        return  dto;
    }
}
