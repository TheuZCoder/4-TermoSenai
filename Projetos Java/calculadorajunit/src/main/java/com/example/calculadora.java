package com.example;

public class calculadora {
    public int soma (int a, int b) {
    return a + b;
    }
    public int subtracao (int a, int b) {
    return a - b;
    }   
    public int multiplicacao (int a, int b) {
    return a * b;
    }
    public double divisao (double a, double b) {
        if (b == 0) {
            throw new IllegalArgumentException("Divisão por zero não é aceita");
        }else{
            return a / b;
        }
    }
}