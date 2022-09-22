package curso.spring.mvc.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import curso.spring.mvc.dao.IHorarioDao;
import curso.spring.mvc.model.Horario;
import curso.spring.mvc.service.IHorarioService;

@Service
public class HorarioServiceImpl implements IHorarioService{

	@Autowired
	private IHorarioDao horarioDao;
	
	@Override
	public void save(Horario horario) {
		horarioDao.save(horario);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Horario> listarHorarios() {
		return horarioDao.findAll();
	}
	
	
}
