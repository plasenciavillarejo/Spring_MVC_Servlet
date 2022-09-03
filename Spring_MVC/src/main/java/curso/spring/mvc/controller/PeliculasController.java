package curso.spring.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import curso.spring.mvc.model.Pelicula;

@Controller
@RequestMapping("/peliculas")
public class PeliculasController {

	public static final String FORMPELICULA = "peliculas/formPelicula";
	
	@GetMapping(value = "/create")
	public String crear() {
		return FORMPELICULA;
	}
	
	@PostMapping(value = "/save")
	public String guardar(Pelicula pelicula, BindingResult result) {
		
		System.out.println("Recibimos el objeto película:" + pelicula);
		
		return FORMPELICULA;
	}
}
