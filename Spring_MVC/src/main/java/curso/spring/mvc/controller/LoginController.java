package curso.spring.mvc.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/admin")
public class LoginController {

	public static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class); 
	
	public static final String REDIRECCIONLOGIN = "/login";
	public static final String REDIRECCIONPAGINAINICIAL ="/admin/index";	
	
	
	// Cuando nos logueamos inicialmente vamos a proceder a redirigir al usuario a una página inicial indicado por nosotros.
	@GetMapping(value = "/mensajeBienvenida")
	public String mostrarPaginaPrincipal(Authentication authentication) {
		
		// Para recuperar un usuario desde el controlador debemos hacerlo dessde la interfaz que nos proporciona Spring Security "Authentication".
		// Se puede llevar un log de registro para ver que usuario a entrado en la aplicación con la fecha y hora para almacenarlo en una tabla dentro de una BBDD.
		System.out.println("");
		LOGGER.info("Se procede ha acceder con el siguiente usuario: " + authentication.getName());
		
		// Recuperar los roles que contiene el usuario que inicia la sesión debemos utilizar GrantedAuthority
		List<String> listaRoles = new ArrayList<>();
		for(GrantedAuthority roles: authentication.getAuthorities()) {
			listaRoles.add(roles.getAuthority());
		}
		LOGGER.info("Los roles que tiene asigando el usuario son los siguientes: " + listaRoles);
		System.out.println("");
		
		return REDIRECCIONPAGINAINICIAL;
	}
	
	@GetMapping(value = "/logout")
	public String logout(HttpServletRequest request, Authentication authentication) {
		
		LOGGER.info("Procedemos a realizar el logout de la sesión.");
		/* 1.- Método proporcionado por Spring-Security. */
		SecurityContextLogoutHandler logoutHandler = new SecurityContextLogoutHandler();
		
		/* 2.- Para realizar el logout, apoyandonos en la documentación de spring podemos observar que al hacer el logout se l pasa 3 parámetros:
		 	Request, Response y el Authentication -> El valor importantes es el request que es el que obtiene la sesión del usuario, por lo que los dos
		 	atributos restantes basta con dejarlo a null.
		 */
		try {
		logoutHandler.logout(request, null, null);
		// Se puede llevar un registro de cuantas hora ha estado activo el usuario mediante el login y el logout.
		System.out.println("");
		LOGGER.info(" Se procede a salir de la sesión activa para el usuario: " + authentication.getName());
		System.out.println("");
		
		}catch (Exception e) {
			LOGGER.error("Se ha producido un error a la hora de salir de la sesisión: " + e + " " + e.getMessage());
		}
		return "redirect:" + REDIRECCIONLOGIN;
	}
	
}
