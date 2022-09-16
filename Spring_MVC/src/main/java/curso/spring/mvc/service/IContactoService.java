package curso.spring.mvc.service;

import java.util.List;
import java.util.Map;

public interface IContactoService {

	public List<String> listarGeneros();
	public Map<String,String> listarExperiencia();
	public List<String> listarNotificaciones();
	
	
}
