package curso.spring.mvc.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import curso.spring.mvc.model.Banner;
import curso.spring.mvc.model.Horario;
import curso.spring.mvc.model.Pelicula;
import curso.spring.mvc.service.IBannerService;
import curso.spring.mvc.service.IHorarioService;
import curso.spring.mvc.service.IPeliculasService;
import curso.spring.mvc.util.Utileria;

@Controller
public class HomeController {
	
	@Autowired
	private IPeliculasService servicioPelicula;
	
	@Autowired
	private IBannerService bannerService;
	
	@Autowired 
	private IHorarioService horarioService;
	
	// Buenas Prácticas.

	public static final Logger LOGGER = LoggerFactory.getLogger(NoticiasController.class);
	
	
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
		List<Banner> banners = bannerService.mostrarCarrousel();
		
		/*Obtenemos la lista de las fechas de la clase Utils*/
		List<String> fechas = Utileria.getNextDays(4);
		
		/* Pasamos por parámetros la fecha actual de las películas para buscarlas al pulsar el boton
			Consultar Horarios. */
		model.addAttribute("fechas", fechas);
		model.addAttribute("fechaBusqueda", FORMATOFECHAS.format(new Date()));
		model.addAttribute("peliculas", peliculas);
		model.addAttribute("banners", banners);
		model.addAttribute("vistaPrincipal", "Si");
		
		return VISTAHOME;
	}

	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public String buscar(@RequestParam("fecha") String fecha, Model model) throws ParseException {

		LOGGER.info("Entrando por el método /search");
		/* Obtenemos la lista de las fechas de la clase Utils */
		List<String> fechas = Utileria.getNextDays(4);

		List<Pelicula> peliculas = servicioPelicula.buscarTodas();

		model.addAttribute("fechas", fechas);
		model.addAttribute("fechaBusqueda", fecha);

		// Solo mostramos las peliculas filtras por fecha
		List<Pelicula> peliculasPorFecha = new ArrayList<>();

		for (Pelicula peli : peliculas) {
			String fechaString = Utileria.pasarFechaString(peli.getFechaEstreno());

			if (fecha.equalsIgnoreCase(fechaString)) {
				// Volvemos a pasar la fecha de String a date y guardamos la película.
				Date fechaDate = Utileria.pasarFechasDate(fecha);
				peli.setFechaEstreno(fechaDate);
				peliculasPorFecha.add(peli);
			}
		}
		model.addAttribute("peliculas", peliculasPorFecha);

		return VISTAHOME;
	}
	
	/* ################### INICIO ######################   */
	/* ### Mismo Métodos Utiliznado de diferente forma ### */
	
	
	@RequestMapping(value = "/detail/{id}/{fecha}", method = RequestMethod.GET)
	public String mostrarDetalle(@PathVariable("id") int id, @PathVariable("fecha") String fechaPeliculas,
			Model model) {

		LOGGER.info("Buscando horarios para la pelicula: " + id);
		LOGGER.info("Para la fecha: " + fechaPeliculas);

		Pelicula pelicula = null;
		List<Horario> buscarHorarios = null;
		try {
			pelicula = servicioPelicula.buscarPorId(id);
			buscarHorarios = horarioService.listarHorarios();
			
			
			List<Horario> listaFinalHorarios = new ArrayList<>();
			
			for(Horario hora: buscarHorarios) {
				Horario guardarDatos = new Horario();
				if(pelicula.getTitulo().equalsIgnoreCase(hora.getPelicula().getTitulo())) {
					guardarDatos.setFecha(hora.getFecha());
					guardarDatos.setHora(hora.getHora());
					guardarDatos.setPrecio(hora.getPrecio());
					guardarDatos.setsala(hora.getsala());	
				}
				listaFinalHorarios.add(guardarDatos);
			}
			model.addAttribute("listarHorarios", listaFinalHorarios);
			model.addAttribute("pelicula", pelicula);

		} catch (Exception e) {
			LOGGER.info("Ha fallao la busqueda de la película" + e.getMessage());
		}
		return VISTADETALLE;
	}

	 
	
	/* Utilizando los parámetros con @RequestParam*/
	/*
	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	public String mostrarDetalle(@RequestParam("id") int id,@RequestParam("fecha") String fechaPeliculas,Model model) {
		
		LOGGER.info("Utilizando @RequestParam en una etiqueta <a href=\"detail?id=${pelicula.id}&fecha=${fechaBusqueda}\" /> ");
		LOGGER.info("Buscando horarios para la pelicula: " + id);
		LOGGER.info("Para la fecha: " + fechaPeliculas);

		return VISTADETALLE;
	}
	
	*/
	
	/* ################### FIN ######################   */
	

}
