//Escrever um programa que leia os elementos de uma matriz M (5,2)
// e imprime como resultado o produto dos elementos desta matriz.

package br.ucsal.logica.matriz;

import java.util.Scanner;

public class Produto {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M [][] = new int [5][2];
        System.out.println("MATRIZ:");
        lerMatriz(M, sc);
        mostrarMatriz(M);
        long resultado = calcularProduto(M);
        System.out.println("O produto de todos os elementos é: " + resultado);

    }

    public static void lerMatriz(int[][] elementos, Scanner sc) {
        for (int i = 0; i < elementos.length; i++) {
            for (int j = 0; j < elementos[i].length; j++) {
                System.out.println("Digite o elemento [" + i + "][" + j + "]: ");
                elementos[i][j] = sc.nextInt();
            }
        }
    }
    public static void mostrarMatriz(int[][] elementos){
        for (int i = 0; i < elementos.length; i++) {
            for (int j = 0; j < elementos[i].length; j++) {
                System.out.print("[" + elementos[i][j] + "] ");
            }
            System.out.println();
        }
    }

    public static long calcularProduto(int[][] p1){
        long calc = 1;
        for (int i = 0; i < p1.length; i++) {
            for (int j = 0; j < p1[i].length; j++) {
                calc *= p1[i][j];
            }
        }
        return(calc);
    }
}
