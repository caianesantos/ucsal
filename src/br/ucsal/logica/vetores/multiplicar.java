// Escreva um programa que leia um vetor com 8 elementos,
// e imprima a multiplicação dos elementos lidos.

package br.ucsal.logica.vetores;

import java.util.Scanner;

public class multiplicar {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int vet[] = new int[6];
        int i, k, soma = 0;
        System.out.println("Digite 6 números: ");
        for(i = 0; i < 6; i++){
            vet[i] = sc.nextInt();
        }
        k=5;
        for(i = 0; i < 3; i++){
            soma = vet[i] + vet[k];
            System.out.println(soma + " ");
            k = k - 1;
        }
    }
}
