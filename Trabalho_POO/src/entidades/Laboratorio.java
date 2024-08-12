package entidades;

//criação de um objeto.
public class Laboratorio {
	
	private int id;
	private int capacidade;
	private boolean status;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCapacidade() {
		return capacidade;
	}
	public void setCapacidade(int capacidade) {
		this.capacidade = capacidade;
	}
	
	
	public boolean getStatus() {
		return status;
	}
	
	public void setStatus(boolean status) {
		this.status = status;
	}
	
	@Override
	public String toString() {
		return "Laboratório [id=" + id + ", status=" + status
				+ "]";
	}
	
	
	
	
	
}
