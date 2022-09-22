package curso.spring.mvc.service;

import java.util.List;

import curso.spring.mvc.model.Horario;

public interface IHorarioService {

	public void save(Horario horario);
	public List<Horario> listarHorarios();
}
