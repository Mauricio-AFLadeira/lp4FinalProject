package com.example.lp4.api.dto;

import com.example.lp4.model.entity.Fornecedor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FornecedorDTO {

    private Long id;
    private String senha;
    private String telefone;
    private String email;
    private String nome;
    private String cnpj;
    private String responsavel;
    private String empresa;
    private Date dataEntrega;
    private String logradouro;
    private Integer numero;
    private String complemento;
    private String bairro;
    private String cidade;
    private String uf;
    private String cep;

    public static FornecedorDTO create(Fornecedor fornecedor){
        ModelMapper modelMapper = new ModelMapper();
        FornecedorDTO dto = modelMapper.map(fornecedor, FornecedorDTO.class);
        dto.logradouro= fornecedor.getEndereco().getLogradouro();
        dto.numero= fornecedor.getEndereco().getNumero();
        dto.complemento= fornecedor.getEndereco().getComplemento();
        dto.bairro= fornecedor.getEndereco().getBairro();
        dto.cidade= fornecedor.getEndereco().getCidade();
        dto.uf= fornecedor.getEndereco().getUf();
        dto.cep= fornecedor.getEndereco().getCep();
        return dto;
    }
}
