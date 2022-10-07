package curso.spring.mvc.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import curso.spring.mvc.model.Perfil;

@Repository
public interface IPerfilDao extends JpaRepository<Perfil, Integer>{

}
