package br.gov.sp.fatec.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;

import br.gov.sp.fatec.view.View;


@Entity
@Table(name ="ALN_ALUNO")

public class Aluno {
	
public Aluno(){
		
	}
	
	public Aluno(String nomeAluno, String sobrenome, int idade,int semestre,String ra, String sexo){
		this.nomeAluno = nomeAluno;
		this.sobrenome = sobrenome;
		this.idade = idade;
		this.semestre = semestre;
		this.ra = ra;
		this.sexo = sexo;
	}
	
	public void setAluno(String nomeAluno, String sobrenome, int idade,int semestre,String ra, String sexo) {
		this.nomeAluno = nomeAluno;
		this.sobrenome = sobrenome;
		this.idade = idade;
		this.semestre = semestre;
		this.ra = ra;
		this.sexo = sexo;
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "ALN_ID")
	@JsonView({View.AlunoTudo.class})
	private Long id; 
	
	@Column(name = "ALN_NOME",unique=true, length = 50, nullable = false)
	@JsonView({View.AlunoCompleto.class, View.AlunoTudo.class})
	private String 	nomeAluno;
	
	@Column(name = "ALN_SOBRENOME")
	@JsonView({View.AlunoCompleto.class, View.AlunoTudo.class})
	private String sobrenome;
	
	@Column(name = "ALN_IDADE")
	@JsonView({View.AlunoCompleto.class, View.AlunoTudo.class})
	private int idade;
	
	@Column(name = "ALN_SEMESTRE")
	@JsonView({View.AlunoCompleto.class, View.AlunoTudo.class})
	private int semestre;
	
	@Column(name = "ALN_RA")
	@JsonView({View.AlunoCompleto.class, View.AlunoTudo.class})
	private String ra;
	
	@Column(name = "ALN_SEXO")
	@JsonView({View.AlunoCompleto.class, View.AlunoTudo.class})
	private String sexo;
	
	@OneToMany(mappedBy = "aluno")
	private List<Curso> cursosAluno = new ArrayList<Curso>();
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeAluno() {
		return nomeAluno;
	}

	public void setNomeAluno(String nomeAluno) {
		this.nomeAluno = nomeAluno;
	}


	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
	
	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}
	
	
	

}
