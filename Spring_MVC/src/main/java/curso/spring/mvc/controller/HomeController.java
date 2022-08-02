package curso.spring.mvc.controller;

import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import curso.spring.mvc.model.Pelicula;

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
		
		List<Pelicula> peliculas = getLista();
		
		
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
	
	
	// Método para crear una lista de forma manual.
	
	private List<Pelicula> getLista(){
		SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
		List<Pelicula> listaPeliculas = null;
		
		try {
			listaPeliculas = new LinkedList<>();
			
			Pelicula pelicula1 = new Pelicula();
				pelicula1.setId(1);
				pelicula1.setTitulo("El país de nunca jamas");
				pelicula1.setDuracion(145);
				pelicula1.setClasificacion("B");
				pelicula1.setGenero("Adventura");
				pelicula1.setFechaEstreno(formato.parse("02-05-2017"));
				
				listaPeliculas.add(pelicula1);

				
			Pelicula pelicula2 = new Pelicula();
				pelicula2.setId(2);
				pelicula2.setTitulo("Venom");
				pelicula2.setDuracion(129);
				pelicula2.setClasificacion("A");
				pelicula2.setGenero("Acción");
				pelicula2.setFechaEstreno(formato.parse("07-10-2021"));
				
				listaPeliculas.add(pelicula2);
				
				
				
				
		}catch (Exception e) {
			System.out.println("Ha fallado la insercción de peliculas");
		}
		
		return listaPeliculas;
	}
	
	
	
}