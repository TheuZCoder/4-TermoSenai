package com.example;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CalculadoraSimples extends JPanel {
    // ATRIBUTOS
    JTextField displaySimples;
    String[] botoes = { "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "0", "=", "+", "C" };

    // CONSTRUTOR
    public CalculadoraSimples() {
        super(new BorderLayout());
        displaySimples = new JTextField();
        displaySimples.setHorizontalAlignment(JTextField.RIGHT);
        displaySimples.setEditable(false);
        this.add(displaySimples, BorderLayout.NORTH);

        // Criar um Painel para os botões
        JPanel painelBotoes = new JPanel(new GridLayout(4, 4, 3, 3));
        for (String textoBotoes : botoes) {
            JButton botao = new JButton(textoBotoes);
            botao.addActionListener(new Handler1());
            painelBotoes.add(botao);
        }
        this.add(painelBotoes, BorderLayout.CENTER);
    }

    // altera valor display
    public void setDisplay(String texto) {
        this.displaySimples.setText(texto);
    }

    // pega valor display
    public String getDisplay() {
        return displaySimples.getText();
    }

    public class Handler1 implements ActionListener {
        double valorAtual;
        String operador;

        @Override
        public void actionPerformed(ActionEvent e) {

            String comando = e.getActionCommand();

            
            if (comando.matches("\\d")) {
                displaySimples.setText(displaySimples.getText() + comando);
            } else if (comando.matches("[+\\-*/]")) {
                valorAtual = Double.parseDouble(displaySimples.getText());
                operador = comando;
                displaySimples.setText("");
            } else if (comando.equals("=")) {
                double segundoValor = Double.parseDouble(displaySimples.getText());
                double resultado = 0;

                switch (operador) {
                    case "+":
                        resultado = valorAtual + segundoValor;
                        break;
                    case "-":
                        resultado = valorAtual - segundoValor;
                        break;
                    case "*":
                        resultado = valorAtual * segundoValor;
                        break;
                    case "/":
                        resultado = valorAtual / segundoValor;
                        break;
                }
                displaySimples.setText(String.valueOf(resultado));
            } else if (comando.equals("C")) {
                displaySimples.setText("");
                valorAtual = 0;
            }

        }
    }
}