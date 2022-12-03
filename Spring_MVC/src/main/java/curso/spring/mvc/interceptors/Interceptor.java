package curso.spring.mvc.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class Interceptor implements HandlerInterceptor {

	public static final Logger LOGGER = LoggerFactory.getLogger(Interceptor.class);
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("");
		System.out.println("");
		LOGGER.info("Se encarga de validar antes de ejecutar el controlador alguna acción, devuelve un true si es correcto"
				+ "y por tanto se ejecuta el controlador que se esté interceptando, si devuelve false, se enviará a una "
				+ "página de error configurada para el caso.");
		
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		LOGGER.info("Si todo ha ido bien en la ejecución de el controlador antes de devolver los datos a la vista se "
				+ "ejecuta este postHandle. Es un void por lo que nunca devolverá nada.");
		
		
		//HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
	}

	/*
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
	}
	 */
	
	
}
