package curso.spring.mvc.controller;

import java.io.File;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import curso.spring.mvc.dao.IDetalleDao;
import curso.spring.mvc.model.Detalle;
import curso.spring.mvc.model.Pelicula;
import curso.spring.mvc.service.IDetalleService;
import curso.spring.mvc.service.IPeliculasService;
import curso.spring.mvc.util.Utileria;
import curso.spring.mvc.validator.PeliculasValidator;

@Controller
@RequestMapping("/peliculas")
public class PeliculasController {

	@Autowired
	private IPeliculasService peliculasService;
	
	@Autowired
	private IDetalleService detalleService;
	
	// Ubicacion donde se envia al usuario a consultar las páginas JSP.
	public static final String FORMPELICULA = "peliculas/formPelicula";
	public static final String MOSTRARPELICULAS ="/peliculas/listPeliculas";
	
	// Redirecciona al método @GetMapping(value="/listarPeliculas")
	public static final String REEDIRECCIONPELICULAS = "/peliculas/listarPeliculas";
	
	public static final Logger LOGGER = LoggerFactory.getLogger(NoticiasController.class);
	
	
	/* Se encarga de validar el formato de la fecha para indicarlo en formato dd-MM-yyyy */
	@InitBinder
	public void initBinder (WebDataBinder binder) {
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
		
		/* Se puede especificar el campo de la fecha si se desea, pero se puede omitir si en el modelo "Pelicula"
		   se indica el 	@DateTimeFormat(pattern = "dd-MM-yyyy")
			binder.registerCustomEditor(Date.class, "fechaEstreno", new CustomDateEditor(format, false)); */
		
		binder.registerCustomEditor(Date.class, new CustomDateEditor(format, false));
		
		binder.setValidator(new PeliculasValidator());
	}
		
	
	@GetMapping(value = "/listarPeliculas")
	public String mostrarIndex(Model model) {
		List<Pelicula> listarPeliculas = peliculasService.buscarTodas();

		model.addAttribute("listarPeliculas", listarPeliculas);

		return MOSTRARPELICULAS;
	}

	@GetMapping(value = "/create")
	public String crear(@ModelAttribute("pelicula") Pelicula pelicula, Model model) {

		// Buscamos los valores para mostrar en la vista
		Map<String, String> clasificaciones = Utileria.listarClasificaciones();
		Map<String, String> estatus = Utileria.listarEstatus();

		// Pasamos los valores a la vista.
		model.addAttribute("listarGeneros", Utileria.listarGeneros());
		model.addAttribute("listaClasificacion", clasificaciones);
		model.addAttribute("listarEstados", estatus);

		return FORMPELICULA;
	}
	
	@PostMapping(value = "/save")
	public String guardar(@Validated @ModelAttribute("pelicula") Pelicula pelicula,BindingResult result, 
			@RequestParam("archivoImagen") MultipartFile file,Model model, RedirectAttributes flashAttributes, HttpServletRequest request) {
		
		/*
		 * for(ObjectError error: result.getAllErrors()) {
		 * LOGGER.info("El formulario contiene un error/es." + error); }
		 */
		
		if (result.hasErrors()) {
			LOGGER.info("El formulario contiene errores.");
			Map<String, String> clasificaciones = Utileria.listarClasificaciones();
			Map<String, String> estatus = Utileria.listarEstatus();
			
			model.addAttribute("listarGeneros", Utileria.listarGeneros());
			model.addAttribute("listaClasificacion", clasificaciones);
			model.addAttribute("listarEstados", estatus);
			
			flashAttributes.addFlashAttribute("mensajeError", "No se ha podido almacenar correctamente la pelicula, vuelva a intentarlo nuevamente");
			
			return FORMPELICULA;
		}
		
		LOGGER.info("Recibimos el objeto película:" + pelicula);		
		
		try {
			
		if(!file.isEmpty()) {
			String nombreImagen = Utileria.guardarImagen(request, file);
			pelicula.setImagen(nombreImagen);
		}
				
		detalleService.insertarDetalle(pelicula.getDetalle());
		peliculasService.insertar(pelicula);
		
		/* Nota: Cuando se utiliza un redirect en la página los model.addAttribute() no se mostrarán en pantalla ya que no vuelve al mismo formulario 
		 donde ha sucedido la acción. Para que dicho mensaje salga en pantalla deberemos de utilizar el RedirectAttributes.
		 	
		 	Model: Solo funciona si se mantiene la petición en la misma vista (return "peliculas")
		 	RedirectFlashAttribute: Funciona cuando se redirecciona a otra vista. (return:/peliculas/listarPeliculas)
		
		model.addAttribute("mensajeConfirmacion", "La pelicula se ha almacenado correctamente");
		*/
		flashAttributes.addFlashAttribute("mensajeConfirmacion", "La pelicula se ha almacenado correctamente");
		
		}catch (Exception e) {
			LOGGER.info("NO se ha podido almacenar correctamente la pelicula debido al siguiente error: " + e.getMessage());
		}
		
		
		return "redirect:"+REEDIRECCIONPELICULAS;
	}
	
	@GetMapping(value = "/editarPelicula/{id}")
	public String editarPelicula(@PathVariable("id") int id,Model model) {
		
		LOGGER.info("Se procede a editar la pelicula con el id: " + id);
		
		Pelicula buscarPelicula = peliculasService.buscarPorId(id);
		Map<String, String> clasificaciones = Utileria.listarClasificaciones();
		Map<String, String> estatus = Utileria.listarEstatus();
		
		// Recorremos la clase donde está los HashMap para poder 
		/*
		for(Map.Entry<String, String> peli: clasificaciones.entrySet()) {
			if(buscarPelicula.getClasificacion().equalsIgnoreCase(peli.getKey())) {
				clasificaciones.put(peli.getKey(), peli.getValue());
			}
		}
		*/
		model.addAttribute("listarGeneros", Utileria.listarGeneros());
		model.addAttribute("listaClasificacion", clasificaciones);
		model.addAttribute("listarEstados", estatus);
		model.addAttribute("pelicula", buscarPelicula);
		model.addAttribute("mensajeConfirmacion", "La película se ha editado correctamente.");

		model.addAttribute("edicion", "si");
		
		return FORMPELICULA;
	}
	
	
	@GetMapping(value = "/eliminarPelicula/{id}")
	public String borrarPelicula(@PathVariable("id") int id, Model model) {
		
		// METER POPUP PARA PREGUNTAR AL USUARIO SI ESTÁ SEGURO DE BORRAR LA PELICULA CON SU DETALLE.
		
		Pelicula buscarPelicula = peliculasService.buscarPorId(id);
		Detalle buscarDetalle = detalleService.buscarPorId(buscarPelicula.getDetalle().getId());
		if(buscarPelicula != null) {
			LOGGER.info("Se procede a borrar la pelicula con el id: " + id);
			peliculasService.borrarPelicula(buscarPelicula);
			detalleService.borrarDetalle(buscarDetalle);
		}		
		return "redirect:"+REEDIRECCIONPELICULAS;
	}
	
	
}
