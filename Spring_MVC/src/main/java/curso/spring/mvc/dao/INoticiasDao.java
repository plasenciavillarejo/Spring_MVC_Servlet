package curso.spring.mvc.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import curso.spring.mvc.model.Noticia;

// @Repository -> Se encarga de dar de alta un Bean en nuestro contendor. Le indicaremos a spring que deberá de crear un bean relacionado con acciones en BBDD.

@Repository
public interface INoticiasDao extends JpaRepository<Noticia, Long> {

	// select * from Noticias
	List<Noticia> findBy();
	
	// select * from Noticias where estatus = ?
	List<Noticia> findByEstatus(String estatus);
	
	// where fecha = ?
	List<Noticia> findByFecha(Date fecha);
	
	// where estatus=? and fecha=?
	List<Noticia> findByEstatusAndFecha(String estatus, Date fecha);
	
	// where estatus=? or fecha=?
	List<Noticia> findByEstatusOrFecha(String estatus, Date fecha);
	
	// where fecha between ? and ?
	List<Noticia> findByFechaBetween(Date fecha1, Date fecha2);
	
	// where id between ? and ?
	List<Noticia> findByIdBetween(int n1, int n2);
	
}
