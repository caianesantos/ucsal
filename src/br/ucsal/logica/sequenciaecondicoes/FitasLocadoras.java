/*
Uma locadora tem duas unidades na cidade, uma na Pituba e outra em Itapuã. (ler 2 unidades)
Faça um programa que informe quantas fitas existem no momento com clientes
considerando que o acervo total é de 4000 fitas divididas igualmente entre as duas unidades (4000/2)
e que existem respectivamente 1.620 e 1710 fitas no momento na loja da Pituba e na loja de Itapuã.
O programa deve informar na tela a quantidade de fitas com os clientes da Pituba,
com os clientes de Itapuã e o percentual total de fitas com clientes.
 */
package br.ucsal.logica.sequenciaecondicoes;

public class FitasLocadoras {
    public static void main(String[] args){
      int unPituba = 2000;
      int unItapua = 2000;
      int totalFitas = unPituba + unItapua;
        System.out.println("Total de fitas nas 2 unidades: " + totalFitas);

      int atualPituba = 1620;
      int atualItapua = 1710;

        System.out.println("Total de fitas sem alugar: " + (atualPituba  + atualItapua));

      int alugadasPituba = unPituba - atualPituba;
      int alugadasItapua = unItapua - atualItapua;
      int fitasAlugadas = alugadasPituba + alugadasItapua;
        System.out.println("Fitas alugadas nas 2 unidades: " + fitasAlugadas);

      float divisao = (float) fitasAlugadas / totalFitas;
      float percentual = divisao * 100;
        System.out.println("A quantidade de fitas alugadas:" +
                "\n - Na Pituba: " + alugadasPituba +
                "\n - Em Itapuã: " + alugadasItapua +
                "\n O percentual de fitas alugadas é de: " + percentual + " %");


    }
}
