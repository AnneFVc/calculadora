package org.example;

import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static void main(String[] args) {
        Operacoes op = new Operacoes();

        // Exemplo expressão pós-fixada: "5 1 2 + 4 * + 3 -"
        Queue<String> expressaoPosfixa = new LinkedList<>();
        expressaoPosfixa.add("5");
        expressaoPosfixa.add("1");
        expressaoPosfixa.add("2");
        expressaoPosfixa.add("+");
        expressaoPosfixa.add("4");
        expressaoPosfixa.add("*");
        expressaoPosfixa.add("+");
        expressaoPosfixa.add("3");
        expressaoPosfixa.add("-");

        try {
            double resultado = op.calcularPosfixa(expressaoPosfixa);
            System.out.println("Resultado da expressão pós-fixada: " + resultado);
        } catch (Exception e) {
            System.out.println("Erro no cálculo: " + e.getMessage());
        }
    }
}
