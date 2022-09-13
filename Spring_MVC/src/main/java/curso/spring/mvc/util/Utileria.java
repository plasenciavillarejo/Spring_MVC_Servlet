package curso.spring.mvc.util;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

public class Utileria {

	
	/* Método encargado de recibir un número y devolver las fechas de los siguientes días.*/
	
	public static List<String> getNextDays(int count){
	
		SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy");
		
		Date start = new Date();
		Calendar calendario = Calendar.getInstance();
		// Siguientes N días segun el count que reciba. En caso de indicar un 3, devolvería el día de hoy y dos más en la lista.
		calendario.add(Calendar.DAY_OF_MONTH, count);
		Date endDate = calendario.getTime();
		
		GregorianCalendar gCalendar = new GregorianCalendar();
		gCalendar.setTime(start);
		
		List<String> nextDays = new ArrayList<String>();
		
		while(!gCalendar.getTime().after(endDate)) {
			Date d = gCalendar.getTime();
			gCalendar.add(Calendar.DATE, 1);
			nextDays.add(formatoFecha.format(d));
		}
		
		return nextDays;
	}

	
	/* Método que se encarga de subir imágenes */
	
	public static String guardarImagen(HttpServletRequest request, MultipartFile multipart) {
		
		// Se obtiene el nombre original del archivo.
		String nombreOriginal = multipart.getOriginalFilename();
		
		// Quitamos espacios que cotenga el nombre de la imagen
		nombreOriginal = nombreOriginal.replace(" ", "");
		
		// Se procede a obtener la ruta ABSOLUTA del directorio donde se almacenará las imágenes.
		String rutaFinal = request.getServletContext().getRealPath("/resources/images/");
		
		// Se utiliza el generador de caracteres para darle el nombre final al archivo.
		String nombreFinal = randomAlphaNumeric(8) + nombreOriginal;
		
		try {
			// Se forma el nombre del archivo
			File imageFile = new File(rutaFinal + nombreFinal);
			
			System.out.println(imageFile);
			
			// Se procede a guardar fisicamente la imágen dentro de el pc
			multipart.transferTo(imageFile);
			return nombreFinal;
			
		}catch (Exception e) {
			System.out.println("Se ha producido un error al intentar guardar la imagen" + e.getMessage());
			return null;
		}
	}
	
	
	// Método para generar cadena de longitud N de caracacteres aleatorios.
	public static String randomAlphaNumeric(int count) {
		String CARACTERES = "ABCDEFGHIJKLMNÑOPQRSTUVWXYZ0123456789";
		
		StringBuilder builder = new StringBuilder();
		
		/* Count indica la longitud del parámetro de la cadena, si es diferente de 0, se genera un carácter aleatorio de una posicion 
		  de la cadena CARACTERES (Letras y Números).
		  
		 */
		while(count -- != 0) {
			int caracter = (int) (Math.random() * CARACTERES.length());
			builder.append(CARACTERES.charAt(caracter));
		}
		
		return builder.toString();
	}
	

	
}
