package curso.spring.mvc.config;

import java.io.File;

import javax.servlet.ServletContextEvent;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.LoggerContext;
import org.apache.logging.log4j.web.Log4jServletContextListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogContextListener extends Log4jServletContextListener {

	public static final Logger LOGGER = LoggerFactory.getLogger(LogContextListener.class);
	
	/* 1.- Le indicamos donde se va a ubicar nuestro fichero de configuración dentro de nuestro equipo. */
	@Override
	public void contextInitialized(ServletContextEvent event) {
		LOGGER.info("Se encarga de inicializar nuestro fichero de configuración para el log4j2");
		/*
		LoggerContext context = (LoggerContext) LogManager.getContext(false);
		File file = new File("/repositio/plasencia/log4jConfiguracion/log4j2.xml");
		context.setConfigLocation(file.toURI());
		super.contextInitialized(event);
		*/
	}

	
	
}
