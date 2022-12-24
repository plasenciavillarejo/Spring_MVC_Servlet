package curso.spring.mvc.serviceImpl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import curso.spring.mvc.service.IEjemploUtileriaService;

@Service
public class EjemploUtileriaServiceImpl implements IEjemploUtileriaService {

	@Override
	public Map<String, String> listarClasificaciones() {
		Map<String, String> clasificaciones = new HashMap<>();
		clasificaciones.put("A", "Clasificacion A");
		clasificaciones.put("B", "Clasificacion B");
		clasificaciones.put("C", "Clasificacion C");
		
		return clasificaciones;
	}

}
