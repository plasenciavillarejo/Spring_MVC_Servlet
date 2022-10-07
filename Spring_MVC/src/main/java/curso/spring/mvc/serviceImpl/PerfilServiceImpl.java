package curso.spring.mvc.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import curso.spring.mvc.dao.IPerfilDao;
import curso.spring.mvc.model.Perfil;
import curso.spring.mvc.service.IPerfilService;

@Service
public class PerfilServiceImpl implements IPerfilService{

	@Autowired
	private IPerfilDao perfilDao;
	
	@Override
	public void guardar(Perfil perfil) {
		perfilDao.save(perfil);
	}

}
