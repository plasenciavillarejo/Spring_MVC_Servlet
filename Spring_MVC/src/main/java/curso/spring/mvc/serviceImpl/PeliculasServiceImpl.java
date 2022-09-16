package curso.spring.mvc.serviceImpl;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import curso.spring.mvc.model.Pelicula;
import curso.spring.mvc.service.IPeliculasService;

@Service
public class PeliculasServiceImpl implements IPeliculasService{

	private static List<Pelicula> listaPeliculas = null;
	
	public PeliculasServiceImpl() {
		
		System.out.println("Verificando que la instancia PeliculasServiceImpl.java creada es correcta.");
		
		SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");

		try {
			listaPeliculas = new LinkedList<>();

			Pelicula pelicula1 = new Pelicula();
			pelicula1.setId(1);
			pelicula1.setTitulo("La bella y la bestía.");
			pelicula1.setDuracion(145);
			pelicula1.setClasificacion("B");
			pelicula1.setGenero("Adventura");
			pelicula1.setImagen("estreno6.png");
			pelicula1.setFechaEstreno(formato.parse("15-09-2022"));

			listaPeliculas.add(pelicula1);

			Pelicula pelicula2 = new Pelicula();
			pelicula2.setId(2);
			pelicula2.setTitulo("Venom");
			pelicula2.setDuracion(129);
			pelicula2.setClasificacion("A");
			pelicula2.setGenero("Acción");
			pelicula2.setFechaEstreno(formato.parse("15-09-2022"));
			pelicula2.setImagen("venom.jpg");
			listaPeliculas.add(pelicula2);

			Pelicula pelicula3 = new Pelicula();
			pelicula3.setId(3);
			pelicula3.setTitulo("Kong la isla calavera");
			pelicula3.setDuracion(129);
			pelicula3.setClasificacion("C");
			pelicula3.setGenero("Acción");
			pelicula3.setFechaEstreno(formato.parse("16-09-2022"));
			pelicula3.setImagen("estreno4.jpg");
			pelicula3.setEstatus("Inactiva");
			listaPeliculas.add(pelicula3);
			
			Pelicula pelicula4 = new Pelicula();
			pelicula4.setId(4);
			pelicula4.setTitulo("Contratiempo");
			pelicula4.setDuracion(145);
			pelicula4.setClasificacion("A");
			pelicula4.setGenero("Suspense");
			pelicula4.setFechaEstreno(formato.parse("17-09-2022"));
			pelicula4.setImagen("estreno7.png");
			listaPeliculas.add(pelicula4);
			
			Pelicula pelicula5 = new Pelicula();
			pelicula5.setId(5);
			pelicula5.setTitulo("Life: Vida Inteligentes");
			pelicula5.setDuracion(167);
			pelicula5.setClasificacion("C");
			pelicula5.setGenero("Miedo");
			pelicula5.setFechaEstreno(formato.parse("10-06-2019"));
			pelicula5.setImagen("estreno5.png");
			listaPeliculas.add(pelicula5);
			

		} catch (Exception e) {
			System.out.println("Ha fallado la insercción de peliculas");
		}

	}
	
	
	@Override
	public List<Pelicula> buscarTodas() {
		return listaPeliculas;
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
		listaPeliculas.add(pelicula);
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
