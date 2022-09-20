package curso.spring.mvc.pruebaConexionBBDD;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PruebaConexionJPA {

	public static void main(String[] args) {
		
		// Creamos una instancia y le pasamos como parámetros el fichero que contiene la configuración de nuestros Beans.
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");
		
		/* Estos nos siver para verificar que estáms haciendo correctamente la conexión a nuestra BBDD. 
		 
		  Cuando lanzamos la ejecución, nos dará el siguiente error:
		  	Caused by: java.io.FileNotFoundException: class path resource [root-context-xml] cannot be opened because it does not exist
		  
		  Esto es causado por que estamos intentando crear la instancia desde una aplicación de consola (main), entonces el directorio no se encuentra en classpath,
		  por lo que deberemos de moverlo temporalmente en la siguiente dirección:
		  	- src/main/resources
		  
		  ** Si volvemos a lanzar nuevamente está clase, comprobaremos que se carga correctamente nuestro root-context.xml.
		  
		 Para validar si está ejecutandose correctamente nuestro fichero root-context.xml podremos hacer un cambio en la BBDD y en vez de cineapp indicarlo como cineapp1
		 podremos verificar que nos da un error de que no existe la BBDD. De está forma podremos verificar que nuestro fichero de configuración es correcto.
		  
		  Nota: cuando integremos la configuración correcta de JPA deberemos de mover nuevamente el fichero a nivel src/main/webapp/WEB-INF/spring
		  */
		
		
		
		// A manera de ejemplo vamos a ejecutar el context con el método close.
		context.close();
		
		
		
	}

}
