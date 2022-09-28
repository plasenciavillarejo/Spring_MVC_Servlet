package curso.spring.mvc.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import curso.spring.mvc.model.Horario;

@Repository
public interface IHorarioDao extends JpaRepository<Horario, Integer>{

	/*
	@Query(value = "select * from Horarios where id= :id and fecha= :fecha", nativeQuery = true)
	List<Horario> buscarHorario(int id, Date fecha);
	*/
	
	/* Agregamos un método personalizado sin necesidad de crear querys. 
	 	Nota: Declaramos QueryMethod, son querys personalizadas sin necesidad de realizar consultas debe empezar siempre por findBy seguido de lo 
	 	que queremos hacer. En este caso vamos a buscar Pelicula "id" y "fecha" ordenados por "hora".
	 	Pelicula: Hace referencia al atributo Pelicula que se encuentra dentro del horario.
	 	Id: Hace referencia al id de la pelicula
	 	Fecha: Hace referencia a la fecha del objeto horarios
	 	Hora: Hace referencia a la Hora del objeto horarios */
	public List<Horario> findByPelicula_IdOrderByHora(int idPelicula);
	
}
