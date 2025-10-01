/*
O número 3025 tem uma propriedade interessante: 30 + 25 = 55 e (55)^2 = 3025.
Escreva um programa que lê um número inteiro e determinar se ele possui ou não essa propriedade.
 */

package br.ucsal.logica.sequenciaecondicoes;

import java.util.Scanner;

public class Propriedade {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Digite o número da propriedade (com 4 dígitos): ");
        int numero = in.nextInt();
        int divisao = numero /100;
        System.out.println(divisao);
        int resto = numero % 100;
        System.out.println(resto);
        int soma = divisao + resto;
        System.out.println(divisao + " + " + resto + " = " + soma);
        int resultado = (int)Math.pow(soma,2);
        System.out.println(soma + "^2 " + " = " + resultado);

    }
}
