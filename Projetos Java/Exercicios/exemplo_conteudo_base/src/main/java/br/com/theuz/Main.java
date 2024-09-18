package br.com.theuz;

import java.util.Scanner;

import br.com.theuz.ExemplosBasicos.notaAluno;

public class Main {
    public static void main(String[] args) {
        int nota1, nota2, nota3, nota4;
        notaAluno aluno;
        
        try (Scanner scanner = new Scanner(System.in)) {
            aluno = new notaAluno();
            System.out.println("Digite a primeira nota: ");
            nota1 = scanner.nextInt();
            System.out.println("Digite a segunda nota: ");
            nota2 = scanner.nextInt();
            System.out.println("Digite a terceira nota: ");
            nota3 = scanner.nextInt();
            System.out.println("Digite a quarta nota: ");
            nota4 = scanner.nextInt();
        }

        aluno.mediaNotas(nota1, nota2, nota3, nota4);
        aluno.situacaoAluno(aluno.media);
    }
}