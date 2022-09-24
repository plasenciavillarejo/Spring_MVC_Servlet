package curso.spring.mvc.service;

import curso.spring.mvc.model.Detalle;

public interface IDetalleService {

	public void insertarDetalle(Detalle detalle);
	
	public Detalle buscarPorId(int id);
	
	public void borrarDetalle(Detalle detalle);
}
