package com.example;

import java.util.Arrays;
import java.util.List;

public class StreamExemplo {
    List<String> words = Arrays.asList("banana", "abacaxi", "ameixa", "uva", "amora");

    //Crie uma nova List resultado, filtro com palavras com letra 'A'
    public void filterWords() {
        List<String> resultado = words.stream()
                .filter(word -> word.startsWith("a"))
                .toList();

        System.out.println(resultado);
    }

    //metodo para deixar todas as palavras em maiusculas
    public void toUpperCase() {
        List<String> resultado = words.stream()
                .map(String::toUpperCase)
                .toList();

        System.out.println(resultado);
    }

}
