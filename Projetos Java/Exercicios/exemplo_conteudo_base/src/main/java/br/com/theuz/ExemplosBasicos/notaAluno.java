package br.com.theuz.ExemplosBasicos;

public class notaAluno {
    public double nota1, nota2, nota3, nota4;
    public double media;

    public void mediaNotas(double nota1, double nota2, double nota3, double nota4) {
        if (nota1 >= 8 || nota2 >= 8 || nota3 >= 8 || nota4 >= 8) {
            this.media = ((nota1 *= 1.1) + (nota2 *= 1.1) + (nota3 *= 1.1) + (nota4 *= 1.1)) / 4;
        } 
        this.media = (nota1 + nota2 + nota3 + nota4) / 4;
        if (this.media > 10) {
            this.media = 10;
        }
        System.out.println("A média do aluno é: " + this.media);
    }

    public void situacaoAluno(double media) {
        if (this.media >= 7) {
            System.out.println("Aluno aprovado!");
        } else if (this.media >= 5 || this.media <= 6.9) {
            System.out.println("Aluno esta de Recuperação!");
        } else if (this.media < 5) {
            System.out.println("Aluno reprovado!");
        } else if (this.media > 9) {
            System.out.println("Nota inválida!");
        }
    }
}

