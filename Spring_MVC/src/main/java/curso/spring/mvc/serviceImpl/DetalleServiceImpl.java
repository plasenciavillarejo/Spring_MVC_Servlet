package curso.spring.mvc.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;

import curso.spring.mvc.dao.IDetalleDao;
import curso.spring.mvc.model.Detalle;
import curso.spring.mvc.service.IDetalleService;

public class DetalleServiceImpl implements IDetalleService{

	@Autowired
	private IDetalleDao detalleDao;
	
	@Override
	public void insertarDetalle(Detalle detalle) {
		detalleDao.save(detalle);
	}

}
