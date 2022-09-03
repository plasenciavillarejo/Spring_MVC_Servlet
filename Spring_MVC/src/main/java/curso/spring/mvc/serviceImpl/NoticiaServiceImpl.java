package curso.spring.mvc.serviceImpl;

import org.springframework.stereotype.Service;

import curso.spring.mvc.model.Noticia;
import curso.spring.mvc.service.INoticiaService;

@Service
public class NoticiaServiceImpl implements INoticiaService{

	public NoticiaServiceImpl() {
		System.out.println("Verificando que la instancia NoticiaServiceImpl.java creada es correcta.");
	}
	
	@Override
	public void guardar(Noticia noticia) {
		System.out.println("Procedemos a guardar la noticia con los siguientes parámetros:" + noticia.getTitulo());
	}

}
