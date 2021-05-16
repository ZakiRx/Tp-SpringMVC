package zoz.gestionproduit.resultSetExtrator;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import zoz.gestionproduit.model.Produit;

public class ProduitResultSetExtrator implements ResultSetExtractor<List<Produit>> {

	@Override
	public List<Produit> extractData(ResultSet rs) throws SQLException, DataAccessException {
		List<Produit> produits = new ArrayList<Produit>();
		while (rs.next()) {
			Produit produit = new Produit(rs.getLong(1),rs.getString(2),rs.getString(3),rs.getDouble(4));
			produits.add(produit);
			
		}
		System.out.println("Execute One Time");
		return produits;
	}

}
