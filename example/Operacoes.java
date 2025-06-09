package org.example;

import java.util.Queue;
import java.util.Stack;

public class Operacoes {

    // Verifica se a string é um número (inteiro ou decimal)
    public boolean isNumero(String s) {
        try {
            Double.parseDouble(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    // Aplica a operação matemática entre dois operandos
    public double aplicarOperacao(double a, double b, String operacao) {
        return switch (operacao) {
            case "+" -> a + b;
            case "-" -> a - b;
            case "*" -> a * b;
            case "/" -> {
                if (b == 0) {
                    throw new ArithmeticException("Erro: Divisão por zero");
                }
                yield a / b;
            }
            case "%" -> {
                if (b == 0) {
                    throw new ArithmeticException("Erro: Divisão por zero no operador módulo");
                }
                yield a % b;
            }
            default -> throw new IllegalArgumentException("Operador inválido: " + operacao);
        };
    }

    // Calcula a expressão pós-fixa recebida em forma de fila de tokens (operandos e operadores)
    public double calcularPosfixa(Queue<String> expressaoPosfixa) {
        Stack<Double> pilha = new Stack<>();

        while (!expressaoPosfixa.isEmpty()) {
            String token = expressaoPosfixa.poll();

            if (isNumero(token)) {
                // Se for número, empilha
                pilha.push(Double.parseDouble(token));
            } else {
                // Se for operador, verifica se há operandos suficientes na pilha
                if (pilha.size() < 2) {
                    throw new IllegalStateException("Erro: Operandos insuficientes para o operador '" + token + "'");
                }
                double b = pilha.pop();
                double a = pilha.pop();

                double resultado = aplicarOperacao(a, b, token);
                pilha.push(resultado);
            }
        }

        // Ao final, deve ter exatamente um resultado na pilha, caso contrário expressão malformada
        if (pilha.size() != 1) {
            throw new IllegalStateException("Erro: Expressão malformada, número inválido de operandos e operadores");
        }

        return pilha.pop();
    }
}
