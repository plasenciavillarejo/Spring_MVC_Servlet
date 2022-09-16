package curso.spring.mvc.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import curso.spring.mvc.model.Contacto;
import curso.spring.mvc.service.IContactoService;

@Controller
@RequestMapping("/contacto")
public class ContactoController {

	public static final Logger LOGGER = LoggerFactory.getLogger(ContactoController.class);

	
	private static final String CONTACTOPRINCIPAL = "/contacto/formContacto";
	
	@Autowired
	private IContactoService contactoService;
	
	
	@GetMapping(value = "/index")
	public String index(@ModelAttribute Contacto contacto,Model model) {
		
		List<String> listarGeneros =  new ArrayList<>();
		Map<String, String> listarExperiencia = new HashMap<>();
		List<String> listarNotificaciones = new ArrayList<>();
		
		try {
			listarGeneros = contactoService.listarGeneros();
			listarExperiencia = contactoService.listarExperiencia();
			listarNotificaciones = contactoService.listarNotificaciones();
			
		}catch (Exception e) {
			LOGGER.error("Ha fallado la busqueda/as. " + e.getMessage());
		}
		
		model.addAttribute("listarGeneros", listarGeneros);
		model.addAttribute("listarExperiencia", listarExperiencia);
		model.addAttribute("listarNotificaciones", listarNotificaciones);
		
		
		return CONTACTOPRINCIPAL;
	}
	
}
