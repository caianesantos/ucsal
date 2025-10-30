//Escrever um programa que some duas matrizes A e B,
// colocando o resultado numa matriz C.
// (tamanho de A, B, e C = 3 linhas por 2 colunas).

package br.ucsal.logica.matriz;

import java.util.Scanner;

public class SomarMatriz {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int matA[][] = new int [3][2];
        System.out.println("------- MATRIZ A -------");
        lerMatriz(matA);
        System.out.println("Matriz A:");
        escreverMatriz(matA);
        int matB[][] = new int [3][2];
        System.out.println("------- MATRIZ B -------");
        lerMatriz(matB);
        System.out.println("Matriz B:");
        escreverMatriz(matB);
        int matC[][] = somarMatriz(matA, matB);
        System.out.println("------- MATRIZ C -------");
        escreverMatriz(matC);
    }

    public static void lerMatriz(int [][] mat){
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < mat.length; i++){
            for (int j = 0; j < mat[i].length; j++){
                System.out.print("Digite o valor para a linha [" + i + "] da coluna [" + j + "]: ");
                mat[i][j] = sc.nextInt();
            }
        }
    }

    public static void escreverMatriz(int [][] mat){
        for(int i = 0; i < mat.length; i++){
            for(int j = 0; j < mat[i].length; j++){
                System.out.println(mat[i][j]);
            }
            System.out.println();
        }
    }

    public static int[][] somarMatriz(int[][] mat1, int[][] mat2) {
        int linhas = mat1.length;
        int colunas = mat1[0].length;
        int[][] soma = new int[linhas][colunas];
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                soma[i][j] = mat1[i][j] + mat2[i][j];
            }
        }
        return soma;
    }
}
