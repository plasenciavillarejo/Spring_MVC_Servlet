package curso.spring.mvc.controller;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

	// Buenas Prácticas.
	
	// Redirecciones a Página Webs.
	public static final String VISTAHOME = "home";
	public static final String VISTADETALLE = "detalle";
		
	/*
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String goHome() {
		return VISTAHOME;
	}*/
	
	@RequestMapping(value="/", method = RequestMethod.GET)
	public String mostrarPrincipal(Model model) {
		
		List<String> peliculas = new LinkedList<>();
		peliculas.add("Rápido y furioso");
		peliculas.add("Thor dios del infierno");
		peliculas.add("Hulk el hombre invencible");
		
		model.addAttribute("peliculas", peliculas);
		
		return VISTAHOME;
	}
	
	@RequestMapping(value="/detail", method= RequestMethod.GET)
	public String mostrarDetalle(Model model) {
		String tituloPelicula = "Rápido y Furiosos.";
		int duracion = 136;
		double precioEntrada = 50;
		
		model.addAttribute("tituloPelicula", tituloPelicula);
		model.addAttribute("duracion", duracion);
		model.addAttribute("precioEntrada", precioEntrada);
		
		return VISTADETALLE;
	}
	
}
