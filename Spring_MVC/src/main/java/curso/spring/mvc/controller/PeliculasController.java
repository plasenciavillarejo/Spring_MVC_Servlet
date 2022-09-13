package curso.spring.mvc.controller;

import java.io.File;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import curso.spring.mvc.model.Pelicula;
import curso.spring.mvc.service.IPeliculasService;

@Controller
@RequestMapping("/peliculas")
public class PeliculasController {

	@Autowired
	private IPeliculasService peliculasService;
	
	public static final String FORMPELICULA = "peliculas/formPelicula";
	public static final String MOSTRARPELICULAS ="/peliculas/listPeliculas";
	
	// Redirecciona al método @GetMapping(value="/listarPeliculas")
	public static final String REEDIRECCIONPELICULAS = "/peliculas/listarPeliculas";
	
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
	public String guardar(Pelicula pelicula, BindingResult result, RedirectAttributes flashAttributes,
			@RequestParam("archivoImagen") MultipartFile file, HttpServletRequest request) {

		/*
		 * for(ObjectError error: result.getAllErrors()) {
		 * System.out.println("El formulario contiene un error/es." + error); }
		 */

		if (result.hasErrors()) {
			System.out.println("El formulario contiene errores.");
			return FORMPELICULA;
		}
		
		System.out.println("Recibimos el objeto película:" + pelicula);		
		
		try {
			
		if(!file.isEmpty()) {
			String nombreImagen = guardarImagen(request, file);
			pelicula.setImagen(nombreImagen);
		}
			
		peliculasService.insertar(pelicula);
		
		/* Nota: Cuando se utiliza un redirect en la página los model.addAttribute() no se mostrarán en pantalla ya que no vuelve al mismo formulario 
		 donde ha sucedido la acción. Para que dicho mensaje salga en pantalla deberemos de utilizar el RedirectAttributes.
		 	
		 	Model: Solo funciona si se mantiene la petición en la misma vista (return "peliculas")
		 	RedirectFlashAttribute: Funciona cuando se redirecciona a otra vista. (return:/peliculas/listarPeliculas)
		
		model.addAttribute("mensajeConfirmacion", "La pelicula se ha almacenado correctamente");
		*/
		flashAttributes.addFlashAttribute("mensajeConfirmacion", "La pelicula se ha almacenado correctamente");
		
		}catch (Exception e) {
			System.out.println("NO se ha podido almacenar correctamente la pelicula debido al siguiente error: " + e.getMessage());
		}
		
		
		return "redirect:"+REEDIRECCIONPELICULAS;
	}
	
	/* Se encarga de validar el formato de la fecha para indicarlo en formato dd-MM-yyyy */
	@InitBinder
	public void initBinder (WebDataBinder binder) {
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
		// Se puede especificar el campo de la fecha si se desea, pero se puede omitir si en el modelo "Pelicula" se indica el 	@DateTimeFormat(pattern = "dd-MM-yyyy")
		//binder.registerCustomEditor(Date.class, "fechaEstreno", new CustomDateEditor(format, false));
		
		binder.registerCustomEditor(Date.class, new CustomDateEditor(format, false));
	}
	
	
	/* Método que se encarga de subir imágenes */
	
	public String guardarImagen(HttpServletRequest request, MultipartFile multipart) {
		
		// Se obtiene el nombre original del archivo.
		String nombreOriginal = multipart.getOriginalFilename();
		
		// Se procede a obtener la ruta ABSOLUTA del directorio donde se almacenará las imágenes.
		String rutaFinal = request.getServletContext().getRealPath("/resources/images/");
		
		try {
			// Se forma el nombre del archivo
			File imageFile = new File(rutaFinal + nombreOriginal);
			
			// Se procede a guardar fisicamente la imágen dentro de el pc
			multipart.transferTo(imageFile);
			return nombreOriginal;
			
		}catch (Exception e) {
			System.out.println("Se ha producido un error al intentar guardar la imagen" + e.getMessage());
			return null;
		}
	}
	
	
	
	
}
