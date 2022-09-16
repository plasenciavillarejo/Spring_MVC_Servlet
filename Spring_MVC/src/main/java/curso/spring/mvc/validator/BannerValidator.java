package curso.spring.mvc.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import curso.spring.mvc.model.Banner;

public class BannerValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Banner.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {

		Banner banner = (Banner) target;

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "titulo", "banner.titulo", "El titulo no puede estár vacío.");

		if (banner.getEstatus().equalsIgnoreCase("1")) {
			errors.rejectValue("estatus", "banner.estatus", "Debes seleccionar un estado");
		}

	}

}
