package base_Dados;

//Interface da base de dados que será implementada na classe "Base.Java"
import java.util.List;

import entidades.Aluno;
import entidades.Departamento;
import entidades.Disciplina;
import entidades.Laboratorio;
import entidades.Professor;
import funcaoReserva.Reserva;

public interface IBase {
	
	
	List<Laboratorio> getlaboratorios();
	List<Departamento> getDepartamentos();
	List<Disciplina> getDisciplina();
	List<Professor> getProfessores(List<Departamento> Dep);
	List<Aluno> getAlunos();
	List<Reserva> getReservas();
}

