package curso.spring.mvc.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
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

import curso.spring.mvc.model.Horario;
import curso.spring.mvc.model.Pelicula;
import curso.spring.mvc.service.IHorarioService;
import curso.spring.mvc.service.IPeliculasService;
import curso.spring.mvc.util.Utileria;

@Controller
@RequestMapping(value = "/horario")
public class HorarioController {

	@Autowired
	private IPeliculasService peliculaService;
	
	@Autowired
	private IHorarioService horarioService;
	
	private static final String HORARIOPRINCIPAL = "/horario/formHorario";
	
	private static final String REDIRECIONHORARIOS = "/horario/crear";
	
	public static final Logger LOGGER = LoggerFactory.getLogger(HorarioController.class);
	
	/* Se encarga de validar el formato de la fecha para indicarlo en formato dd-MM-yyyy */
	@InitBinder
	public void initBinder (WebDataBinder binder) {
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
		
		/* Se puede especificar el campo de la fecha si se desea, pero se puede omitir si en el modelo "Pelicula"
		   se indica el 	@DateTimeFormat(pattern = "dd-MM-yyyy")
			binder.registerCustomEditor(Date.class, "fechaEstreno", new CustomDateEditor(format, false)); */
		
		binder.registerCustomEditor(Date.class, new CustomDateEditor(format, false));
		
		//binder.setValidator(new PeliculasValidator());
	}
	
	@GetMapping(value = "/crear")
	public String crear(@ModelAttribute("horario") Horario horario, Model model) {
		
		List<Pelicula> listarPeliculas = peliculaService.buscarTodas();
		List<String> listPelicula = new ArrayList<>();
		
		for(Pelicula peli: listarPeliculas) {
			if(!peli.getTitulo().isEmpty()) {
				listPelicula.add(peli.getTitulo());
			}
		}
		
		String hora =   relojHorario();
		
		model.addAttribute("listarPelicluas", listPelicula);
		model.addAttribute("relojHorario", hora);
		model.addAttribute("listarSalas", Utileria.listarSalas());
		
		return HORARIOPRINCIPAL;
	}
	
	@PostMapping(value = "/save")
	public String guardar(@Validated @ModelAttribute("horario") Horario horario,BindingResult result,
			RedirectAttributes flashAttributes,Model model, Pelicula pelicula) {
		
		if(result.hasErrors()) {
			List<Pelicula> listarPeliculas = peliculaService.buscarTodas();
			List<String> listPelicula = new ArrayList<>();
			
			for(Pelicula peli: listarPeliculas) {
				if(!peli.getTitulo().isEmpty()) {
					listPelicula.add(peli.getTitulo());
				}
			}
			
			model.addAttribute("listarPelicluas", listPelicula);
			model.addAttribute("listarSalas", Utileria.listarSalas());
			
			return HORARIOPRINCIPAL;
		}
		
		if(horario != null) {
			List<Pelicula> buscarPelicula = peliculaService.buscarTodas();
			
			LOGGER.info("Se procede a almacenar el horario de la siguiente pelicula." + horario.getPelicula().getTitulo());
			
			for(Pelicula peli: buscarPelicula) {
				if(peli.getTitulo().equalsIgnoreCase(horario.getPelicula().getTitulo())) {
					horario.setPelicula(peli);
					horarioService.save(horario);
					break;
				}
			}
		}
		return "redirect:" + REDIRECIONHORARIOS;
	}
	
	
	@GetMapping(value = "/listarHorarios")
	public String listarHorarios(Model model) {
		
		// Cogerá los datos la tabla que hay en detalle.jsp
		
		List<Horario> listarHorarios = horarioService.listarHorarios();
		
		if(listarHorarios != null) {
			LOGGER.info("Se procede a listar el horario de la siguiente pelicula: " + listarHorarios.get(0).getPelicula().getTitulo());
		}
		
		return null;
	}
	
	
	
	
	
	public String relojHorario() {

		SimpleDateFormat formato = new SimpleDateFormat("HH:mm:ss");

		Date date = new Date();
		Calendar calendar = Calendar.getInstance();

		calendar.setTime(date);

		date = calendar.getTime();

		String fechaActual = formato.format(date);

		return fechaActual;

	}

	public Timer ejecucionReloj() {

		Timer timer = new Timer();

		timer.schedule(new TimerTask() {

			@Override
			public void run() {
				while (true) {
					relojHorario();
				}
			}
			// (TiempoRetardo, TiempoRepeticion) -> (0,1) Se ejcuta directamente.
		}, 0, 1000);

		return timer;
	}
	
	
}
