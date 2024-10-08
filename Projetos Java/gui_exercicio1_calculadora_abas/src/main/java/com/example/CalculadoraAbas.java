package com.example;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class CalculadoraAbas extends JFrame{
    JTabbedPane abas = new JTabbedPane();
    JPanel simples = new CalculadoraSimples();
    JPanel avancada = new CalculadoraAvancada();
   
    public CalculadoraAbas(){
        super("Calculadora com Abas");
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        //adicionar componentes na janela
        add(abas);
        abas.addTab("Simples", simples);
        abas.addTab("Avançada", avancada);
        
    }
    
}
