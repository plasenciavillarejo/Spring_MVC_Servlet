package curso.spring.mvc.service;

import java.util.List;

import curso.spring.mvc.model.Banner;

public interface IBannerService {

	public void insertar(Banner banner);
	public List<Banner> mostrarCarrousel();
	public List<String> estatus();
	
}
