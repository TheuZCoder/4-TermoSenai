package com.theuz;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GerenciamentoVendas {
    private Map<String, List<Produto>> vendaCliente = new HashMap<>();

    public GerenciamentoVendas() {
        vendaCliente = new HashMap<>();
    }   

    //registrar venda idCliente, produto
    public void venda(String cpf, Produto produto) {
        for (String cpfCliente : vendaCliente.keySet()) {
            if (cpfCliente.equals(cpf)) {
                List<Produto> produtos = vendaCliente.get(cpfCliente);
                produtos.add(produto);
                vendaCliente.put(cpfCliente, produtos);
                return;
            } 
        }
        List<Produto> produtos = vendaCliente.get(cpf);
        produtos.add(produto);
        vendaCliente.put(cpf, produtos);
    }

    //consultar vendas por cliente
    public void consultarVendas(String cpf) {
        List<Produto> produtos = vendaCliente.getOrDefault(cpf, Collections.emptyList());
        if (produtos.isEmpty()) {
            System.out.println("Nenhuma venda encontrada para o cliente com CPF: " + cpf);
        } else {
            for (Produto produto : produtos) {
                System.out.println(produto.toString());
            }
        }
    }
}
