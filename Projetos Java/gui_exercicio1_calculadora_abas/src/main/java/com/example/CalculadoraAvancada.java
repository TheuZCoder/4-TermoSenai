package com.example;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CalculadoraAvancada extends JPanel{
     JPanel painelBotoes = new JPanel(new GridLayout(5, 4, 3,3));
    
    JTextField displaySimples;
    String[] botoes = {"^", "sqrt", "log", "!",
                       "7", "8", "9", "/", 
                       "4", "5", "6", "*", 
                       "1", "2", "3", "-", 
                       "0", "C", "=", "+"
                    };

    public CalculadoraAvancada(){
        super(new BorderLayout());
        displaySimples = new JTextField();
        displaySimples.setEditable(false);
        displaySimples.setHorizontalAlignment(JTextField.RIGHT);
        add(displaySimples, BorderLayout.NORTH);

       for (String textobotao : botoes) {
            JButton botao = new JButton(textobotao);
            painelBotoes.add(botao);
        }
        add(painelBotoes, BorderLayout.CENTER);
       

    

    }
}
