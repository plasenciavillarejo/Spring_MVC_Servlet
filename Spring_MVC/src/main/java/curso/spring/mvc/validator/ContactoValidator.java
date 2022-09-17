package curso.spring.mvc.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import curso.spring.mvc.model.Contacto;

public class ContactoValidator implements Validator{

	private static final String EXPRESIONGMAL = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$";
	
	@Override
	public boolean supports(Class<?> clazz) {
		return Contacto.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		Contacto contacto = (Contacto) target;
	
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nombre", "contacto.nombre", "EL nombre no puede estar vacío.");
		
		
		//Pattern pattern = Pattern.compile(EXPRESIONGMAL);
		//Matcher matcher = pattern.matcher();
		
		if(!contacto.getEmail().matches(EXPRESIONGMAL)) {
			errors.rejectValue("email", "contacto.email", "Debe introducir un e-mail válido.");
		}
		
		if(contacto.getComentarios().isEmpty()) {
			errors.rejectValue("comentarios", "contacto.comentarios", "La caja de comentarios debe llevar algo escrito en ella.");
		}
		
		if(contacto.getRating() == 0) {
			errors.rejectValue("rating", "contacto.rating", "Debe seleccionar alguna de las opcines disponibles");
		}
		
		if(contacto.getNotificaciones().length == 0) {
			errors.rejectValue("notificaciones", "contacto.notificaciones", "Debe seleccionar alguna de las opcines disponibles");
		}
		
		
	}

}
