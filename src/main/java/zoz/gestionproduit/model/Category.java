package zoz.gestionproduit.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
@Entity
public class Category {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(unique = true)
	private String name;
	@ManyToMany(mappedBy = "categories")
	private List<Produit>  produits;
	public Category() {
		
	}
	public Category(Long id, String name) {
		this(name);
		this.id = id;
	}
	public Category(String name) {
		this.name = name;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Produit> getProduits() {
		return produits;
	}
	public void setProduits(List<Produit> produits) {
		this.produits = produits;
	}
	
	
}
