package com.example;

import java.util.ArrayList;
import java.util.List;

public class Inventario {
    List<Produto> list;

    public Inventario() {
        this.list = new ArrayList<>();
    }

    //métodos

    public void createProduto(Produto produto) {
        list.add(produto);
    }

    public List<Produto> readProduto() {
        return new ArrayList<>(list);
    }
    
    public void updateProduto(int id_produto, int quantidade_produto, int preco_produto) {
        for (Produto produto : list) {
            if (produto.getId_Produto() == id_produto) {
                produto.setQuantidade_Produto(quantidade_produto);
                produto.setPreco_Produto(preco_produto);
                break;
            }
        }   
    }

    public void deleteProduto(int id_produto) {
        list.removeIf(produto -> produto.getId_Produto() == id_produto);
    }



}
