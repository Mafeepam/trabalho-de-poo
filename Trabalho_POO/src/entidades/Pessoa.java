package entidades;

//criação de um objeto.
public class Pessoa {
	
	private String nome;
	private boolean status;
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}

	public boolean getStatus() {
		return status;
	}
	public void setStatus(boolean estado) {
		this.status = estado;
	}
	@Override
	public String toString() {
		return "Pessoa [nome=" + nome + ", status=" + status + "]";
	}

}
