package curso.spring.mvc.service;

import java.util.List;
import java.util.Map;

import curso.spring.mvc.model.Pelicula;

public interface IPeliculasService {

	public List<Pelicula> buscarTodas();
	
	public Pelicula buscarPorId(int id);
	
	public void insertar(Pelicula pelicula);
	
	public void borrarPelicula(Pelicula pelicula);
	
	
}
