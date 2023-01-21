package curso.spring.mvc.serviceImpl;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import curso.spring.mvc.dao.IPeliculaDao;
import curso.spring.mvc.model.Pelicula;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Service
public class ImprimirServiceImpl {

	@Autowired
	private IPeliculaDao peliculaDao;
	
	public String exportReport(String reporFormat) throws FileNotFoundException, JRException {
		List<Pelicula> listarPeliculas = peliculaDao.findAll();
		
		// Cargamos el fichero
		File file = ResourceUtils.getFile("classpath:/xslt/listPeliculas.jrxml");
		
		JasperReport report = JasperCompileManager.compileReport(file.getAbsolutePath());
		JRBeanCollectionDataSource peli = new JRBeanCollectionDataSource(listarPeliculas);
		
		JasperPrint print = JasperFillManager.fillReport(report, parameters(), peli);
		
		if (reporFormat.equalsIgnoreCase("pdf")) {
			JasperExportManager.exportReportToPdf(print);
		}
		if (reporFormat.equalsIgnoreCase("html")) {
			JasperExportManager.exportReportToHtmlFile(print,"/Users/joseplasenciavillarejo/Desktop/list.html");
		}
		
		return "";
	}
	
	
	private Map<String, Object> parameters(){
		Map<String, Object> parametros = new HashMap<>();
		parametros.put("created by ", "plasencia");
		return parametros;
	}
	
}
