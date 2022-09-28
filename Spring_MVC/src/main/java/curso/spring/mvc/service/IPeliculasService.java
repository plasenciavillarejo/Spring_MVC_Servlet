package curso.spring.mvc.service;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import curso.spring.mvc.model.Pelicula;

public interface IPeliculasService {

	public List<Pelicula> buscarTodas();
	
	public Pelicula buscarPorId(int id);
	
	public void insertar(Pelicula pelicula);
	
	public void borrarPelicula(Pelicula pelicula);
	
	public Page<Pelicula> buscarTodas(Pageable page);
	
}
