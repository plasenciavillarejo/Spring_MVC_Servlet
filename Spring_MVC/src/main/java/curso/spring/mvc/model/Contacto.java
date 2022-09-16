package curso.spring.mvc.model;

import java.io.Serializable;

public class Contacto implements Serializable {

	private int id;
	private String nombre;
	private String email;
	private int rating;
	private String[] generos;
	private String[] notificaciones;
	private String comentarios;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String[] getGeneros() {
		return generos;
	}

	public void setGeneros(String[] generos) {
		this.generos = generos;
	}

	public String[] getNotificaciones() {
		return notificaciones;
	}

	public void setNotificaciones(String[] notificaciones) {
		this.notificaciones = notificaciones;
	}

	public String getComentarios() {
		return comentarios;
	}

	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	private static final long serialVersionUID = 1L;

}
