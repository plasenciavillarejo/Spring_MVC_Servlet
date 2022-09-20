package curso.spring.mvc.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import curso.spring.mvc.model.Pelicula;

@Repository
public interface IPeliculaDao extends JpaRepository<Pelicula, Integer>{

	public List<Pelicula> buscarTodas();
	public void insertar(Pelicula pelicula);
}
