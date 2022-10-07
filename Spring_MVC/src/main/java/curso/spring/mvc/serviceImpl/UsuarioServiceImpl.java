package curso.spring.mvc.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import curso.spring.mvc.dao.IUsuarioDao;
import curso.spring.mvc.model.Usuario;
import curso.spring.mvc.service.IUsuarioService;

@Service
public class UsuarioServiceImpl implements IUsuarioService{

	@Autowired
	private IUsuarioDao usuarioDao;
	
	@Override
	public void guardar(Usuario usuario) {
		usuarioDao.save(usuario);
	}

	
}
