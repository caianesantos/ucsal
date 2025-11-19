//Escreva um programa que tendo como dados de entrada a altura e o sexo de uma pessoa,
//calcule o seu peso ideal, utilizando as seguintes fórmulas:
//Para homens = (72.7 * h) – 44.7
//Para mulheres = (62.1 * h) – 44.7

package br.ucsal.logica.sequenciaecondicoes;

import java.util.Scanner;

public class PesoIdeal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o seu altura atual: ");
        float altura = sc.nextFloat();
        System.out.println("Digite o seu sexo(M/F): ");
        char sexo = sc.next().charAt(0);
        System.out.println("O seu peso ideal seria: "+ pesoIdeal(altura,sexo));
    }

    public static float pesoIdeal(float altura, char sexo) {
        float pesoIdeal = 0;
        if (sexo == 'M' || sexo == 'm') {
            pesoIdeal = (72.7f * altura) - 44.7f;
        }
        else if (sexo == 'F' || sexo == 'f') {
            pesoIdeal = (62.1f * altura) - 44.7f;
        }
        return pesoIdeal;
    }
}
