package curso.spring.mvc.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import curso.spring.mvc.model.Usuario;

@Repository
public interface IUsuarioDao extends JpaRepository<Usuario, Integer> {

}
