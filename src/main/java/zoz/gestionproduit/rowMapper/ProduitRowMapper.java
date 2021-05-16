package zoz.gestionproduit.rowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import zoz.gestionproduit.model.Produit;

public class ProduitRowMapper implements RowMapper<Produit> {

	@Override
	public Produit mapRow(ResultSet rs, int rowNum) throws SQLException {

		Produit produit = new Produit(rs.getLong(1),rs.getString(2),rs.getString(3),rs.getDouble(4));
		
		System.out.println(rowNum+" mapRow func execute");
		return produit;
	}

}
