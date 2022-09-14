package curso.spring.mvc.serviceImpl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import curso.spring.mvc.controller.NoticiasController;
import curso.spring.mvc.model.Banner;
import curso.spring.mvc.service.IBannerService;

@Service
public class BannerServiceImpl implements IBannerService{

	private static List<Banner> listarBanners= null;
	public static final Logger LOGGER = LoggerFactory.getLogger(NoticiasController.class);
	
	public BannerServiceImpl() throws ParseException {
		LOGGER.info("Verificando que la instancia BannerServiceImpl.java creada es correcta.");
		
		Date date = new Date();
		SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");

	
		
		listarBanners = new ArrayList<>();
		
		Banner banner1 = new Banner();
		
		banner1.setId(1);
		banner1.setTitulo("King Kong Vs Logan");
		banner1.setEstatus("Activa");
		banner1.setFecha(formato.parse("25-09-2022"));
		banner1.setArchivo("slide1.jpg");
		
		listarBanners.add(banner1);
		
		Banner banner2 = new Banner();
		banner2.setId(2);
		banner2.setTitulo("La bella y la bestía");
		banner2.setEstatus("Activa");
		banner2.setFecha(formato.parse("24-09-2022"));
		banner2.setArchivo("slide2.jpg");
		
		listarBanners.add(banner2);
		
		Banner banner3 = new Banner();
		banner3.setId(3);
		banner3.setTitulo("Spiderman de regreso a casa");
		banner3.setEstatus("Activa");
		banner3.setFecha(formato.parse("22-09-2022"));
		banner3.setArchivo("slide3.jpg");
		
		listarBanners.add(banner3);
		
		Banner banner4 = new Banner();
		banner4.setId(4);
		banner4.setTitulo("Cars");
		banner4.setEstatus("Activa");
		banner4.setFecha(formato.parse("21-09-2022"));
		banner4.setArchivo("slide4.jpg");
		
		listarBanners.add(banner4);
		
		Banner banner5 = new Banner();
		banner5.setId(5);
		banner5.setTitulo("Un golpe con estilo");
		banner5.setEstatus("Inactiva");
		banner5.setFecha(formato.parse("19-08-2022"));
		banner5.setArchivo("slide5.jpg");
		
		listarBanners.add(banner5);
	}
	
	
	@Override
	public void insertar(Banner banner) {
		listarBanners.add(banner);
	}
	
	@Override
	public List<Banner> mostrarCarrousel() {
		return listarBanners;
	}




}
