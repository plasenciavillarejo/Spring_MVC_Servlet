package curso.spring.mvc.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import curso.spring.mvc.dao.IUsuarioDao;
import curso.spring.mvc.model.Perfil;
import curso.spring.mvc.model.Usuario;
import curso.spring.mvc.service.IPerfilService;
import curso.spring.mvc.service.IUsuarioService;
import curso.spring.mvc.util.Utileria;

@Controller
@RequestMapping(value = "/usuarios")
public class UsuariosContoller {

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	private IPerfilService perfilService;
	
	@Autowired
	private IUsuarioService usuarioService;
	
	private static final String PAGINAUSUARIOSDEMO = "/usuarios/demo";
	private static final String PAGINACREARUSUARIO = "/usuarios/formUsuario";
		
	private static final String REDIRECCIONARFORMULARIO = "/usuarios/crear";
	
	public static final Logger LOGGER = LoggerFactory.getLogger(UsuariosContoller.class);
	
	@GetMapping(value = "/crear")
	public String crearUsuario(@ModelAttribute("usuario") Usuario usuario, Model model ) {
		
		Map<String, String> listarPerfiles = Utileria.listarPerfiles();
		
		model.addAttribute("perfiles", listarPerfiles);
		
		
		return PAGINACREARUSUARIO; 
	}
	
	@PostMapping(value = "/guardarUsuario")
	public String guardarUsuario(@Validated @ModelAttribute("usuario") Usuario usuario,@RequestParam("perfil") String perfil,
			@RequestParam("check") String check,RedirectAttributes flashAttributes, Perfil perfiles, BindingResult result) {
		
		if(result.hasErrors()) {
			LOGGER.info("Contiene errores");
		}
		
		
		if(Utileria.comprobarUsuarioActivo(check)) {
			usuario.setActivo(1);
		}
		
		String encriptarPassword = passwordEncoder.encode(usuario.getPwd());
		
		usuario.setPwd(encriptarPassword);
		perfiles.setCuenta(usuario.getCuenta());
		perfiles.setPerfil(perfil);
		
		usuarioService.guardar(usuario);
		perfilService.guardar(perfiles);
		
		return "redirect:" + REDIRECCIONARFORMULARIO;
	}
	
	
	@GetMapping(value = "/demo-bcrypt")
	private String pruebaEncriptacion(Model model) {
		String password = "luis123";
		String password2 = "mari123";
		
		String encriptado = passwordEncoder.encode(password);
		String encriptado2 = passwordEncoder.encode(password2);
		
		model.addAttribute("passwordSinEncriptar", password);
		model.addAttribute("passwordEncriptada", encriptado);
		
		LOGGER.info("PASSWORD SIN ENCRIPTAR: " + password);
		LOGGER.info("PASSWORD ENCRIPTADA: " + encriptado);
		
		LOGGER.info("PASSWORD SIN ENCRIPTAR: " + password2);
		LOGGER.info("PASSWORD ENCRIPTADA: " + encriptado2);
		
		
		return PAGINAUSUARIOSDEMO;
	}

}
