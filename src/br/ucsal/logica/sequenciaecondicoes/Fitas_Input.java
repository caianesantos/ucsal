/*
Reescreva o programa anterior (FitasLocadoras) considerando que o mesmo deverá solicitar que:
 - o usuário informe o total de acervo existente e
 - quantas fitas existem no momento na loja de Itapuã e na Pituba.
 */

package br.ucsal.logica.sequenciaecondicoes;

import java.util.Scanner;

public class Fitas_Input {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        //Quantidades de fitas cadastradas
        System.out.println("Informe o total de fitas cadastras na loja da Pituba: ");
        int unPituba = sc.nextInt();
        System.out.println("Informe o total de fitas cadastras na loja de Itapuã: ");
        int unItapua = sc.nextInt();
        int totalFitas = unPituba + unItapua;
        System.out.println("Total de fitas nas 2 unidades: " + totalFitas);

        //Quantidade atual de fitas nas lojas
        System.out.println("Informe o total de fitas sem alugar na loja da Pituba: ");
        int atualPituba = sc.nextInt();
        System.out.println("Informe o total de fitas sem alugar na loja de Itapuã: ");
        int atualItapua = sc.nextInt();
        System.out.println("Total de fitas sem alugar: " + (atualPituba  + atualItapua));

        //Quantidade de fitas alugadas
        int alugadasPituba = unPituba - atualPituba;
        int alugadasItapua = unItapua - atualItapua;
        int fitasAlugadas = alugadasPituba + alugadasItapua;
        System.out.println("Fitas alugadas nas 2 unidades: " + fitasAlugadas);

        //Percentual de fitas alugadas
        float divisao = (float) fitasAlugadas / totalFitas;
        float percentual = divisao * 100;
        System.out.println("A quantidade de fitas alugadas:" +
                "\n - Na Pituba: " + alugadasPituba +
                "\n - Em Itapuã: " + alugadasItapua +
                "\n O percentual de fitas alugadas é de: " + percentual + " %");

    }
}
