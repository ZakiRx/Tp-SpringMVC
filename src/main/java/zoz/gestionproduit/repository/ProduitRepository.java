package zoz.gestionproduit.repository;

import java.util.List;

import zoz.gestionproduit.model.Produit;

public interface ProduitRepository {
	Produit save(Produit produit);
	Produit edit(Produit produit);
	Produit getOne(Long id);
	Produit getOneByName(String name);
	List<Produit> getAll();
	boolean delete(Long id);
}
