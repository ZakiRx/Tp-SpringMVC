package zoz.gestionproduit.rowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import zoz.gestionproduit.model.Category;

public class CategoryRowMapper implements RowMapper<Category> {

	@Override
	public Category mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		return new Category(rs.getLong(1),rs.getString(2));
	}

}
