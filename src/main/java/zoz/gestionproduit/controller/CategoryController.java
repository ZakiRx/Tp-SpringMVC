package zoz.gestionproduit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import zoz.gestionproduit.model.Category;
import zoz.gestionproduit.model.Produit;
import zoz.gestionproduit.service.CategoryServiceImp;
import zoz.gestionproduit.service.ProduitServiceImp;

@RestController
@RequestMapping("/api/category")
public class CategoryController {
	
	@Autowired
	private CategoryServiceImp categoryService;
	
	
	
	@RequestMapping(value = "/",method = RequestMethod.GET)
	@GetMapping
	public List<Category> getcategories() {
	
		return categoryService.getCategories();
	}
	@RequestMapping(value = "/{id}",method = RequestMethod.GET)
	@GetMapping
	public Category getCategorie(@PathVariable Long id) {
		return  categoryService.getCategory(id);
	}
	
	@RequestMapping(value = "/save",method = RequestMethod.POST)
	@PostMapping
	public Category saveCategorie(@RequestBody Category category) {
		
		return categoryService.addCategory(category);
		
	}
	@RequestMapping(value = "/edit",method = RequestMethod.PUT )
	@PutMapping
	public Category editCategorie(@RequestBody Category category) {
		return categoryService.editCategory(category);
	}
	
	@RequestMapping(value = "/delete/{id}",method = RequestMethod.DELETE)
	@DeleteMapping
	public boolean deleteProduit(@PathVariable Long id) {
		
		return  categoryService.deleteCategory(id);
	}
}
