package com.example;

public class calculadora {
    
    //Soma
    public int soma (int a, int b) {
    return a + b;
    
    //Subtração
    }
    public int subtracao (int a, int b) {
    return a - b;
    
    //Multiplicação
    }   
    public int multiplicacao (int a, int b) {
    return a * b;

    //Divisão
    }
    public double divisao (double a, double b) {
        if (b == 0) {
            throw new IllegalArgumentException("Divisão por zero não é aceita");
        }else{
            return a / b;
        }
    }

    //Potência
    public double potencia (double a, double b){
        return Math.pow(a, b);
    }

    //Raiz
    public double raiz (double a, double b){
        if (b <= 0) {
            throw new IllegalArgumentException("Raiz de índice zero ou negativo não é aceita");
        }
        double raiz = 1/b;
        if (a < 0 && b % 2 == 0) {
            throw new ArithmeticException("Raiz de índice par não é aceita para números negativos");
        }
        return Math.pow(a, raiz);
    }
}