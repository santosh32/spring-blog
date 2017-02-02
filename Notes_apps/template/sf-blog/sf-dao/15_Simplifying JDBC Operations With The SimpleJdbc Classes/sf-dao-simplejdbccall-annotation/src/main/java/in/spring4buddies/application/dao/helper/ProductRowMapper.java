package in.spring4buddies.application.dao.helper;

import in.spring4buddies.application.model.Product;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class ProductRowMapper implements RowMapper<Product> {
	
	public Product mapRow(ResultSet rs, int rowNum) throws SQLException {

		Product product = new Product();

		product.setProductId(rs.getInt("prod_id"));
		product.setName(rs.getString("name"));
		product.setBrand(rs.getString("brand"));
		product.setPrice(rs.getInt("price"));

		return product;
	}
}