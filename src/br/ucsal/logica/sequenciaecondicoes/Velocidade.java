//Escreva um programa que leia uma velocidade em km/h e
// imprima o resultado em m/s, da seguinte forma:
// “ xxx km/h equivalem a yyy m/s”
//obs: 3,6 km/h = 1 m/s

package br.ucsal.logica.sequenciaecondicoes;

import java.util.Scanner;

public class Velocidade {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite uma velocidade (km/h): ");
        float velocidade = sc.nextFloat();
        System.out.println(converterVelocidade(velocidade));
    }
    public static float converterVelocidade(float velKm) {
        float velMs = velKm /3.6f;
        return velMs;
    }
}
