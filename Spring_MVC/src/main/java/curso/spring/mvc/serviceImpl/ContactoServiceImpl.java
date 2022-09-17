package curso.spring.mvc.serviceImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.context.event.ApplicationListenerMethodAdapter;
import org.springframework.stereotype.Service;

import curso.spring.mvc.model.Contacto;
import curso.spring.mvc.service.IContactoService;

@Service
public class ContactoServiceImpl implements IContactoService{

	private static List<Contacto> listarContactos = new ArrayList<>();
	
	public ContactoServiceImpl(){
			
		String [] g = {"Infantil","Romántica"};
		String [] n = {"Estrenos", "Promociones"};
		
		Contacto contacto = new Contacto();
		contacto.setId(1);
		contacto.setNombre("Jose Plasencia");
		contacto.setEmail("plasencia@gmail.com");
		contacto.setGeneros(g);
		contacto.setRating(4);
		contacto.setNotificaciones(n);
		contacto.setComentarios("La página me ha gustado mucho por que mezcla spring mvc 5.0 y boostrap nuevo. Un toque especial y muy elegante.");
		
		listarContactos.add(contacto);
	}

	@Override
	public List<String> listarGeneros() {
		
		List<String> generos = new LinkedList<>();
		
		generos.add("Accion");
		generos.add("Aventura");
		generos.add("Clasicas");
		generos.add("Comedia Romantica");
		generos.add("Drama");
		generos.add("Terror");
		generos.add("Infantil");
		generos.add("Accion y Aventura");
		generos.add("Romantica");
		
		return generos;
	}

	@Override
	public Map<String,String> listarExperiencia() {
		
		Map<String, String> experiencia = new HashMap<>();
		experiencia.put("1", "Muy Mala");
		experiencia.put("2", "Mala");
		experiencia.put("3", "Regular");
		experiencia.put("4", "Buena");
		experiencia.put("5", "Muy Buena");
		
		return experiencia;
	}

	@Override
	public List<String> listarNotificaciones() {
		
		List<String> listarNotificaciones = new ArrayList<>();
		listarNotificaciones.add("Estrenos");
		listarNotificaciones.add("Promociones");
		listarNotificaciones.add("Noticias");
		listarNotificaciones.add("Preventas");
		
		return listarNotificaciones;
	}

	@Override
	public void save(Contacto contacto) {
		listarContactos.add(contacto);
	}
	
}
