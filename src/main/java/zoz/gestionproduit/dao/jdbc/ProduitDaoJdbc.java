package zoz.gestionproduit.dao.jdbc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import zoz.gestionproduit.model.Category;
import zoz.gestionproduit.model.Produit;
import zoz.gestionproduit.repository.ProduitRepository;
import zoz.gestionproduit.resultSetExtrator.ProduitResultSetExtrator;
import zoz.gestionproduit.rowMapper.ProduitRowMapper;

@Repository("produitJdbc")
public class ProduitDaoJdbc implements ProduitRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	private String sql;
	@Override
	public Produit save(Produit produit) {
		this.sql="insert into produit(name,description,price) values(?,?,?)";
		Object[] args= {produit.getName(),produit.getDescription(),produit.getPrice()};
		int row=jdbcTemplate.update(sql, args);
		System.out.println(row+"Produit Added !!");
		if(produit.getCategories() != null && produit.getCategories().size()!=0 ) {
			
			addCategoriesToProduct(produit);
			
		}
		return produit;
	}
	
	private void  addCategoriesToProduct(Produit produit) {
		Long idProduit =produit.getId(); // in insert idProduit == null 
		if(idProduit==null) {
			 idProduit = getOneByName(produit.getName()).getId();
		}
		for (Category category : produit.getCategories()) {
			this.sql="insert into produit_categories values(?,?)";
			Object[] args={idProduit,category.getId()};
			int row=jdbcTemplate.update(sql, args);
			 System.out.println(row+"produit_categories Added !!");
		}
	}

	@Override
	public Produit getOne(Long id) {
		this.sql="select * from  produit p  where p.id=?";
		Produit produit=(Produit) jdbcTemplate.queryForObject(sql,new ProduitRowMapper(),id);
		return produit;
	}

	@Override
	public List<Produit> getAll() {
		this.sql="select * from produit";
		List<Produit> produits = jdbcTemplate.query(sql,new ProduitResultSetExtrator());
		return produits;
	}

	@Override
	public boolean delete(Long id) {
		this.sql="delete from produit where id=?";
		int row =jdbcTemplate.update(sql,id);
		if(row>0) {
			System.out.println(row+" Product Deleted");
			return true;
		}
		return false;
	}

	@Override
	public Produit edit(Produit produit) {
		this.sql="update produit p set p.name=? ,p.description=?,p.price=? where p.id=? ";
		Object[] args= {produit.getName(),produit.getDescription(),produit.getPrice(),produit.getId()};
		int row=jdbcTemplate.update(sql,args);
		System.out.println(row+" Product updated");
		if(produit.getCategories() !=null) {
			this.sql="delete from produit_categories where produits_id=? ";
			 row=jdbcTemplate.update(sql, produit.getId());
			addCategoriesToProduct(produit);
		}

		return produit;
	}

	@Override
	public Produit getOneByName(String name) {
		this.sql="select * from  produit p  where p.name like ?";
		Produit produit=jdbcTemplate.queryForObject(sql,new ProduitRowMapper(),name);
		return produit;
	}



}
