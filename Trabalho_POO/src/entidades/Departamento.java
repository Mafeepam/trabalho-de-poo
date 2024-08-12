package entidades;

//criação de um objeto.
public class Departamento {
	
	private int id;
	private String sigla;
	private String descricao;

	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSigla() {
		return sigla;
	}
	public void setSigla(String sigla) {
		this.sigla = sigla;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	

@Override
public String toString() {
	return "Departamento [id=" + id + ", sigla=" + sigla + ", descricao=" + descricao + "]";
}
}