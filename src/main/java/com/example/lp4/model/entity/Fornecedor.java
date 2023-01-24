package com.example.lp4.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Fornecedor extends Pessoa{

    private String responsavel;
    private String cnpj;
    private Date dataEntrega;
    private String empresa;
}

