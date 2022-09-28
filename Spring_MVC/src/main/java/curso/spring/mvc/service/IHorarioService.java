package curso.spring.mvc.service;

import java.util.Date;
import java.util.List;

import curso.spring.mvc.model.Horario;

public interface IHorarioService {

	public void save(Horario horario);
	public List<Horario> listarHorarios();
	
	// List<Horario> buscarHorario(int id, Date fecha);
	public List<Horario> findByPelicula_IdOrderByHora(int idPelicula);
}
