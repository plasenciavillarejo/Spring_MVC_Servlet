package curso.spring.mvc.model;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.Pattern;

import org.springframework.format.annotation.DateTimeFormat;

public class Horario implements Serializable {

	private int id;
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date fecha;
	private String hora;
	private String sala;
	private double precio;
	private Pelicula pelicula;
	private String reloj;

	public Horario() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public String getsala() {
		return sala;
	}

	public void setsala(String sala) {
		this.sala = sala;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public Pelicula getPelicula() {
		return pelicula;
	}

	public void setPelicula(Pelicula pelicula) {
		this.pelicula = pelicula;
	}
	
	public String getReloj() {
		return reloj;
	}

	public void setReloj(String reloj) {
		this.reloj = reloj;
	}

	private static final long serialVersionUID = 1L;

}
