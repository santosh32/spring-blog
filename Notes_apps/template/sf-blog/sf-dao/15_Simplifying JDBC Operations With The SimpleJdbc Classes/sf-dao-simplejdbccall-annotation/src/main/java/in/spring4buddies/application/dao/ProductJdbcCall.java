package in.spring4buddies.application.dao;

import in.spring4buddies.application.dao.helper.ProductRowMapper;
import in.spring4buddies.application.model.Product;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

public class ProductJdbcCall {
	private JdbcTemplate jdbcTemplate;
	private SimpleJdbcCall jdbcCall;

	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
		this.jdbcCall = new SimpleJdbcCall(dataSource).withProcedureName("insert_product_procedure");
	}

	public List<Product> getAllProducts() {
		String sql = "select * from products";
		List<Product> products = jdbcTemplate.query(sql, new ProductRowMapper());
		return products;
	}

	public void callProcedure(int id, String name, String brand, int price) {
		Map<String, Object> inputMap = new HashMap<String, Object>();
		inputMap.put("product_id", id);
		inputMap.put("product_name", name);
		inputMap.put("price", price);
		inputMap.put("brand", brand);
		jdbcCall.execute(inputMap);
	}

}