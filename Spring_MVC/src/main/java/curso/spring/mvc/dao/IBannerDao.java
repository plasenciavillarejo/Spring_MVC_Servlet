package curso.spring.mvc.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import curso.spring.mvc.model.Banner;

@Repository
public interface IBannerDao extends CrudRepository<Banner, Integer>{

}
