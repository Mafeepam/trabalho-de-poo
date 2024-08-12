package entidades;

//criação de um objeto.
public class Disciplina {
	
		private int id;
		private String sigla;
		private String descricao;
		private boolean status;
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
		public boolean getStatus() {
			return status;
		}
		public void setStatus(boolean status) {
			this.status = status;
		}
		@Override
		public String toString() {
			return "Disciplina [id=" + id + ", sigla=" + sigla + ", descricao=" + descricao + ", estado=" + status
					+ "]";
		}
		
		
		
}

