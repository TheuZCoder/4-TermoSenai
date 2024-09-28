package com.theuz;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter

public class Produto {
    private String nome;
    private double Valor;
    //to string

    @Override
    public String toString() {
        return "Produto{" +
                "nome='" + nome + '\'' +
                ", Valor=" + Valor +
                '}';
    }
}
