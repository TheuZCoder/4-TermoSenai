package com.theuz;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        GerenciamentoVendas gerenciamentoVendas = new GerenciamentoVendas();
        try (Scanner scanner = new Scanner(System.in)) {
            int operacao = 0;
            do {
                System.out.println("1 - Registrar venda");
                System.out.println("2 - Consultar vendas por cliente");
                System.out.println("3 - Consultar vendas acima de determinado valor");
                System.out.println("4 - Sair");
                operacao = scanner.nextInt();
                scanner.nextLine(); // Consumir a nova linha
                
                switch (operacao) {
                    case 1:
                        System.out.print("Digite o CPF do cliente: ");
                        String cpf = scanner.nextLine();
                        System.out.print("Digite o nome do produto: ");
                        String nomeProduto = scanner.nextLine();
                        System.out.print("Digite o valor do produto: ");
                        double valorProduto = scanner.nextDouble();
                        Produto produto = new Produto(nomeProduto, valorProduto);
                        gerenciamentoVendas.venda(cpf, produto);
                        break;
                    case 2:
                        System.out.print("Digite o CPF do cliente: ");
                        cpf = scanner.nextLine();
                        gerenciamentoVendas.consultarVendas(cpf);
                        break;
                    case 3:
                        System.out.print("Digite o valor mínimo: ");
                        double valor = scanner.nextDouble();
                        gerenciamentoVendas.consultarVendas(valor);
                        break;
                    case 4:
                        System.out.println("Saindo...");
                        break;
                    default:
                        System.out.println("Operação inválida");
                }
            } while (operacao != 4);
        }
    }
}