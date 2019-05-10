package br.gov.sp.fatec.controller;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import br.gov.sp.fatec.model.Curso;
import br.gov.sp.fatec.model.Curso;
import br.gov.sp.fatec.repository.CursoRepository;
import br.gov.sp.fatec.view.View;

@RestController
@RequestMapping	(value="/curso")
public class CursoController {
	
	@Autowired
	private CursoRepository cursoRepo;
	
	@RequestMapping(value = "/findByName")
    @JsonView(View.CursoCompleto.class)
    public ResponseEntity<Curso> findByName(@RequestParam(value="name") String name) {
        Curso Curso = cursoRepo.findByNomeCurso(name);
        return Curso == null ?
                new ResponseEntity<>(HttpStatus.NOT_FOUND):
                new ResponseEntity<>(Curso, HttpStatus.OK);
    }
}