package curso.spring.mvc.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import curso.spring.mvc.model.Horario;
import curso.spring.mvc.service.IHorarioService;

@Service
public class HorarioServiceImpl implements IHorarioService{

	private static List<Horario> listHorario = new ArrayList<Horario>();
	
	
	
	@Override
	public List<String> listaSalas() {
		
		List<String> listaSala = new ArrayList<>();
		
		listaSala.add("Sala Premium");
		listaSala.add("Sala 1");
		listaSala.add("Sala 2");
		listaSala.add("Sala 3");
		
		return listaSala;
	}

	@Override
	public void save(Horario horario) {
		listHorario.add(horario);
	}

	@Override
	public List<Horario> listarHorarios() {
		return listHorario;
	}

	
	
}
