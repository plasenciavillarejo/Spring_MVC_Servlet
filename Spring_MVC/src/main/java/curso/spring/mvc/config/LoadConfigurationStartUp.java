package curso.spring.mvc.config;

import javax.servlet.http.HttpServlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class LoadConfigurationStartUp extends HttpServlet{


	private static final long serialVersionUID = 1L;

	public static final Logger LOGGER = LoggerFactory.getLogger(LoadConfigurationStartUp.class);
	
	@Value("${PATH_REPO}")
	public String repo;
	
	// Método encargado de realizar la carga inicial antes de el contexto de spring
	public void init() {
		System.out.println("");
		System.out.println("");
		LOGGER.info(" ### CARGA INICIAL ANTES DE EL CONTEXTO DE SPRING. ### ");
		LOGGER.info("########################################################");
		LOGGER.info("Clase encargada de realizar una carga inicial de las variables deseadas antes de "
				+ "de cargar el contexto de spring. Muy util cuando se pretende inicializar algo antes de tiempo.");
		System.out.println("");
	}
	
}
