package curso.spring.mvc.controller;

import java.util.logging.Logger;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import curso.spring.mvc.model.Noticia;

@Controller
@RequestMapping("/noticias")
public class NoticiasController {

	
	public static final Logger LOGGER = Logger.getAnonymousLogger();
	public static final String VISTAFORMULARIONOTICIAS = "noticias/formNoticia";
	
	
	
	@GetMapping(value = "/create")
	public String crear() {
		return VISTAFORMULARIONOTICIAS;
	}
	
	@PostMapping(value= "/save")
	public String guardar(@RequestParam("titulo") String titulo, @RequestParam("estatus") String estatus, 
			@RequestParam("detalle") String detalle, Model model) {
		
		
		Noticia noticia = new Noticia();
		noticia.setTitulo(titulo);
		noticia.setEstatus(estatus);
		noticia.setDetalle(detalle);
		
		
		LOGGER.info("El título de la noticia es " + noticia.getTitulo());
		
		return VISTAFORMULARIONOTICIAS;
	}
	
}
