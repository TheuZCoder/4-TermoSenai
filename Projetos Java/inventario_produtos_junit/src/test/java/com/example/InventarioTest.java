package com.example;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class InventarioTest {
    private Inventario inventario;

    @Before
    public void setup() {
        inventario = new Inventario();
    }

    @Test
    public void testCreateProduto() {
        Produto produto = new Produto(1, "Produto 1", "Fabricante 1", 10.0, 5);
        inventario.createProduto(produto);
        assertEquals(1, inventario.readProduto().size());
    }   

    @Test
    public void testeDeleteProduto(){
        testCreateProduto();
        inventario.deleteProduto(1);
        assertEquals(0, inventario.readProduto().size());
    }

    @Test 
    public void testUpdateProduto(){
        testCreateProduto();
        inventario.updateProduto(1, 20, 89);
        assertEquals(20, inventario.readProduto().get(0).getQuantidade_Produto());
        assertEquals(89, inventario.readProduto().get(0).getPreco_Produto(), 0.01);
        
    }
}
