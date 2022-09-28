package curso.spring.mvc.serviceImpl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import curso.spring.mvc.dao.IPeliculaDao;
import curso.spring.mvc.model.Pelicula;
import curso.spring.mvc.service.IPeliculasService;

@Service
public class PeliculasServiceImpl implements IPeliculasService {

	@Autowired
	private IPeliculaDao peliculaDao;

	public PeliculasServiceImpl() {

	}

	@Override
	@Transactional(readOnly = true)
	public List<Pelicula> buscarTodas() {
		return peliculaDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Pelicula buscarPorId(int id) {
		return peliculaDao.buscarPorId(id);
	}

	@Override
	@Transactional
	public void insertar(Pelicula pelicula) {
		peliculaDao.save(pelicula);
	}

	@Override
	public void borrarPelicula(Pelicula pelicula) {
		peliculaDao.delete(pelicula);
	}

	@Override
	public Page<Pelicula> buscarTodas(Pageable page) {
		return peliculaDao.findAll(page);
	}

	
}
