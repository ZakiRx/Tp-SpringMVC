package zoz.gestionproduit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import zoz.gestionproduit.model.Category;
import zoz.gestionproduit.model.Produit;
import zoz.gestionproduit.service.CategoryService;
import zoz.gestionproduit.service.ProduitService;

@Controller
@RequestMapping("/produit")
public class ProduitController {

	@Autowired
	private ProduitService produitService;
	@Autowired
	private CategoryService categoryService;
	
	@RequestMapping(value = "/",method = RequestMethod.GET)

	public ModelAndView getProduits() {
		ModelAndView modelAndView =  new ModelAndView("index");
		List<Produit>  produits = produitService.getProduits();
		modelAndView.addObject("produits",produits);
		
		return modelAndView;
	}
	@RequestMapping(value = "/{id}",method = RequestMethod.GET)
	public ModelAndView getProduit(@PathVariable Long id) {
		ModelAndView modelAndView =  new ModelAndView();
		modelAndView.setViewName("show");
		Produit  produit = produitService.getProduit(id);
		List<Category> categories = categoryService.getCategories();
		modelAndView.addObject("categories",categories);
		modelAndView.addObject("produit",produit);
		return modelAndView;
	}
	@RequestMapping(value = "/new",method = RequestMethod.GET)
	public ModelAndView newProduit() {
		ModelAndView modelAndView = new ModelAndView();
		Produit produit = new Produit();
		List<Category> categories = categoryService.getCategories();
		modelAndView.setViewName("new");
		modelAndView.addObject("produit",produit);
		modelAndView.addObject("categories",categories);
		return modelAndView;
	}
	
	@RequestMapping(value = "/save",method = RequestMethod.POST)
	public RedirectView saveProduit(@ModelAttribute("produit") Produit produit) {
		produitService.addProduit(produit);
		return new RedirectView("/produit/");
		
	}
	@RequestMapping(value = "/edit",method = RequestMethod.POST )
	public RedirectView editProduit(@ModelAttribute Produit produit) {
		System.out.println(produit.getName());
		produitService.editProduit(produit);
		return new RedirectView("/produit/");
	}
	
	@RequestMapping(value = "/delete/{id}",method = RequestMethod.POST)
	public RedirectView deleteProduit(@PathVariable Long id) {
		produitService.deleteProduit(id);
		return new RedirectView("/produit/");
	}
}
