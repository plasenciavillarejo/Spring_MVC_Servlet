package curso.spring.mvc.controller;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import curso.spring.mvc.model.Banner;
import curso.spring.mvc.service.IBannerService;
import curso.spring.mvc.util.Utileria;
import curso.spring.mvc.validator.BannerValidator;
import curso.spring.mvc.validator.PeliculasValidator;

@Controller
@RequestMapping(value = "/banners")
public class BannerController {

	private static final String MOSTRARBANNERS = "/banners/listBanners";
	private static final String CREACIONBANNER = "/banners/formBanner";
	private static final String REEDIRECCIONBANNERS = "/banners/index";
	private static final String VOLVERATRAS = "/banners/index";
	
	public static final Logger LOGGER = LoggerFactory.getLogger(NoticiasController.class);

	@Autowired
	private IBannerService bannerService;

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.setValidator(new BannerValidator());
	}

	@GetMapping(value = "/index")
	public String mostrarBanners(Model model) {
		List<Banner> listarBanners = bannerService.mostrarCarrousel();

		model.addAttribute("listaBanners", listarBanners);

		return MOSTRARBANNERS;
	}

	@GetMapping(value = "/create")
	public String crearBanner(@ModelAttribute Banner banner, Model model) {

		model.addAttribute("listaEstatus", bannerService.estatus());
		return CREACIONBANNER;
	}

	@PostMapping(value = "/save")
	public String save(@Validated @ModelAttribute("banner") Banner banner, BindingResult result,
			RedirectAttributes flashAttributes, @RequestParam(value = "archivoImagen") MultipartFile file,
			HttpServletRequest request, Model model) {

		if (result.hasErrors()) {
			LOGGER.info("El formulario contiene errores");
			model.addAttribute("listaEstatus", bannerService.estatus());
			return CREACIONBANNER;
		}

		try {

			if (!file.isEmpty()) {
				String nombreArchivo = Utileria.guardarImagen(request, file);
				banner.setArchivo(nombreArchivo);
			}

			bannerService.insertar(banner);

			flashAttributes.addFlashAttribute("mensajeConfirmacion", "El Banner se ha almacenado correctamente");

		} catch (Exception e) {
			LOGGER.info(
					"No se ha podido almacenar correctamente el banner debido al siguiente error: " + e.getMessage());
		}

		return "redirect:" + REEDIRECCIONBANNERS;
	}

	@GetMapping(value = "/volver")
	public String volverAtras() {
		return VOLVERATRAS;
	}
	
}
