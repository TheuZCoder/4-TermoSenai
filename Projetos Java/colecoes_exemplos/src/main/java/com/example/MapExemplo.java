package com.example;

import java.util.HashMap;
import java.util.Map;

public class MapExemplo {
    private Map<String, String> nomes;

    public MapExemplo() {
        nomes = new HashMap<>();
    }

    public void adicionar(String nome, String telefone) {
        nomes.put(nome, telefone);
        System.out.println(nome + " adicionado com sucesso!");
    }

    public void listarNomes() {
        if (nomes.isEmpty()) {
            System.out.println("Lista vazia!");
            return;
        }

        for (String nome : nomes.keySet()) {
            System.out.println(nome + " - " + nomes.get(nome));
        }
    }

    public void deleteNome(String nome) {
        if (nomes.isEmpty()) {
            System.out.println("Lista vazia!");
            return;
        }

        if (nomes.containsKey(nome)) {
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

        if (nomes.containsKey(nome)) {
            nomes.put(novoNome, nomes.get(nome));
            nomes.remove(nome);
            System.out.println(nome + " atualizado para " + novoNome + " com sucesso!");
        } else {
            System.out.println(nome + " não encontrado na lista!");
        }
    }
}
