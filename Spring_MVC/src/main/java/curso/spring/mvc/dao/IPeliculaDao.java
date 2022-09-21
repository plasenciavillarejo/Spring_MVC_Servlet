package curso.spring.mvc.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import curso.spring.mvc.model.Pelicula;

@Repository
public interface IPeliculaDao extends JpaRepository<Pelicula, Integer>{
	
	@Query(value = "select c from Pelicula c where c.id= ?1")
	public Pelicula buscarPorId(int id);
	

	
}
