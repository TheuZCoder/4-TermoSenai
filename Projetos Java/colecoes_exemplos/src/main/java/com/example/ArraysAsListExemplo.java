package com.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArraysAsListExemplo {

    private String[] nomes = new String[5];
    private final List<String> nomeList;

    public ArraysAsListExemplo() {
        nomes = new String[]{"João", "Maria", "José", "Ana", "Carlos"};
        nomeList = new ArrayList<>(Arrays.asList(nomes));
    }

    public void adicionarArray(String nome) {
        try {
            int posicao = nomes.length;
            nomes[posicao] = nome;
        } catch (Exception e) {
            System.out.println("Erro ao adicionar nome: " + e.getMessage());
        }finally{
            System.out.println(Arrays.toString(nomes));
        }
    }

    //alterar uma lista
    public void AdicionarLista(String nome) {
        try {
            nomeList.add(nome);
        } catch (Exception e) {
            System.out.println("Erro ao adicionar nome: " + e.getMessage());
        }finally{
            System.out.println(nomeList);
        }
    }
}
