package br.com.theuz.Calculadora;

import java.util.Scanner;

public class calculadoraBasica {
    public double num1, num2;
    public int escolha;
    Scanner scanner = new Scanner(System.in);

    public void lerNumeros() {
        try {
            if (escolha == 6) {
                
            } else if (escolha != 5) {
                System.out.println("Digite o primeiro número: ");
                num1 = scanner.nextDouble();
                System.out.println("Digite o segundo número: ");
                num2 = scanner.nextDouble(); 
            } else {
                System.out.println("Digite um número para realizar a operação escolhida.");
                System.out.println("Digite o primeiro número: ");
                num1 = scanner.nextDouble();
            }  
        } catch (Exception e) {
            System.out.println("Erro ao ler os números: " + e.getMessage());
        }
    }

    public void escolhaOperacao() {
        try {
            while (escolha != 6) {
                    System.out.println("Escolha a operação desejada: ");
                    System.out.println("1 - Soma");
                    System.out.println("2 - Subtração");
                    System.out.println("3 - Multiplicação");
                    System.out.println("4 - Divisão");
                    System.out.println("5 - Raiz Quadrada");
                    System.out.println("6 - Sair\n");
                    escolha = scanner.nextInt();
                
                lerNumeros();

                switch (escolha) {
                    case 1 -> System.out.println("\nResultado: " + somar(num1, num2)+ "\n");
                    case 2 -> System.out.println("\nResultado: " + subtrair(num1, num2)+ "\n");
                    case 3 -> System.out.println("\nResultado: " + multiplicar(num1, num2)+ "\n");
                    case 4 -> System.out.println("\nResultado: " + dividir(num1, num2)+ "\n");
                    case 5 -> System.out.println("\nResultado: " + raizQuadrada(num1) + "\n");
                    case 6 -> System.out.println("\nSaindo...");
                    default -> System.out.println("Operação inválida!");
                }
            }
        } catch (Exception e) {
            System.out.println("Erro ao escolher a operação: " + e.getMessage());
        }
    }
    
    
    public double somar(double num1, double num2) {
        try {
            return num1 + num2;
        } catch (Exception e) {
            System.out.println("Erro ao somar: " + e.getMessage());
            return 0;
        }
    }

    public double subtrair(double num1, double num2) {
        try {
            return num1 - num2;
        } catch (Exception e) {
            System.out.println("Erro ao subtrair: " + e.getMessage());
            return 0;
        }
    }

    public double multiplicar(double num1, double num2) {
        try {
            return num1 * num2;
        } catch (Exception e) {
            System.out.println("Erro ao multiplicar: " + e.getMessage());
            return 0;
        }
    }

    public double dividir(double num1, double num2) {
        try {
            return num1 / num2;
        } catch (Exception e) {
            System.out.println("Erro ao dividir: " + e.getMessage());
            return 0;
        }
    }

    public double raizQuadrada(double num) {
        try {
            if (num < 0) {
                throw new Exception("Número deve ser maior que zero.");
            }
            return Math.sqrt(num);
        } catch (Exception e) {
            System.out.println("Erro ao calcular a raiz quadrada: " + e.getMessage());
            return 0;
        }
    }   

}
