package zoz.gestionproduit.dao.jpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import zoz.gestionproduit.model.Produit;
import zoz.gestionproduit.repository.ProduitRepository;
import zoz.gestionproduit.repository.ProduitRepositoryJpa;

@Repository("produitJpa")
public class ProduitDaoJpa implements ProduitRepository {
	@Autowired
	private ProduitRepositoryJpa produitRepositoryJpa;
	@Override
	public Produit save(Produit produit) {
		
		return produitRepositoryJpa.save(produit);
	}

	@Override
	public Produit edit(Produit produit) {
		
		return produitRepositoryJpa.save(produit);
	}

	@Override
	public Produit getOne(Long id) {
		
		return produitRepositoryJpa.getOne(id);
	}

	@Override
	public List<Produit> getAll() {
	
		return produitRepositoryJpa.findAll();
	}

	@Override
	public boolean delete(Long id) {
		Produit produit = getOne(id);
		try {
			produitRepositoryJpa.delete(produit);
			System.out.println("Produit has been deleted");
			return true;
		}catch (Exception e) {
			System.out.println("Produit Not  deleted caus :"+e.getMessage());
			return false;
		}
		 
	}

	@Override
	public Produit getOneByName(String name) {
		return produitRepositoryJpa.getOneByName(name);
	}

	
}
