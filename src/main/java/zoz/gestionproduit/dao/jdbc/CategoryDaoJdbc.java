package zoz.gestionproduit.dao.jdbc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import zoz.gestionproduit.model.Category;
import zoz.gestionproduit.repository.CategoryRepository;
import zoz.gestionproduit.resultSetExtrator.CategoryResultSetExtrator;
import zoz.gestionproduit.rowMapper.CategoryRowMapper;

@Repository("categoryJdbc")
public class CategoryDaoJdbc  implements CategoryRepository{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	private String sql;
	@Override
	public Category save(Category category) {
		this.sql="insert into category values(null,?)";
		Object[] args= {category.getName()};
		int row=jdbcTemplate.update(sql, args);
		System.out.println(row+"category Added !!");
		return category;
	}

	@Override
	public Category getOne(Long id) {
		this.sql="select * from  category c  where c.id=?";
		Category produit=(Category) jdbcTemplate.queryForObject(sql,new CategoryRowMapper(),id);
		return produit;
	}

	@Override
	public List<Category> getAll() {
		this.sql="select * from category";
		List<Category> produits = jdbcTemplate.query(sql,new CategoryResultSetExtrator());
		return produits;
	}

	@Override
	public boolean delete(Long id) {
		this.sql="delete from category where id=?";
		int row =jdbcTemplate.update(sql,id);
		if(row>0) {
			System.out.println(row+" category Deleted");
			return true;
		}
		return false;
	}

	@Override
	public Category edit(Category category) {
		this.sql="update category c set c.name=?  where c.id=? ";
		Object[] args= {category.getName(),category.getId()};
		int row=jdbcTemplate.update(sql,args);
		System.out.println(row+" Category updated");
		return category;
	}


}
