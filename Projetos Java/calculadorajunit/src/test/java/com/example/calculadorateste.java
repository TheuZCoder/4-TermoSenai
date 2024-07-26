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
}
