package zoz.gestionproduit.service;

import java.util.List;

import zoz.gestionproduit.model.Produit;

public interface ProduitService {

	 Produit addProduit(Produit produit);
	public Produit editProduit(Produit produit);
	
	public Produit  getProduit(Long id);
	
	public  List<Produit> getProduits();
	
	public boolean deleteProduit(Long id);
}
