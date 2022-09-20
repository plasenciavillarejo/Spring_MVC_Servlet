package curso.spring.mvc.serviceImpl;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import curso.spring.mvc.dao.IPeliculaDao;
import curso.spring.mvc.model.Pelicula;
import curso.spring.mvc.service.IPeliculasService;

@Service
public class PeliculasServiceImpl implements IPeliculasService{

	@Autowired
	private IPeliculaDao peliculaDao;
	
	
	private static List<Pelicula> listaPeliculas = null;
	
	public PeliculasServiceImpl() {
	
	}
	
	
	@Override
	public List<Pelicula> buscarTodas() {
		return peliculaDao.buscarTodas();
	}


	@Override
	public Pelicula buscarPorId(int id) {
		
		for(Pelicula peli: listaPeliculas) {
			if(peli.getId() == id) {
				return peli;
			}
		}
		return null;
	}


	@Override
	public void insertar(Pelicula pelicula) {
		peliculaDao.save(pelicula);
	}


	@Override
	public List<String> buscarGeneros() {
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
	public Map<String, String> buscarClasificacion() {

		Map<String, String> clasificacion = new HashMap<>();
		clasificacion.put("A", "Clasificacion A");
		clasificacion.put("B", "Clasificacion B");
		clasificacion.put("C", "Clasificacion C");
		return clasificacion;
	}

	@Override
	public Map<String, String> buscarEstado() {

		Map<String, String> estado = new HashMap<>();
		estado.put("Activa", "Activa");
		estado.put("Inactiva", "Inactiva");

		return estado;
	}

	
}
