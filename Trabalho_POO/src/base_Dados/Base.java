package base_Dados;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import entidades.Aluno;
import entidades.Departamento;
import entidades.Disciplina;
import entidades.Laboratorio;
import entidades.Professor;
import funcaoReserva.Reserva;

public class Base implements IBase {

	private final Integer
	
	//Declarando variaveis fixas para ajudar nos loops com o "for".
	QTDE_DEPARTAMENTOS = 3,
	QTDE_PROFESSORES = 15,
	QTDE_LABORATORIOS = 12,
	QTDE_DISCIPLINAS = 10,
	QTDE_ALUNOS = 30;
	
	//criação das listas onde os objetos serão adicionados.
	private List<Laboratorio> laboratorios;
	private List<Departamento> departamentos;
	private List<Disciplina> disciplinas;
	private List<Professor> professores;
	private List<Aluno> alunos;
	private List<Reserva> reservas;

	
	/*Em geral todos métodos seguem a mesma lógica de loop com for para a criação dos objetos, 
	  porém cada método possui uma implementação do loop que seja adequada para o que foi pedido. 
	 */
	private void laboratorios() {
		this.laboratorios = new ArrayList<Laboratorio>();
		Laboratorio lab;
		
		try {
		for (int i = 0, ctle = 1; i < QTDE_LABORATORIOS; i++, ctle++) {
			lab = new Laboratorio();
			lab.setId(ctle);
			if(ctle == 1 || ctle == 10) {
			lab.setCapacidade(30);
			} else if(ctle >=2 && ctle <= 7) {
				lab.setCapacidade(20);
			} else if(ctle >7 &&  ctle <=9 || ctle > 10 && ctle <=12) {
				lab.setCapacidade(15);
			}
			lab.setStatus(true);
			this.laboratorios.add(lab);
		}
	}catch(Exception e){
		e.printStackTrace();
		}
	} 
		
	private void departamentos() {
		this.departamentos = new ArrayList<Departamento>();
		Departamento dep;
		
		try {
		for (int i = 0, ctle = 1; i < QTDE_DEPARTAMENTOS; i++, ctle++) {
			dep = new Departamento();
			dep.setId(ctle);
			if(ctle == 1){
			dep.setSigla("E.S");	
			dep.setDescricao("Engenharia de Software");
			} else if(ctle == 2 ) {
			dep.setSigla("C.A.D");
			dep.setDescricao("Computacao de alto desempenho");
			} else if(ctle == 3) {
			dep.setSigla("I.C");
			dep.setDescricao("Infraestrutura computacional");
				}
			this.departamentos.add(dep);
			
		}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private void disciplinas() {
		this.disciplinas = new ArrayList<Disciplina>();
		Disciplina disc;
		
		try {
			for (int i = 0, ctle = 1; i < QTDE_DISCIPLINAS; i++, ctle++) {
				disc = new Disciplina();
				disc.setId(ctle);
				if(ctle == 1) {
					disc.setSigla("BES005");
					disc.setDescricao("Logica de programacao e algoritmos");
				} else if(ctle == 2) {
					disc.setSigla("BES006");
					disc.setDescricao("Estrutura de dados");
				} else if(ctle == 3) {
					disc.setSigla("BES008");
					disc.setDescricao("Programacao orientada a objetos");
				} else if(ctle == 4) {
					disc.setSigla("BES011");
					disc.setDescricao("Banco de dados");
				} else if(ctle == 5) {
					disc.setSigla("BES012");
					disc.setDescricao("Engenharia de requisitos");
				} else if(ctle == 6) {
					disc.setSigla("BES020");
					disc.setDescricao("Programacao para dispositivos moveis");
				} else if(ctle == 7) {
					disc.setSigla("BES026");
					disc.setDescricao("Sistemas distribuidos");
				} else if(ctle == 8) {
					disc.setSigla("BES038");
					disc.setDescricao("Inteligencia artificial");
				} else if(ctle == 9) {
					disc.setSigla("BES049");
					disc.setDescricao("Programacao web");
				} else if(ctle == 10) {
					disc.setSigla("BES048");
					disc.setDescricao("Programacao front end");
				}
				disc.setStatus(true);
				this.disciplinas.add(disc);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	private void professores(List<Departamento> dep) {
	    this.professores = new ArrayList<Professor>();
	    Professor prof; 
	       
	    try {
	        for (int i = 0, ctle = 1; i < QTDE_PROFESSORES; i++, ctle++) {
	            prof= new Professor();
	           
	            prof.setId(ctle);
	            prof.setNome("Professor" + ctle);
	            if (ctle <=5){
	                prof.setDepartamento(dep.get(0));
	                } else if (ctle >5 &&ctle <=10) {
	                    prof.setDepartamento(dep.get(1));
	                } else if(ctle>10) {
	                    prof.setDepartamento(dep.get(2));
	                }
	            prof.setStatus(true);
	            this.professores.add(prof);
	           
	        }
	    } catch (Exception e) {
	       e.printStackTrace();
	        }
	        
	}
	
	private void alunos() {
		this.alunos = new ArrayList<Aluno>();
		Aluno aln;
		
		try {
			for (int i = 0, ctle = 1; i < QTDE_ALUNOS; i++, ctle++) {
				aln = new Aluno();
				
				aln.setId(ctle);
				aln.setNome("Aluno" + ctle);
				aln.setMatricula(20230200+ ctle);
				aln.setStatus(true);
				this.alunos.add(aln);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void reservas(){
		this.reservas = new ArrayList<Reserva>();
		Reserva res;
		
		try {
			for (int i = 0, ctle = 1; i < 10; i++, ctle++) {
	             res = new Reserva();
	            
	            res.setId(ctle);
	            res.setLaboratorio(laboratorios.get(i % laboratorios.size()));
	            res.setProfessor(professores.get(i % professores.size()));
	            res.setDisciplina(disciplinas.get(i % disciplinas.size()));
	            res.setMinutos((i + 1) * 10); 
	            res.setDiaReserva(LocalDateTime.now().plusDays(i)); 

	           
	            this.reservas.add(res);
	        }
			
			
		} catch (Exception e) {
			
		}
	}
	
	
	//implementação dos métodos da interface que ajudarão a acessar os valores em outras classes
	@Override
	public List<Departamento> getDepartamentos() {
		departamentos();
		return this.departamentos;
	}

	@Override
	public List<Disciplina> getDisciplina() {
		disciplinas();
		return this.disciplinas;
	}
	
	@Override
	public List<Laboratorio> getlaboratorios() {
		laboratorios();
		return this.laboratorios;
	}

	@Override
	public List<Professor> getProfessores(List<Departamento> Dep) {
		professores(Dep);
		return this.professores;
	}

	@Override
	public List<Aluno> getAlunos() {
		alunos();
		return this.alunos;
	}

	@Override
	public List<Reserva> getReservas() {
		reservas();
		return this.reservas;
	}



	
}
