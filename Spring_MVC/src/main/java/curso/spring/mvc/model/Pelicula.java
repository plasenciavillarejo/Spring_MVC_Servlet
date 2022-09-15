package curso.spring.mvc.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Pelicula {

	public int id;
	public String titulo;
	public int duracion;
	public String clasificacion;
	public String genero;
	public String imagen = "cinema.png"; // Imágen por defecto.
	
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date fechaEstreno;
	private String estatus="Activa";
	
	
	public Pelicula() {
		
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
	public int getDuracion() {
		return duracion;
	}
	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}
	public String getClasificacion() {
		return clasificacion;
	}
	public void setClasificacion(String clasificacion) {
		this.clasificacion = clasificacion;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public String getImagen() {
		return imagen;
	}
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	public Date getFechaEstreno() {
		return fechaEstreno;
	}
	public void setFechaEstreno(Date fechaEstreno) {
		this.fechaEstreno = fechaEstreno;
	}
	public String getEstatus() {
		return estatus;
	}
	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}

	
	 
}
