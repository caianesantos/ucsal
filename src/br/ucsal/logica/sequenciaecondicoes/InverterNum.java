//Escreva um programa que leia um número de três algarismos
// e mostre o número inversamente.
// Utilize as operações de { %, /, *, + } para resolver a questão.
//Exemplo: 365 deve ser escrito como 563.

package br.ucsal.logica.sequenciaecondicoes;

import java.util.Scanner;

public class InverterNum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite um numero de 3 algarismos (ex: 365): ");
        int num = sc.nextInt();
        System.out.println(inverterNum(num));


    }
    public static int inverterNum(int num) {
        int r1 = 0;
        int resto1 = 0;
        int r2 = 0;
        int resto2 = 0;
        int r3 = 0;
        int rTotal = 0;
        for (int i = 1; i <= 3; i++) {
            if (i == 1) {
                r1 = num / 100;
                resto1 = num % 100;
            }
            if (i == 2) {
                r2 = resto1 / 10;
                resto2 = resto1 % 10;
            }
            if (i == 3) {
                r3 = resto2 / 1;
            }
            rTotal = (r3*100) + (r2*10) + (r1*1);
        }
        return rTotal;
    }
}
