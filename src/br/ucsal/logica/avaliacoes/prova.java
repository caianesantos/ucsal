package br.ucsal.logica.avaliacoes;

import java.util.Scanner;
public class prova {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite a 1° pontuação: ");
        int menor = sc.nextInt();
        int pontSuperior = 0;

        for (int i = 2; i <= 20; i++) {
            System.out.println("Digite a " + i + " pontuação: ");
            int pontuacao = sc.nextInt();
            if (pontuacao >= 70){
                pontSuperior ++;
            }
            if (pontuacao < menor){
                menor = pontuacao;
            }
        }
        System.out.println(pontSuperior + " candidatos obtiveram resultados maior ou igual a 70.");
        System.out.println("A menor pontuação lançada foi: " + menor);
    }
}
