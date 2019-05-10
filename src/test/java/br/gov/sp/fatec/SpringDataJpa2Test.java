package br.gov.sp.fatec;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import br.gov.sp.fatec.model.Curso;
import br.gov.sp.fatec.model.Aluno;
import br.gov.sp.fatec.repository.CursoRepository;
import br.gov.sp.fatec.repository.AlunoRepository;
import br.gov.sp.fatec.service.CursoService;
import br.gov.sp.fatec.service.AlunoService;


@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
@Rollback
public class SpringDataJpa2Test {
	
	private static final String NOME = "João";
	private static final String SOBRENOME = "Silva";
	private static final int IDADE = 28;
	private static final int SEMESTRE = 4;
	private static final String RA = "2020-45";
	private static final String SEXO = "M";
	
	private static final String NOME_CURSO = "Banco de dados";
	private static final String PERIODO = "Manhã";
	private static final String MATERIA = "Estrutura de dados";
	private static final String DURACAO = "180 horas";
	
	@Autowired
	private AlunoRepository alunoRep;
	@Autowired
	private AlunoService alunoService;
	@Autowired
	private CursoRepository cursoRep;
	@Autowired
	private CursoService cursoService;
	
	public void setAlunoRepo(AlunoRepository aluno) {
		this.alunoRep = aluno;
	}
	public void setCursoRepo(CursoRepository curso) {
		this.cursoRep = curso;
	}
	
	//Teste serviço aluno
		@Test
		public void TestServiceAlunoInsertBD(){
			Aluno aluno = new Aluno();
			aluno.setAluno(NOME, SOBRENOME,IDADE, SEMESTRE, RA, SEXO);
			alunoRep.save(aluno);
			assertNotEquals(alunoService.incluiAluno(aluno),null);		
		}
		
		//Teste serviço Curso
				@Test
				public void TestServiceCursoInsertBD(){
					Aluno aluno = new Aluno();
					aluno.setAluno(NOME, SOBRENOME, IDADE, SEMESTRE, RA, SEXO);
					alunoRep.save(aluno);
					Curso curso = new Curso(NOME_CURSO,PERIODO,MATERIA,DURACAO,aluno);	
					assertNotEquals(cursoService.incluiCurso(curso),null);
				}
		
		//Teste do reoisitorio Aluno.
		@Test
		public void TestRepositoryAlunoCosnultaBD(){
			Aluno aluno = new Aluno();
			aluno.setAluno(NOME, SOBRENOME, IDADE, SEMESTRE, RA, SEXO);
			alunoRep.save(aluno);
			//alunoService.incluiAluno(aluno);
			alunoService.incluiAluno(aluno);
			assertEquals(alunoService.incluiAluno(aluno),aluno);
		}
		
		//Teste do reoisitorio Curso.
		@Test
		public void TestRepositoryCursoConsultaBD(){
			Aluno aluno = new Aluno();
			aluno.setAluno(NOME, SOBRENOME, IDADE, SEMESTRE, RA, SEXO );
			Curso cur = new Curso(NOME_CURSO,PERIODO,MATERIA,DURACAO,aluno);
			cur.setAluno(aluno);
			cursoService.incluiCurso(cur);
			assertEquals(cursoService.incluiCurso(cur),cur);
			
		}
	

}
