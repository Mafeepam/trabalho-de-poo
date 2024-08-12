package funcaoReserva;

//criação do objeto reserva com todos os métodos necessarios para outras classes
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import entidades.Aluno;
import entidades.Disciplina;
import entidades.Laboratorio;
import entidades.Professor;


public class Reserva implements IReserva{
	
	private int id;
	private Laboratorio laboratorio;
    private Professor professor;
    private List<Aluno> aluno;
	private Disciplina disciplina;
    private LocalTime horaInicial;
    private LocalDateTime dataLiberacao;
    private int minutos;
    private SituacaoReserva situacao;
    private LocalDateTime diaReserva;
    private String Situacao;
   
    public Reserva() {
       
    }

    public Reserva(Laboratorio lab, Professor prof, Disciplina disc, List<Aluno> aln,
                       LocalDateTime now, int min) {
       
    }
    
    
    
    public Laboratorio getLaboratorio() {
		return laboratorio;
	}

	public void setLaboratorio(Laboratorio laboratorio) {
		this.laboratorio = laboratorio;
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}


	public LocalDateTime getDataLiberacao() {
		return dataLiberacao;
	}

	public void setDataLiberacao(LocalDateTime data) {
		this.dataLiberacao = data;
	}

	public int getMinutos() {
		return minutos;
	}

	public void setMinutos(int minutos) {
		this.minutos = minutos;
	}
	
	public void setHoraInicial(LocalTime horaInicial) {
		this.horaInicial = horaInicial;
	}

	public LocalDateTime getDiaReserva() {
		return diaReserva;
	}

	public void setDiaReserva(LocalDateTime diaReserva) {
		this.diaReserva = diaReserva;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setSituacao(SituacaoReserva situacao) {
		this.situacao = situacao;
	}
	
	public void setAluno(List<Aluno> aluno) {
	    this.aluno = aluno;
	}

	public List<Aluno> getAluno() {
	    return aluno;
	}
	
	public boolean isAprovada() {
        return "APROVADA".equals(Situacao);
    }


   
   
    public void setSituacaoAprovada() {
        this.situacao = SituacaoReserva.APROVADA;
    }

    public void setSituacaoReprovada() {
        this.situacao = SituacaoReserva.REPROVADA;
    }
    
    
    @Override
    public int getId() {
        return id;
    }

    @Override
    public SituacaoReserva getSituacao() {
        return situacao;
    }

    @Override
    public LocalDateTime getDiaDaReserva() {
        return diaReserva;
    }

    @Override
    public int getDuracao() {
        return minutos;
    }
    
  


	@Override
	public Reserva getReserva() {
		
		return null;
	}
	

	@Override
	public LocalTime getHoraInicial() {
		
		return null;
	}
	

	
	@Override
	public String toString() {
		return "Reserva [id=" + id + ", laboratorio=" + laboratorio + ", professor=" + professor +  
				 ", disciplina=" + disciplina + ", horaInicial=" + horaInicial + ", dataLiberacao=" + dataLiberacao
				+ ", minutos=" + minutos + ", situacao=" + situacao + ", diaReserva=" + diaReserva + ", aluno=" +aluno + "]";
	}

}



