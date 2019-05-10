package br.gov.sp.fatec.repository;

import org.springframework.data.repository.CrudRepository;

import br.gov.sp.fatec.model.Curso;


public interface CursoRepository extends CrudRepository<Curso,Long>{
	
	public Curso findByNomeCurso(String nomeCurso);
	
	public Curso findByDuracao(String duracao);
	
	/*@Query("select count(*) from Curso s where s.duracao like ?1")
	public String findByContduracao(@Param(":duracao") String duracao);*/

}
