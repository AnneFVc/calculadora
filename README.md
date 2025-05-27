# calculadora
Calculadora Pós-Ordem (Notação Pós-Fixada)

Objetivo

Desenvolver uma aplicação em Java capaz de calcular expressões aritméticas na notação pós-ordem (pós-fixada), simulando o comportamento de uma calculadora científica. A implementação deve fazer uso de estruturas de dados, especificamente fila dinâmica e pilha (dinâmica ou estática).

-Como Usar:
1. Após executar, o programa exibirá uma mensagem inicial.

2. Digite a expressão desejada no formato pós-fixado, separando os elementos com espaço.

3. Pressione Enter para calcular.

4. Para sair do programa, digite sair.

-Operadores Suportados:
+	|  Adição	                    3 4 +
- | 	Subtração                	10 2 -
* | 	Multiplicação            	5 6 *
/	|  Divisão (com validação)  	8 2 /
%	|  Módulo (resto)            	10 3 %

-Exemplos:
Entrada             Saída
3 4 +              |    7.0
5 1 2 + 4 * + 3 -  |    14.0
2 3 1 * + 9 -	     |    -4.0
10 3 % 4 +	       |    5.0

-Validações e Tratamento de Erros:
A calculadora verifica e notifica o usuário nos seguintes casos:

X Divisão por zero.

X Expressão malformada (operandos ou operadores a mais ou a menos).

X Operador inválido.

X Elemento não numérico ou não reconhecido.

-Estrutura Interna:
Main.java: Interface de entrada via terminal e loop interativo.

Operacoes.java: Lógica de validação e cálculo da expressão.

Uso de Queue (fila dinâmica) e Stack (pilha) para processar a notação pós-fixada.

Autoria
Desenvolvido por:  Anne Feitoza Vasconcelos, Emily dos Santos Miranda,  Jose Carlos Placido de Souza Correia, Micael Melo Tanner.  

Projeto acadêmico – Estrutura de Dados




