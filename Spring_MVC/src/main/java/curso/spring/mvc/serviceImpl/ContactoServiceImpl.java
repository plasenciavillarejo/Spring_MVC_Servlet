package curso.spring.mvc.serviceImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.context.event.ApplicationListenerMethodAdapter;
import org.springframework.stereotype.Service;

import curso.spring.mvc.service.IContactoService;

@Service
public class ContactoServiceImpl implements IContactoService{

	public ContactoServiceImpl(){
		
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
	
}
