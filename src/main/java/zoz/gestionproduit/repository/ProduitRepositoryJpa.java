package zoz.gestionproduit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import zoz.gestionproduit.model.Produit;


public interface ProduitRepositoryJpa extends JpaRepository<Produit, Long> {

	@Query("select p from Produit p where p.name=:name")
	Produit getOneByName(@Param("name") String name);
}
