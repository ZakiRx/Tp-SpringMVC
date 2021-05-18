package zoz.gestionproduit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import zoz.gestionproduit.config.BeansConfig;
import zoz.gestionproduit.dao.jdbc.CategoryDaoJdbc;
import zoz.gestionproduit.dao.jdbc.ProduitDaoJdbc;
import zoz.gestionproduit.dao.jpa.CategoryDaoJpa;
import zoz.gestionproduit.dao.jpa.ProduitDaoJpa;
import zoz.gestionproduit.model.Category;
import zoz.gestionproduit.model.Produit;
import zoz.gestionproduit.service.CategoryServiceImp;
import zoz.gestionproduit.service.ProduitServiceImp;

public class GestionProduitSpringApplication {

	public static void main(String[] args) {
		ApplicationContext applicationContext=  SpringApplication.run(BeansConfig.class,args);
		
		ProduitServiceImp produitService = applicationContext.getBean("produitService",ProduitServiceImp.class);
		
		produitService.addProduit(new Produit(null,"produit1","desc1",15223.0));
		produitService.addProduit(new Produit(null,"produit2","desc2",15223.0));
		produitService.addProduit(new Produit(null,"produit3","desc3",15223.0));
		
		produitService.getProduits().forEach(p->System.out.println(p.toString()));
		
		//delete product
		produitService.deleteProduit(2L);
		System.out.println("*******after delete***********");
		produitService.getProduits().forEach(p->System.out.println(p.toString()));

		if(produitService.getProduitRepository() instanceof ProduitDaoJdbc) {
			System.out.println("Manage Data By "+ProduitDaoJdbc.class.getName());
		}else {
			System.out.println("Manage Data By "+ProduitDaoJpa.class.getName());
		}
		
		System.out.println("*******Category Service***********");
		
		CategoryServiceImp categoryService = applicationContext.getBean("categoryService",CategoryServiceImp.class);
		
		categoryService.addCategory(new Category(null,"category1"));
		categoryService.addCategory(new Category(null,"category2"));
		categoryService.addCategory(new Category(null,"category3"));
		categoryService.getCategories().forEach(c->System.out.println(c.getId()+"---"+c.getName()));
		if(categoryService.getCategoryRepository() instanceof CategoryDaoJpa) {
			System.out.println("Manage Data By "+CategoryDaoJpa.class.getName());
		}else {
			System.out.println("Manage Data By "+CategoryDaoJdbc.class.getName());
		}
	}

}
