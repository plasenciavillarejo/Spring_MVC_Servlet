package curso.spring.mvc.controller;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import curso.spring.mvc.model.Detalle;
import curso.spring.mvc.model.Pelicula;
import curso.spring.mvc.service.IDetalleService;
import curso.spring.mvc.service.IPeliculasService;
import curso.spring.mvc.util.Utileria;
import curso.spring.mvc.validator.PeliculasValidator;

@Controller
@RequestMapping("/peliculas")
@SessionAttributes("Peliculas")
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
	
	private static String LISTADOPAGINADO = "";

	
	/* Se encarga de validar el formato de la fecha para indicarlo en formato dd-MM-yyyy */
	@InitBinder
	public void initBinder (WebDataBinder binder) {
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
		
		/* Se puede especificar el campo de la fecha si se desea, pero se puede omitir si en el modelo "Pelicula"
		   se indica el 	@DateTimeFormat(pattern = "dd-MM-yyyy")
			binder.registerCustomEditor(Date.class, "fechaEstreno", new CustomDateEditor(format, false)); */
		
		binder.registerCustomEditor(Date.class, new CustomDateEditor(format, false));
		
		if(!LISTADOPAGINADO.equalsIgnoreCase("si")) {
			binder.setValidator(new PeliculasValidator());
		}
	}
		
	/* Método sin paginador
	@GetMapping(value = "/listarPeliculas")
	public String mostrarIndex(Model model) {
		List<Pelicula> peliculas = peliculasService.buscarTodas();

		model.addAttribute("lista", peliculas);

		return MOSTRARPELICULAS;
	}
	*/ 
	
	
	// Lista con paginador.
	@GetMapping(value = "/listarPeliculas")
	public String mostrarIndex(Model model, Pageable page) {
			
		Page<Pelicula> listarPeliculas = peliculasService.buscarTodas(page);
				
		
		model.addAttribute("pagina", listarPeliculas.getNumber());
		model.addAttribute("primera", listarPeliculas.isFirst());
		model.addAttribute("siguiente", listarPeliculas.hasNext());
		model.addAttribute("atras", listarPeliculas.hasPrevious());
		model.addAttribute("ultima", listarPeliculas.isLast());
		model.addAttribute("ultimaPagina", listarPeliculas.getTotalPages());
		
		model.addAttribute("listarPeliculas", listarPeliculas.getContent());
		
		LISTADOPAGINADO = "si";
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
		
		/* Nota: Cuando se utiliza un redirect en la página los model.addAttribute() no se mostrarán en pantalla ya que no vuelve al mismo formulario 
		 donde ha sucedido la acción. Para que dicho mensaje salga en pantalla deberemos de utilizar el RedirectAttributes.
		 	
		 	Model: Solo funciona si se mantiene la petición en la misma vista (return "peliculas")
		 	RedirectFlashAttribute: Funciona cuando se redirecciona a otra vista. (return:/peliculas/listarPeliculas)
		
		model.addAttribute("mensajeConfirmacion", "La pelicula se ha almacenado correctamente");
		*/
		
		//String mensajeFlash = (pelicula.getId() != 0L)? "Película creada con éxito." : "Se ha actualizado la película con éxito.";
		String mensajeFlash = "";
		if(peliculasService.buscarPorId(pelicula.getId()) == null) {
			mensajeFlash = "Película creada con éxito.";
		}else {
			mensajeFlash = "Se ha actualizado la película con éxito.";
		}
		
		
		flashAttributes.addFlashAttribute("mensajeConfirmacion", mensajeFlash);
			
		detalleService.insertarDetalle(pelicula.getDetalle());
		peliculasService.insertar(pelicula);
		
		}catch (Exception e) {
			LOGGER.info("NO se ha podido almacenar correctamente la pelicula debido al siguiente error: " + e.getMessage());
		}
		
		return "redirect:"+REEDIRECCIONPELICULAS;
	}
	
	@GetMapping(value = "/editarPelicula/{id}")
	public String editarPelicula(@PathVariable("id") int id,Model model, RedirectAttributes flashAttributes) {
		
		LOGGER.info("Se procede a editar la pelicula con el id: " + id);
		
		Pelicula buscarPelicula = null; 
		
		if (id > 0) {
			buscarPelicula = peliculasService.buscarPorId(id);
			if (buscarPelicula == null) {
				flashAttributes.addFlashAttribute("Error", "El cliente no existe en la BD");
			}
		} else {
			flashAttributes.addFlashAttribute("Error", "El ID del cliente no puede ser 0.");
			return MOSTRARPELICULAS;
		}
		
		
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
		
		return FORMPELICULA;
	}
	
	
	@GetMapping(value = "/eliminarPelicula/{id}")
	public String borrarPelicula(@PathVariable("id") int id, RedirectAttributes flashAttributes) {
				
		Pelicula buscarPelicula = peliculasService.buscarPorId(id);
		Detalle buscarDetalle = detalleService.buscarPorId(buscarPelicula.getDetalle().getId());
		if(buscarPelicula != null) {
			LOGGER.info("Se procede a borrar la pelicula con el id: " + id);
			peliculasService.borrarPelicula(buscarPelicula);
			detalleService.borrarDetalle(buscarDetalle);
			String mensajeFlash = "Película eliminada con éxito.";
			
			flashAttributes.addFlashAttribute("mensajeConfirmacion", mensajeFlash);
			
			
		}		
		return "redirect:"+REEDIRECCIONPELICULAS;
	}
	
	
}
