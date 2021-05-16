package zoz.gestionproduit.dao.jpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import zoz.gestionproduit.model.Category;
import zoz.gestionproduit.repository.CategoryRepository;
import zoz.gestionproduit.repository.CategoryRepositoryJpa;

@Repository("categoryJpa")
public class CategoryDaoJpa implements CategoryRepository {
	
	@Autowired
	private CategoryRepositoryJpa categoryRepositoryJpa;
	
	@Override
	public Category save(Category category) {
		
		return categoryRepositoryJpa.save(category);
	}

	@Override
	public Category getOne(Long id) {
		
		return categoryRepositoryJpa.getOne(id);
	}

	@Override
	public List<Category> getAll() {

		return categoryRepositoryJpa.findAll();
	}

	@Override
	public boolean delete(Long id) {
		
		try {
			categoryRepositoryJpa.delete(getOne(id));
			return true;
		}catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	@Override
	public Category edit(Category category) {
	
		return categoryRepositoryJpa.save(category);
	}
	
}
