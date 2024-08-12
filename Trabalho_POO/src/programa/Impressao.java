package programa;

import java.util.List;

import base_Dados.Base;
import entidades.Aluno;
import entidades.Departamento;
import entidades.Disciplina;
import entidades.Laboratorio;
import entidades.Professor;

//Neste método ocorre a chamada dos métodos auxiliares, criados para trazer os atributos dos objetos, para que possam ter os atributos printados.
public class Impressao {
	
	 public  void printBaseInformation(Base base) {
	        System.out.println("Departamentos:");
	        printDepartamentos(base.getDepartamentos());

	        System.out.println("\nDisciplinas:");
	        printDisciplinas(base.getDisciplina());

	        System.out.println("\nLaboratorios:");
	        printLaboratorios(base.getlaboratorios());

	        System.out.println("\nProfessores:");
	        printProfessores(base.getProfessores(base.getDepartamentos()));

	        System.out.println("\nAlunos:");
	        printAlunos(base.getAlunos());
	    }
	 	
	 
	 	//Aqui ocorre a criação dos métodos auxiliares que vão trazer os atributos dos objetos 
	    private void printDepartamentos(List<Departamento> departamentos) {
	        for (Departamento dep : departamentos) {
	            System.out.println(dep.getId() + ": " + dep.getSigla() + " - " + dep.getDescricao());
	        }
	    }

	    private void printDisciplinas(List<Disciplina> disciplinas) {
	        for (Disciplina disc : disciplinas) {
	            System.out.println(disc.getId() + ": " + disc.getSigla() + " - " + disc.getDescricao());
	        }
	    }

	    private void printLaboratorios(List<Laboratorio> laboratorios) {
	        for (Laboratorio lab : laboratorios) {
	            System.out.println("LAB" + lab.getId() + ": Capacidade " + lab.getCapacidade() + ", Status " + lab.getStatus());
	        }
	    }

	    private void printProfessores(List<Professor> professores) {
	        for (Professor prof : professores) {
	            System.out.println(prof.getId() + ": " + prof.getNome() + " - Departamento: " + prof.getDepartamento().getSigla());
	        }
	    }

	    private void printAlunos(List<Aluno> alunos) {
	        for (Aluno aln : alunos) {
	            System.out.println(aln.getId() + ": " + aln.getNome() + " - Matricula: " + aln.getMatricula());
	        }
	    }	
	

}
