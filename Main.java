package org.example;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Operacoes op = new Operacoes(); // Instância da classe que fará o cálculo da expressão
        Scanner scanner = new Scanner(System.in); // Para ler entrada do usuário

        System.out.println("=== Calculadora Pós-Fixada ===");
        System.out.println("Digite expressões em notação pós-fixada separadas por espaço.");
        System.out.println("Exemplo: 5 1 2 + 4 * + 3 -");
        System.out.println("Digite 'sair' para encerrar.");

        while (true) {
            System.out.print("\n> ");
            String entrada = scanner.nextLine().trim();

            if (entrada.equalsIgnoreCase("sair")) {
                System.out.println("Encerrando a calculadora...");
                break;
            }

            if (entrada.isEmpty()) {
                System.out.println("Expressão vazia. Tente novamente.");
                continue;
            }

            // Criação da fila dinâmica com os tokens da expressão
            Queue<String> expressaoPosfixa = new LinkedList<>();
            for (String token : entrada.split("\\s+")) {
                expressaoPosfixa.add(token); // Adiciona cada token na fila
            }

            try {
                double resultado = op.calcularPosfixa(expressaoPosfixa); // Processa a fila com uma pilha
                System.out.println("Resultado: " + resultado);
            } catch (Exception e) {
                System.out.println("Erro no cálculo: " + e.getMessage()); // Exibe erro detalhado
            }
        }

        scanner.close(); // Fecha o scanner ao final
    }
}
