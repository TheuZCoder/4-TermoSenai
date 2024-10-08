package com.example;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

public class SimplesActionListener implements ActionListener{
    private double valorAtual;
    JPanel calcSimples = new CalculadoraSimples();

    @Override
    public void actionPerformed(ActionEvent e) {
       String comando = e.getActionCommand();

       if (comando.equals("C")) {
           valorAtual = 0;
           ((CalculadoraSimples) calcSimples).setDisplaySimples("0");
       } else if (comando.equals("=")) {
           String display = ((CalculadoraSimples) calcSimples).getDisplaySimples();
           double resultado = Double.parseDouble(display);
           ((CalculadoraSimples) calcSimples).setDisplaySimples(String.valueOf(resultado));
       } else {
           String display = ((CalculadoraSimples) calcSimples).getDisplaySimples();
           if (display.equals("0")) {
               ((CalculadoraSimples) calcSimples).setDisplaySimples(comando);
           } else {
               ((CalculadoraSimples) calcSimples).setDisplaySimples(display + comando);
           }
       }
    }
    
}
