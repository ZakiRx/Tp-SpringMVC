package zoz.gestionproduit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import zoz.gestionproduit.model.Produit;
import zoz.gestionproduit.repository.ProduitRepository;

@Service("produitService")
public class ProduitServiceImp implements ProduitService {

	@Autowired
	@Qualifier("produitJdbc")
	private ProduitRepository produitRepository;
	
	
	public ProduitRepository getProduitRepository() {
		return produitRepository;
	}
	public Produit addProduit(Produit produit) {
		
		return produitRepository.save(produit);
	}
	public Produit editProduit(Produit produit) {
		return produitRepository.edit(produit);
	}
	
	public Produit  getProduit(Long id) {
		return produitRepository.getOne(id);
	}
	
	public  List<Produit> getProduits(){
		return  produitRepository.getAll();

	}
	
	public boolean deleteProduit(Long id) {
		return produitRepository.delete(id);
	}
	
}
