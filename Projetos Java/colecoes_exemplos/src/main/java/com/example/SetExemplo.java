package com.example;

import java.util.Set;

public class SetExemplo {
    private Set<String> nomes;

    public SetExemplo(Set<String> nomes) {
        this.nomes = nomes;
    }

    public void adicionar(String nome) {
        nomes.add(nome);
        System.out.println(nome + " adicionado com sucesso!");
    }

    public void listarNomes() {
        if (nomes.isEmpty()) {
            System.out.println("Lista vazia!");
            return;
        }

        for (String nome : nomes) {
            System.out.println(nome);
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
            nomes.remove(nome);
            nomes.add(novoNome);
            System.out.println(nome + " atualizado para " + novoNome + " com sucesso!");
        } else {
            System.out.println(nome + " não encontrado na lista!");
        }
    }
}
