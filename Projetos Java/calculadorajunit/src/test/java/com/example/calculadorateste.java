package com.example;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class calculadorateste {
    calculadora calc;
    @Before
    public void setUp() {
        calc = new calculadora();
    };

    @Test   
    public void testSoma() {
        assertEquals(4, calc.soma(2, 2));
    }

    @Test
    public void testeSubtracao() {
        assertEquals(2, calc.subtracao(4, 2));
    }

    @Test
    public void testeMultiplicacao() {
        assertEquals(6, calc.multiplicacao(2, 3));
    }

    @Test   
    public void testeDivisao() {
        assertEquals(1.5, calc.divisao(6, 4), 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testeDivisaoZero() {
        calc.divisao(6, 0);
    }

    @Test
    public void testePotencia() {
        assertEquals(8, calc.potencia(2, 3), 0);
    }

    @Test
    public void testeRaiz() {
    double resultado = calc.raiz(1024,10);
    assertEquals(2, resultado, 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testeRaizZero() {
        calc.raiz(1024, 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testeRaizNegativa() {
        calc.raiz(1024, -2);
    }
}
