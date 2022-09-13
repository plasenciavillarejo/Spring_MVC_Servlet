package curso.spring.mvc.model;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Banner implements Serializable{


	private int id;
	private String titulo;
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date fecha;
	private String archivo;
	private String estatus;
	
	public Banner() {
		this.fecha = new Date(); // Por defalut, la fecha del sistema
		this.estatus = "Activo"; // Por defecto vendrá siempre activo 
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getArchivo() {
		return archivo;
	}

	public void setArchivo(String archivo) {
		this.archivo = archivo;
	}

	public String getEstatus() {
		return estatus;
	}

	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}

	private static final long serialVersionUID = 1L;

	@Override
	public String toString() {
		return "Banner [id=" + id + ", titulo=" + titulo + ", fecha=" + fecha + ", archivo=" + archivo + ", estatus="
				+ estatus + "]";
	}

	
	
}
