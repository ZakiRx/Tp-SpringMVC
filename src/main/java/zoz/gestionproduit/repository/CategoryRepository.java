package zoz.gestionproduit.repository;

import java.util.List;

import zoz.gestionproduit.model.Category;



public interface CategoryRepository {
	Category save(Category category);
	Category edit(Category category);
	Category getOne(Long id);
	List<Category> getAll();
	boolean delete(Long id);
}
