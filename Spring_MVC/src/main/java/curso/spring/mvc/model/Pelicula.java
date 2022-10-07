package curso.spring.mvc.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "Peliculas")
public class Pelicula implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int id;

	public String titulo;

	@Pattern(regexp = "[0-9]{3}", message = "Solo se permiten 3 números")
	public int duracion;

	public String clasificacion;

	public String genero;

	public String imagen = "cinema.png"; // Imágen por defecto.

	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date fechaEstreno;

	private String estatus = "Activa";

	@OneToOne
	@JoinColumn(name="idDetalle") // Corresponde a la llave foranea indicanda en la tabla Detalles en MySql.
	private Detalle detalle;
	
	/* Le indicamos el atributo que se encuentra declarado en la Clase de Horarios -> Private Pelicula pelicula
	 	Le indicamos el método EAGER, para cada vez que consultemos un registro de tipo pelicula queremos se ejecute una consulta en la tabla horarios
			para que se traiga todos los horarios que pertenezca a esa pelicula. */
	@OneToMany(mappedBy = "pelicula", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<Horario> horario;
	
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

	public Detalle getDetalle() {
		return detalle;
	}

	public void setDetalle(Detalle detalle) {
		this.detalle = detalle;
	}

	public List<Horario> getHorario() {
		return horario;
	}

	public void setHorario(List<Horario> horario) {
		this.horario = horario;
	}

	
	private static final long serialVersionUID = 1L;

}
