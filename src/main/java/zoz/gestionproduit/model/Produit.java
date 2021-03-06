package zoz.gestionproduit.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Produit {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(unique = true)
	private String name;
	private String description;
	private Double price;
	@ManyToMany
	private List<Category> categories;
	
	public Produit() {
		
	}
	
	public Produit(Long id, String name, String description, Double price) {
	
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Id:"+this.id+" Name:"+this.name+" Price:"+this.price+" Description:"+this.description;
	}
	
	
	
	
	
}
