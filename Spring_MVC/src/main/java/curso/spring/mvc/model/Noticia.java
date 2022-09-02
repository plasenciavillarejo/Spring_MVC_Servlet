package curso.spring.mvc.model;

import java.io.Serializable;
import java.util.Date;

public class Noticia implements Serializable{


	private Long id;
	private String titulo;
	private Date fecha;
	private String detalle;
	private String estatus;

	public Noticia() {
		this.fecha = new Date();
		this.estatus = "Activa";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public String getDetalle() {
		return detalle;
	}

	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}

	public String getEstatus() {
		return estatus;
	}

	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}

	
	private static final long serialVersionUID = 1L;
	
}
