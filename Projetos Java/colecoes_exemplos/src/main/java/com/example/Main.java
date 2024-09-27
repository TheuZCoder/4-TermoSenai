package com.example;

import java.util.Set;

public class Main {
    public static void main(String[] args) {
        ListExemplo lista = new ListExemplo();
        SetExemplo conjunto = new SetExemplo();


        conjunto.adicionar("João");
        conjunto.adicionar("Maria");
        conjunto.adicionar("José");
        conjunto.adicionar("Ana");
        conjunto.adicionar("Carlos");
    
        conjunto.listarNomes();

        conjunto.deleteNome("Maria");
        conjunto.deleteNome("Pedro");

        conjunto.updateNome("José", "Joaquim");

        lista.adicionar("João");
        lista.adicionar("Maria");
        lista.adicionar("José");
        lista.adicionar("Ana");
        lista.adicionar("Carlos");

        lista.listarNomes();

        lista.deleteNome("Maria");
        lista.deleteNome("Pedro");

        lista.updateNome("José", "Joaquim");
    }
}