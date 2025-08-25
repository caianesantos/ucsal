/*
Escreva um programa capaz de:
 - calcular o preço médio da gasolina ((p1 + p2 + p3)/3
 - considerando três postos de combustível de Salvador.
 - É necessário fazer a leitura do preço da gasolina nos três postos.
 */

package br.ucsal.logica.sequenciaecondicoes;

import java.util.Locale;
import java.util.Scanner;

public class PrecoGasolina {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in).useLocale(Locale.US);;

        System.out.println("Digite o valor do primeiro posto: ");
        double p1 = sc.nextDouble();

        System.out.println("Digite o valor do segundo posto: ");
        double p2 = sc.nextDouble();

        System.out.println("Digite o valor do terceiro posto: ");
        double p3 = sc.nextDouble();

        double media = (p1 + p2 + p3)/3;
        System.out.println("O preço médio da gasolina em Salvador é: " + media);
    }
}
