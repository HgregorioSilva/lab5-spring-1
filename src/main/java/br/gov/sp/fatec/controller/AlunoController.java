package br.gov.sp.fatec.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import br.gov.sp.fatec.model.Aluno;
import br.gov.sp.fatec.repository.AlunoRepository;
import br.gov.sp.fatec.view.View;

@RestController
@RequestMapping	(value="/aluno")
public class AlunoController {
	
	@Autowired
	private AlunoRepository alunoRepo;
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
    @JsonView(View.AlunoNome.class)
    public ResponseEntity<Aluno> save(@RequestParam(value="name") String name) {
		Aluno Aluno = alunoRepo.findByNomeAluno(name);
        return Aluno == null ?
        		new ResponseEntity<>(HttpStatus.NOT_FOUND):
                new ResponseEntity<>(Aluno, HttpStatus.OK);
    }
	
	@RequestMapping(value = "/findByName")
    @JsonView(View.AlunoCompleto.class)
    public ResponseEntity<Aluno> findByName(@RequestParam(value="name") String name) {
        Aluno Aluno = alunoRepo.findByNomeAluno(name);
        return Aluno == null ?
                new ResponseEntity<>(HttpStatus.NOT_FOUND):
                new ResponseEntity<>(Aluno, HttpStatus.OK);
    }
	
	@RequestMapping(value = "/findByNameID")
    @JsonView(View.AlunoTudo.class)
    public ResponseEntity<List<Aluno>> findByName(@RequestParam(value="name") String name, @RequestParam(value="ra") String ra) {
		List<Aluno> aluno = alunoRepo.findByNomeAlunoContainsIgnoreCaseOrRaContainsIgnoreCase(name, ra);
        return aluno == null ?
        		new ResponseEntity<List<Aluno>>(HttpStatus.NOT_FOUND):
                new ResponseEntity<List<Aluno>>(aluno, HttpStatus.OK);
    }

}
