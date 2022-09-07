package curso.spring.mvc.service;

import java.util.List;

import curso.spring.mvc.model.Pelicula;

public interface IPeliculasService {

	List<Pelicula> buscarTodas();
	Pelicula buscarPorId(int id);
	void insertar(Pelicula pelicula);
}
