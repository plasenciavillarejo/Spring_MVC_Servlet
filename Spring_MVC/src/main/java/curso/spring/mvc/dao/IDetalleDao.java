package curso.spring.mvc.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import curso.spring.mvc.model.Detalle;

@Repository
public interface IDetalleDao extends CrudRepository<Detalle, Integer>{

}
