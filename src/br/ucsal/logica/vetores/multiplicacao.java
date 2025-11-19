//Escreva um programa que leia um vetor com 8 elementos,
// e imprima a multiplicação dos elementos lidos.
package br.ucsal.logica.vetores;

import java.util.Scanner;

public class multiplicacao {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int vet[] = new int [8];
        lerVetor(vet, sc);
        System.out.println("A multiplicação dos valores no vetor é: " + multiplicar(vet));
    }

    public static void lerVetor(int vet [], Scanner sc){
        for(int i=0; i<vet.length; i++){
            System.out.println("Digite o "+(i+1)+"° valor: ");
            vet[i] = sc.nextInt();
        }
    }

    public static int multiplicar(int vet[]){
        int resultado = 1;
        for (int i=0; i<vet.length; i++){
            resultado = resultado * vet[i];
        }
        return resultado;
    }
}
