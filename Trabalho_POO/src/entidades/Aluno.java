package entidades;

//criação de um objeto
public class Aluno extends Pessoa {
	private int id;
	private int matricula;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getMatricula() {
		return matricula;
	}
	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}
	
	@Override
	public String toString() {
		return "Aluno [id=" + id + ", matricula=" + matricula + "]";
	}
	
	
	

}
