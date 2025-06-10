package org.example;

import java.util.Queue;
import java.util.Stack;

public class Operacoes {

    // Verifica se a string é um número válido (inteiro ou real)
    public boolean isNumero(String s) {
        try {
            Double.parseDouble(s); // Tenta converter
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    // Realiza a operação entre dois números
    public double aplicarOperacao(double a, double b, String operacao) {
        return switch (operacao) {
            case "+" -> a + b;
            case "-" -> a - b;
            case "*" -> a * b;
            case "/" -> {
                if (b == 0) throw new ArithmeticException("Erro: Divisão por zero");
                yield a / b;
            }
            case "%" -> {
                if (b == 0) throw new ArithmeticException("Erro: Divisão por zero no operador módulo");
                yield a % b;
            }
            default -> throw new IllegalArgumentException("Operador inválido: " + operacao);
        };
    }

    // Calcula a expressão usando pilha
    public double calcularPosfixa(Queue<String> expressaoPosfixa) {
        Stack<Double> pilha = new Stack<>(); // Pilha para cálculo

        while (!expressaoPosfixa.isEmpty()) {
            String token = expressaoPosfixa.poll(); // Remove da fila

            if (isNumero(token)) {
                pilha.push(Double.parseDouble(token)); // Se for número, empilha
            } else {
                if (pilha.size() < 2) {
                    throw new IllegalStateException("Erro: Operandos insuficientes para o operador '" + token + "'");
                }
                double b = pilha.pop(); // Último número
                double a = pilha.pop(); // Penúltimo número

                double resultado = aplicarOperacao(a, b, token); // Aplica operação
                pilha.push(resultado); // Empilha resultado
            }
        }

        if (pilha.size() != 1) {
            throw new IllegalStateException("Erro: Expressão malformada, número inválido de operandos e operadores");
        }

        return pilha.pop(); // Retorna o resultado final
    }
