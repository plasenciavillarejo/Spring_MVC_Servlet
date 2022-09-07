package curso.spring.mvc.controller;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import curso.spring.mvc.model.Pelicula;
import curso.spring.mvc.service.IPeliculasService;

@Controller
@RequestMapping("/peliculas")
public class PeliculasController {

	@Autowired
	private IPeliculasService peliculasService;
	
	public static final String FORMPELICULA = "peliculas/formPelicula";
	public static final String MOSTRARPELICULAS ="peliculas/listPeliculas";
	
	@GetMapping(value="/listarPeliculas")
	public String mostrarIndex(Model model) {
		List<Pelicula> listarPeliculas = peliculasService.buscarTodas();
		model.addAttribute("listarPeliculas", listarPeliculas);
		return MOSTRARPELICULAS;
	}
	
	@GetMapping(value = "/create")
	public String crear() {
		return FORMPELICULA;
	}
	
	@PostMapping(value = "/save")
	public String guardar(Pelicula pelicula, BindingResult result) {

		/*
		 * for(ObjectError error: result.getAllErrors()) {
		 * System.out.println("El formulario contiene un error/es." + error); }
		 */

		if (result.hasErrors()) {
			System.out.println("El formulario contiene errores.");
			return FORMPELICULA;
		}
		
		System.out.println("Recibimos el objeto película:" + pelicula);

		peliculasService.insertar(pelicula);
		
		return FORMPELICULA;
	}
	
	/* Se encarga de validar el formato de la fecha para indicarlo en formato dd-MM-yyyy */
	@InitBinder
	public void initBinder (WebDataBinder binder) {
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
		// Se puede especificar el campo de la fecha si se desea, pero se puede omitir si en el modelo "Pelicula" se indica el 	@DateTimeFormat(pattern = "dd-MM-yyyy")
		//binder.registerCustomEditor(Date.class, "fechaEstreno", new CustomDateEditor(format, false));
		
		binder.registerCustomEditor(Date.class, new CustomDateEditor(format, false));
	}
	
}
