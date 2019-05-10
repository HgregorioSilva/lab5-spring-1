package br.gov.sp.fatec.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;

import br.gov.sp.fatec.view.View;



@Entity
@Table(name = "CUR_CURSO")

public class Curso {
	
	public Curso(){
	}
	

	public Curso( String nomeCurso, String periodo, String materia, String duracao, Aluno aluno) {
		this.nomeCurso = nomeCurso;
		this.periodo = periodo;
		this.materia = materia;
		this.duracao = duracao;
		this.aluno = aluno;
	}
	
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "CUR_ID")
	private Long id;
	
	@Column(name = "CUR_NOME")
	@JsonView({View.CursoCompleto.class})
	private String nomeCurso;
	
	@Column(name = "CUR_PERIODO")
	@JsonView({View.CursoCompleto.class})
	private String periodo;
	
	@Column(name = "CUR_MATERIA")
	@JsonView({View.CursoCompleto.class})
	private String materia;
	
	@Column(name = "CUR_DURACAO")
	@JsonView({View.CursoCompleto.class})
	private String duracao;
	
	
	@ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinColumn(name = "ALN_ID") 
			
			
	private Aluno aluno;
			
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nomeCurso;
	}

	public void setNome(String nome) {
		this.nomeCurso = nome;
	}

	public String getPeriodo() {
		return periodo;
	}

	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}

	public String getMateria() {
		return materia;
	}

	public void setMateria(String materia) {
		this.materia = materia;
	}

	public String getDuracao() {
		return duracao;
	}

	public void setPorta(String duracao) {
		this.duracao = duracao;
	}


	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}
	
	
	
	
	
	
	

}
