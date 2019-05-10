package br.gov.sp.fatec.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.gov.sp.fatec.model.Curso;
import br.gov.sp.fatec.model.Aluno;
import br.gov.sp.fatec.repository.CursoRepository;
import br.gov.sp.fatec.repository.AlunoRepository;



@Service("CursoService")
public class CursoServiceImplements implements CursoService{
	
	@Autowired
	public AlunoRepository alunoRep;
	
	@Autowired
	public CursoRepository cursoRep;	

	@Override
	@Transactional
	public Curso incluiCurso(Curso curso) {
		return cursoRep.save(curso);
	}

}

