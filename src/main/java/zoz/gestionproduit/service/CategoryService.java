package zoz.gestionproduit.service;

import java.util.List;

import zoz.gestionproduit.model.Category;

public interface CategoryService {
	public Category addCategory(Category category);

	public Category editCategory(Category category);

	public Category getCategory(Long id);

	public List<Category> getCategories();

	public boolean deleteCategory(Long id) ;
}
