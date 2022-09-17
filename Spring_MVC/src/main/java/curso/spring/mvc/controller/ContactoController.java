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
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import curso.spring.mvc.model.Contacto;
import curso.spring.mvc.service.IContactoService;
import curso.spring.mvc.validator.ContactoValidator;

@Controller
@RequestMapping("/contacto")
public class ContactoController {

	public static final Logger LOGGER = LoggerFactory.getLogger(ContactoController.class);

	private static final String CONTACTOPRINCIPAL = "/contacto/formContacto";
	
	private static final String REDIRECIONCONTACTO = "/contacto/index";
	
	@Autowired
	private IContactoService contactoService;
	
	@InitBinder
	public void initBindder(WebDataBinder binder) {
		binder.setValidator(new ContactoValidator());
	}
	
	@GetMapping(value = "/index")
	public String index(@ModelAttribute("contacto") Contacto contacto,Model model) {
		
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

	@PostMapping(value = "/save")
	public String guardar(@Validated @ModelAttribute("contacto") Contacto contacto, BindingResult result, 
			Model model, RedirectAttributes flashAttributes) {
		
		if(result.hasErrors()) {
			LOGGER.error("El formulario contiene errores.");
			
			model.addAttribute("listarGeneros", contactoService.listarGeneros());
			model.addAttribute("listarExperiencia", contactoService.listarExperiencia());
			model.addAttribute("listarNotificaciones", contactoService.listarNotificaciones());
			
			return CONTACTOPRINCIPAL;
		}
		
		if(contacto != null) {
			contactoService.save(contacto);
			flashAttributes.addFlashAttribute("formularioContacto", "ok");
			LOGGER.info("Se ha guardaro correctamente el formulario ->" + contacto.getEmail()+ " " + contacto.getNombre());
		}
		
		
		return "redirect:" + REDIRECIONCONTACTO;
	}
}
