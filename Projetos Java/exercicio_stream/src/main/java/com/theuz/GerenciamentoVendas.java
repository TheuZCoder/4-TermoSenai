package com.theuz;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GerenciamentoVendas {
    private final Map<String, List<Produto>> vendaCliente;

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
        List<Produto> produtos = new ArrayList<>();
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

    //consultar vendas acima de determinado valor
    public void consultarVendas(double valor) {
        for (String cpf : vendaCliente.keySet()) {
            List<Produto> produtos = vendaCliente.get(cpf);
            for (Produto produto : produtos) {
                if (produto.getValor() > valor) {
                    System.out.println(produto.toString());
                }
            }
        }
    }
}
