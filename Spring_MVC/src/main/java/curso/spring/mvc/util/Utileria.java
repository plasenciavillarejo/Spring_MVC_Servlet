package curso.spring.mvc.util;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

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
	
}
