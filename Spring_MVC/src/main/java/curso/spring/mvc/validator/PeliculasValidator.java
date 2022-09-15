package curso.spring.mvc.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import curso.spring.mvc.model.Pelicula;

public class PeliculasValidator implements Validator {

	public static final Logger LOGGER = LoggerFactory.getLogger(PeliculasValidator.class);

	public static final String FORMATODURACION = "[a-zA-z]+";
	
	@Override
	public boolean supports(Class<?> clazz) {
		return Pelicula.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {

		Pelicula pelicula = (Pelicula) target;

		// ValidationUtils.rejectIfEmptyOrWhitespace(errors, "titulo",
		// "pelicula.titulo");

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "titulo", "pelicula.titulo",
				"El titulo no puede estar vacío o contener espacios.");
		
		/*ValidationUtils.rejectIfEmptyOrWhitespace(errors, "duracion", "pelicula.duracion",
				"La duración no puede estar vacía."); */

		if(pelicula.getDuracion() == 0) {
			errors.rejectValue("duracion","pelicula.duracion", "La duración de la pelicula solo debe contener digitos.");
		}
		
		/* Nota: Si se quiere validar un valor int que no contenga string cuando pones en el input un 123s
		 * automaticamente pelicula.getDuracion() tiene un valor de "0" por lo que no almacena las letras.
		if (!validarDigitos(pelicula.getDuracion())) {
			errors.rejectValue("duracion","pelicula.duracion", "La duración de la pelicula solo debe contener digitos.");
		}
		*/
		
		if(pelicula.getClasificacion().equalsIgnoreCase("NONE")) {
			errors.rejectValue("clasificacion","pelicula.clasificacion", "Debe escoger alguna opción disponible");
		}
		
		if(pelicula.getGenero().equalsIgnoreCase("NONE")) {
			errors.rejectValue("genero","pelicula.genero", "Debe escoger alguna opción disponible");
		}
		
		if(pelicula.getEstatus().equalsIgnoreCase("NONE")) {
			errors.rejectValue("estatus","pelicula.estatus", "Debe escoger alguna opción disponible");
		}
		
	}

	public boolean validarDigitos(int duracion) {
		
		String dura = String.valueOf(duracion);
		
		//Pattern pattern = Pattern.compile("[0-9]+");
		//Matcher match = pattern.matcher(dura);

		if (!dura.matches(FORMATODURACION)) {
			return true;
		}

		return false;
	}

}
