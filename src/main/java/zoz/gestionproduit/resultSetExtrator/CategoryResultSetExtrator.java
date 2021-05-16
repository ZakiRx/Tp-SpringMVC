package zoz.gestionproduit.resultSetExtrator;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import zoz.gestionproduit.model.Category;

public class CategoryResultSetExtrator implements ResultSetExtractor<List<Category>> {

	@Override
	public List<Category> extractData(ResultSet rs) throws SQLException, DataAccessException {
		List<Category>categories = new ArrayList<Category>();
		while (rs.next()) {
			categories.add(new Category(rs.getLong(1),rs.getString(2)));
		}
		return categories;
	}

}
