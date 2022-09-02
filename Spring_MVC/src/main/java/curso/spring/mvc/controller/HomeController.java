package curso.spring.mvc.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import curso.spring.mvc.model.Pelicula;
import curso.spring.mvc.service.IPeliculasService;
import curso.spring.mvc.util.Utileria;

@Controller
public class HomeController {
	
	@Autowired
	private IPeliculasService servicioPelicula;
	
	// Buenas Prácticas.

	private static final Logger LOGGER = Logger.getAnonymousLogger();
	
	// Redirecciones a Página Webs.
	public static final String VISTAHOME = "home";
	public static final String VISTADETALLE = "detalle";

	
	// Variable global para permitir dar formato a las fechas
	private static final SimpleDateFormat FORMATOFECHAS = new SimpleDateFormat("dd-MM-yyyy");
	
	/*
	 * @RequestMapping(value = "/home", method = RequestMethod.GET) public String
	 * goHome() { return VISTAHOME; }
	 */

	@RequestMapping(value = {"/", "/inicio"}, method = RequestMethod.GET)
	public String mostrarPrincipal(Model model) {

		List<Pelicula> peliculas = servicioPelicula.buscarTodas();
		
		
		/*Obtenemos la lista de las fechas de la clase Utils*/
		List<String> fechas = Utileria.getNextDays(4);
		
		/* Pasamos por parámetros la fecha actual de las películas para buscarlas al pulsar el boton
			Consultar Horarios. */
		model.addAttribute("fechas", fechas);
		model.addAttribute("fechaBusqueda", FORMATOFECHAS.format(new Date()));
		model.addAttribute("peliculas", peliculas);

		return VISTAHOME;
	}

	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public String buscar(@RequestParam("fecha") String fecha, Model model) {

		
		LOGGER.info("Entrando por el método /search");
		
		/* Obtenemos la lista de las fechas de la clase Utils */
		List<String> fechas = Utileria.getNextDays(4);

		List<Pelicula> peliculas = servicioPelicula.buscarTodas();	
		
		model.addAttribute("fechas", fechas);
		model.addAttribute("fechaBusqueda", fecha);
		model.addAttribute("peliculas", peliculas);

		return VISTAHOME;
	}
	
	
	/* ################### INICIO ######################   */
	/* ### Mismo Métodos Utiliznado de diferente forma ### */
	
	
	@RequestMapping(value = "/detail/{id}/{fecha}", method = RequestMethod.GET)
	public String mostrarDetalle(@PathVariable("id") int id,@PathVariable("fecha") String fechaPeliculas,Model model) {
		
		System.out.println("Buscando horarios para la pelicula: " + id);
		System.out.println("Para la fecha: " + fechaPeliculas);
		
		Pelicula pelicula = null;
		try {
			pelicula = servicioPelicula.buscarPorId(id);
			model.addAttribute("pelicula", pelicula);
			
		}catch (Exception e) {
			LOGGER.info("Ha fallao la busqueda de la película" + e.getMessage());
		}
		return VISTADETALLE;
	}

	 
	
	/* Utilizando los parámetros con @RequestParam*/
	/*
	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	public String mostrarDetalle(@RequestParam("id") int id,@RequestParam("fecha") String fechaPeliculas,Model model) {
		
		System.out.println("Utilizando @RequestParam en una etiqueta <a href=\"detail?id=${pelicula.id}&fecha=${fechaBusqueda}\" /> ");
		System.out.println("Buscando horarios para la pelicula: " + id);
		System.out.println("Para la fecha: " + fechaPeliculas);

		return VISTADETALLE;
	}
	
	*/
	
	/* ################### FIN ######################   */
	

}
