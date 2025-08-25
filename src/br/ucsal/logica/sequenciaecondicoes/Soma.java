/*
Escreva um programa que leia dois números e imprima a sua soma.
 */

package br.ucsal.logica.sequenciaecondicoes;

import java.util.Scanner;

public class Soma {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite um número: ");
        int num1 = sc.nextInt();
        System.out.println("Digite outro numero: ");
        int num2 = sc.nextInt();
        int soma = num1 + num2;
        System.out.println("A soma entre " + num1 + " + " + num2 + " = " + soma);

    }
}
