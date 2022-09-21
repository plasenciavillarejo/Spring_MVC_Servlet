package curso.spring.mvc.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import curso.spring.mvc.model.Detalle;

@Repository
public interface IDetalleDao extends JpaRepository<Detalle, Integer>{

}
