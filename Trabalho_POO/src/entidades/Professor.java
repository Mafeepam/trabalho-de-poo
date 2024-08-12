package entidades;

//criação de um objeto.
public class Professor extends Pessoa {
	
	private int id;
	private Departamento departamento;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Departamento getDepartamento() {
		return departamento;
	}
	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}
	
	
	@Override
	public String toString() {
		return "Professor [id=" + id  +", departamento=" + departamento + "]";
	}
	
	
	
	
	
	
	
}
