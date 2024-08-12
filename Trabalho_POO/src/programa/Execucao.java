package programa;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import base_Dados.Base;
import funcaoReserva.Reserva;
import funcaoReserva.SolicitarLaboratorio;

public class Execucao {
    public static void main(String[] args) {
    	
    	   try {
    		   
    		   //instanciando objetos
    	        Base b = new Base();
    	        Impressao i = new Impressao();
    	        SolicitarLaboratorio solicitador = new SolicitarLaboratorio();
    	        Scanner sc = new Scanner(System.in);

    	        List<Reserva> reservas = new ArrayList<>(); // Initialize your list

    	        boolean continuar = true;

    	        do {
    	            i.printBaseInformation(b);
    	            
    	            //adicionando elementos no objeto reserva.
    	            Reserva novaReserva = solicitador.solicitarLaboratorio(
    	                    reservas,
    	                    b.getlaboratorios(),
    	                    b.getProfessores(b.getDepartamentos()),
    	                    b.getDisciplina(),
    	                    b.getAlunos()
    	            );

    	            if (novaReserva != null) {
    	                // Se não houver conflito, adiciona-se uma nova reserva na lista. 
    	                reservas.add(novaReserva);
    	                System.out.println("Solicitacao registrada com sucesso!");

    	                // printa o objeto reserva.
    	                System.out.println("Detalhes da Reserva:");
    	                System.out.println(novaReserva);
    	            } else {
    	                System.out.println("Falha ao registrar a solicitacao. Verifique se há conflitos.");
    	            }

    	            	//O usuário recenbe uma opção de continuar ou não.
    	            if (continuar) {
    	                System.out.println("Deseja fazer outra solicitacao? (s/n)");
    	                String resposta = sc.next().trim().toLowerCase();
    	                
    	                //se a resposta for "s" o código entrará em um loop até que o usuário decida parar.
    	                if (!resposta.equals("s")) {
    	                    continuar = false;
    	                }
    	            }

    	        } while (continuar);

    	        sc.close();
    	    } catch (Exception e) { //caso ocorra um erro a excessão abaixo ira trata-lo.
    	        System.out.println("Ocorreu um erro durante a execucao: " + e.getMessage());
    	        e.printStackTrace();
    	    }
}
}



