package curso.spring.mvc.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import curso.spring.mvc.dao.IPeliculaDao;
import curso.spring.mvc.model.Pelicula;
import curso.spring.mvc.model.Usuario;

@Controller
@RequestMapping(value="/imprimir")
public class ImprimirController {

	@Autowired
	private IPeliculaDao peliculaDao;
	
	private static final String LISTARUSUARIO = "/usuarios/listarUsuario";
	
	/*
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	// Método HTTP + Recurso -> Handler Methods
	public ResponseEntity<List<Pelicula>> getPeliculas(){
		return new ResponseEntity<List<Pelicula>>(peliculaDao.findAll(),HttpStatus.OK);
	}
	*/
	
	@GetMapping(value = "/excel")
	public String imprimirFormatoPdf(Model model) {
		model.addAttribute("listadoUsuario", peliculaDao.findAll());
		
		return LISTARUSUARIO;
	}
	
	
}
