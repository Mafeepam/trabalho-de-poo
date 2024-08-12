package funcaoReserva;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.Collections;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

import entidades.Aluno;
import entidades.Disciplina;
import entidades.Laboratorio;
import entidades.Professor;

public class SolicitarLaboratorio {
	
	  private static final int TEMPO_ENTRE_SOLICITACOES = 30; 

	    public Reserva solicitarLaboratorio(List<Reserva> reservas, List<Laboratorio> laboratorios,
	            List<Professor> professores, List<Disciplina> disciplinas, List<Aluno> alunos) {
	        Reserva reserva = new Reserva();

	        @SuppressWarnings("resource")
	        Scanner sc = new Scanner(System.in);

	        boolean inputValid = false;

	        while (!inputValid) {
	            try {
	                System.out.println("Informe o laboratorio que deseja reservar:");
	                for (int i = 0; i < laboratorios.size(); i++) {
	                    System.out.println("LAB" + (i + 1) + "-capacidade: " + laboratorios.get(i).getCapacidade());
	                }
	                int laboratorioIndex = sc.nextInt() - 1;
	                reserva.setLaboratorio(laboratorios.get(laboratorioIndex));

	                System.out.println("Informe o professor:");
	                for (int i = 0; i < professores.size(); i++) {
	                    System.out.println((i + 1) + "-" + professores.get(i).getNome());
	                }
	                int professorIndex = sc.nextInt() - 1;
	                reserva.setProfessor(professores.get(professorIndex));

	                System.out.println("Informe a disciplina:");
	                for (int i = 0; i < disciplinas.size(); i++) {
	                    System.out.println((i + 1) + "-" + disciplinas.get(i).getDescricao());
	                }
	                int disciplinaIndex = sc.nextInt() - 1;
	                reserva.setDisciplina(disciplinas.get(disciplinaIndex));

	                System.out.println("Por quantos minutos deseja utilizar este laboratorio?");
	                int minutos = sc.nextInt();
	                reserva.setMinutos(minutos);

	            
	                System.out.println("Informe a hora inicial da reserva (formato HH:mm):");
	                String horaInicialStr = sc.next();
	                LocalTime horaInicial = LocalTime.parse(horaInicialStr);
	                reserva.setHoraInicial(horaInicial);

	                System.out.println("Informe o dia da reserva (formato YYYY-MM-DD):");
	                String diaReservaStr = sc.next();
	                reserva.setDiaReserva(LocalDateTime.parse(diaReservaStr + "T00:00"));
	                Random rand = new Random();
	                reserva.setId(rand.nextInt(10000));

	            
	                if (hasConflict(reserva, reservas)) {
	                    System.out.println("Erro: Solicitacao em conflito com outra existente.");
	                    reserva.setSituacaoReprovada(); 
	                    return null; 
	                } else {
	                   
	                    int approvedReservationsCount = countApprovedProfessorReservations(reserva.getProfessor(),
	                            reservas);

	                    if (approvedReservationsCount < 6) {
	                        
	                        reserva.setSituacaoAprovada();
	                    } else {
	                       
	                        System.out.println("Aviso: O professor atingiu o limite máximo de 6 reservas aprovadas.");
	                        reserva.setSituacaoAprovada();
	                    }
	                }

	                List<Aluno> alunosSelecionados = selecionarAlunos(alunos, reserva.getLaboratorio().getCapacidade());
	                reserva.setAluno(alunosSelecionados); // Corrected line

	                reserva.setDataLiberacao(LocalDateTime.now());

	                inputValid = true; 
	            } catch (InputMismatchException e) {
	                System.out.println("Erro: Entrada invalida. Certifique-se de inserir um numero inteiro.");

	                
	                sc.nextLine(); 
	            } catch (DateTimeParseException e) {
	                System.out.println("Erro: Formato de data ou hora inválido. Certifique-se de inserir no formato correto.");
	                sc.nextLine(); 
	            }
	        }

	        return reserva;
	    }

	    private boolean hasConflict(Reserva novaReserva, List<Reserva> reservas) {
	       
	        for (Reserva reservaExistente : reservas) {
	            if (isOverlap(novaReserva, reservaExistente)) {
	                return true; 
	            }
	        }
	        return false;
	    }

	    private boolean isOverlap(Reserva reserva1, Reserva solicitacao2) {
	        
	        return reserva1.getDataLiberacao().equals(solicitacao2.getDataLiberacao())
	                && Math.abs(reserva1.getMinutos() - solicitacao2.getMinutos()) < TEMPO_ENTRE_SOLICITACOES;
	    }

	    private List<Aluno> selecionarAlunos(List<Aluno> alunos, int capacidadeLaboratorio) {
	    
	        Collections.shuffle(alunos);

	       
	        int numeroAlunosSelecionados = Math.min(alunos.size(), capacidadeLaboratorio);

	      
	        List<Aluno> alunosSelecionados = alunos.subList(0, numeroAlunosSelecionados);

	        
	        Set<Aluno> uniqueAlunos = new HashSet<>(alunosSelecionados);
	        alunosSelecionados.clear();
	        alunosSelecionados.addAll(uniqueAlunos);

	        return alunosSelecionados;
	    }

	    private int countApprovedProfessorReservations(Professor professor, List<Reserva> reservas) {
	       
	        int count = 0;
	        for (Reserva reserva : reservas) {
	            if (reserva.getProfessor().equals(professor) && reserva.isAprovada()) {
	                count++;
	            }
	        }
	        return count;
	    }
    	
}