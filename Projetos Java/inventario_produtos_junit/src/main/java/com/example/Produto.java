package com.example;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Produto {

    //Atributos
    private int id_Produto;
    private String nome_Produto;
    private String fabricante_Produto;
    private double preco_Produto;
    private int quantidade_Produto;
}
