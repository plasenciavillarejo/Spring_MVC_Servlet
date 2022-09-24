package curso.spring.mvc.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import curso.spring.mvc.dao.IDetalleDao;
import curso.spring.mvc.model.Detalle;
import curso.spring.mvc.service.IDetalleService;

@Service
public class DetalleServiceImpl implements IDetalleService{

	@Autowired
	private IDetalleDao detalleDao;
	
	@Override
	public void insertarDetalle(Detalle detalle) {
		detalleDao.save(detalle);
	}

	@Override
	public Detalle buscarPorId(int id) {
		return detalleDao.buscarPorId(id);
	}

	@Override
	public void borrarDetalle(Detalle detalle) {
		detalleDao.delete(detalle);
	}

}
