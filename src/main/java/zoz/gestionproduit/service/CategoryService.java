package zoz.gestionproduit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import zoz.gestionproduit.model.Category;
import zoz.gestionproduit.repository.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	@Qualifier("categoryJdbc")
	private CategoryRepository categoryRepository;
	
	public CategoryRepository getCategoryRepository() {
		return categoryRepository;
	}

	public Category addCategory(Category category) {

		return categoryRepository.save(category);
	}

	public Category editCategory(Category category) {

		return categoryRepository.edit(category);
	}

	public Category getCategory(Long id) {
		return categoryRepository.getOne(id);
	}

	public List<Category> getCategories() {
		return categoryRepository.getAll();
	}

	public boolean deleteCategory(Long id) {
		return categoryRepository.delete(id);
	}
}
