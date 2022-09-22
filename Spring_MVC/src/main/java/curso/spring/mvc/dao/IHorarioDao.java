package curso.spring.mvc.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import curso.spring.mvc.model.Horario;

@Repository
public interface IHorarioDao extends JpaRepository<Horario, Integer>{


}
