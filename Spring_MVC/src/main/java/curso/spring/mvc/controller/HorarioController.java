package curso.spring.mvc.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import curso.spring.mvc.model.Horario;
import curso.spring.mvc.model.Pelicula;
import curso.spring.mvc.service.IPeliculasService;

@Controller
@RequestMapping(value = "/horario")
public class HorarioController {

	@Autowired
	private IPeliculasService peliculaService;
	
	private static final String HORARIOPRINCIPAL = "/horario/formHorario";
	
	private static final String REDIRECIONHORARIOS = "/horario/crear";
	
	@GetMapping(value = "/crear")
	public String crear(@ModelAttribute("horario") Horario horario, Model model) {
		
		List<Pelicula> listarPeliculas = peliculaService.buscarTodas();
		List<String> listPelicula = new ArrayList<>();
		
		for(Pelicula peli: listarPeliculas) {
			if(!peli.getTitulo().isEmpty()) {
				listPelicula.add(peli.getTitulo());
			}
		}
		
		model.addAttribute("listarPelicluas", listPelicula);
		
		return HORARIOPRINCIPAL;
	}
	
	@PostMapping(value = "/save")
	public String guardar(@Validated @ModelAttribute("horario") Horario horario,BindingResult result ,RedirectAttributes flashAttributes,Model model) {
		
		return "redirect:" + REDIRECIONHORARIOS;
	}
}
