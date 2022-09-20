package curso.spring.mvc.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import curso.spring.mvc.model.Horario;

@Repository
public interface IHorarioDao extends CrudRepository<Horario, Integer>{

}
