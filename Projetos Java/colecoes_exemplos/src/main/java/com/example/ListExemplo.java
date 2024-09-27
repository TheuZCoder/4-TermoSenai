package com.example;

import java.util.ArrayList;
import java.util.List;

public class ListExemplo {
    private List<String> nomes;

    public ListExemplo() {
        nomes = new ArrayList<>();
    }

    public void adicionar(String nome) {
        nomes.add(nome);
        System.out.println(nomes.indexOf(nome) + " - " + nome + " adicionado com sucesso!");
    }

    public void listarNomes() {
        if (nomes.isEmpty()) {
            System.out.println("Lista vazia!");
            return;
        }

        for (String nome : nomes) {
            System.out.println(nomes.indexOf(nome) + " - " + nome);
        }
    }

    public void deleteNome(String nome) {
        if (nomes.isEmpty()) {
            System.out.println("Lista vazia!");
            return;
        }

        if (nomes.contains(nome)) {
            nomes.remove(nome);
            System.out.println(nome + " removido com sucesso!");
        } else {
            System.out.println(nome + " não encontrado na lista!");
        }
    }

    public void updateNome(String nome, String novoNome) {
        if (nomes.isEmpty()) {
            System.out.println("Lista vazia!");
            return;
        }

        if (nomes.contains(nome)) {
            nomes.set(nomes.indexOf(nome), novoNome);
            System.out.println(nome + " atualizado para " + novoNome + " com sucesso!");
        } else {
            System.out.println(nome + " não encontrado na lista!");
        }
    }    
}
