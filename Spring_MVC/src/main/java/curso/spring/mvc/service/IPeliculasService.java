package curso.spring.mvc.service;

import java.util.List;
import java.util.Map;

import curso.spring.mvc.model.Pelicula;

public interface IPeliculasService {

	List<Pelicula> buscarTodas();
	Pelicula buscarPorId(int id);
	void insertar(Pelicula pelicula);
	List<String> buscarGeneros();
	Map<String, String> buscarClasificacion();
	Map<String, String> buscarEstado();
}
