package curso.spring.mvc.validator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import curso.spring.mvc.model.Pelicula;

public class PeliculasValidator implements Validator{

	
	public static final Logger LOGGER = LoggerFactory.getLogger(PeliculasValidator.class);
	
	@Override
	public boolean supports(Class<?> clazz) {
		return Pelicula.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {

		Pelicula pelicula = (Pelicula) target;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "titulo", "pelicula.titulo", "El titulo no puede estar vacío o contener espacios.");
		
	}
}
