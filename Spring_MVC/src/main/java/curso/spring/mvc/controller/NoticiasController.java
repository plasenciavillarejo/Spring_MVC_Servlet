package curso.spring.mvc.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import curso.spring.mvc.model.Noticia;
import curso.spring.mvc.service.INoticiaService;

@Controller
@RequestMapping("/noticias")
public class NoticiasController {

	@Autowired
	private INoticiaService noticiaService;
	
	public static final Logger LOGGER = LoggerFactory.getLogger(NoticiasController.class);
	
	public static final String VISTAFORMULARIONOTICIAS = "noticias/formNoticia";
	
	
	@GetMapping(value = "/create")
	public String crear() {
		return VISTAFORMULARIONOTICIAS;
	}
	
	@PostMapping(value = "/save")
	public String guardar(Noticia noticia, Model model) {

		LOGGER.info("Se procede a guardar la noticia.");
		LOGGER.debug("");
		LOGGER.error("sdfasdf");
		LOGGER.isInfoEnabled();
		
		try {
			noticiaService.guardar(noticia);
		} catch (Exception e) {
			LOGGER.info("No se ha podido guardar la noticia debido al siguiente error: " + e);
		}
		LOGGER.info("Se ha guardado corretamente la noticia, el título de la noticia es " + noticia.getTitulo());

		return VISTAFORMULARIONOTICIAS;
	}
	
}
