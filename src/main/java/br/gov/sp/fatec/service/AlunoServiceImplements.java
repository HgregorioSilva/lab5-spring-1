package br.gov.sp.fatec.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.gov.sp.fatec.model.Aluno;
import br.gov.sp.fatec.repository.AlunoRepository;




@Service("AlunoService")
public class AlunoServiceImplements implements AlunoService{
	
	@Autowired
	private AlunoRepository alunoRep;
	
	public void setAluno(AlunoRepository alunoRep) {
		this.alunoRep = alunoRep;
	}
			
	@Override
	@Transactional
	public Aluno incluiAluno(Aluno aluno) {
		
		return alunoRep.save(aluno);
		
	}

	

}
