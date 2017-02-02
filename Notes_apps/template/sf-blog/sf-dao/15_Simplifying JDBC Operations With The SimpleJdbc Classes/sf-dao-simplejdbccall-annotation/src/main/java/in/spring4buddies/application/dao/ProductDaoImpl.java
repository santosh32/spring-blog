package in.spring4buddies.application.dao;

import in.spring4buddies.application.dao.helper.ProductRowMapper;
import in.spring4buddies.application.model.Product;

import java.sql.Types;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.MapUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.SqlInOutParameter;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

public class ProductDaoImpl implements ProductDao {

	@Autowired
	private SimpleJdbcCall simpleJdbcCall;

	@Override
	public Product getProductById(int prod_id) {

		SqlParameterSource sqlParameterSource = new MapSqlParameterSource().addValue("prod_id", prod_id);

		Map<String, Object> out = simpleJdbcCall.withProcedureName("get_product_by_id")
				.declareParameters(new SqlInOutParameter("inout_prod_id", Types.INTEGER))
				.declareParameters(new SqlOutParameter("out_name", Types.VARCHAR))
				.declareParameters(new SqlOutParameter("out_brand", Types.VARCHAR))
				.declareParameters(new SqlOutParameter("out_price", Types.INTEGER))

				.returningResultSet("products", new ProductRowMapper())
				.execute(sqlParameterSource);

		Product product = null;
		if (MapUtils.isNotEmpty(out)) {
			product = new Product();
			product.setProductId(prod_id);
			product.setName((String) out.get("out_name"));
			product.setPrice((Integer) out.get("out_price"));
			product.setBrand((String) out.get("out_brand"));
		}
		return product;
	}

	@Override
	public List<Product> getAllProducts() {

		Map<String, Object> out = simpleJdbcCall.withProcedureName("get_product_by_id")
				.declareParameters(new SqlInOutParameter("inout_prod_id", Types.INTEGER))
				.declareParameters(new SqlOutParameter("out_name", Types.VARCHAR))
				.declareParameters(new SqlOutParameter("out_brand", Types.VARCHAR))
				.declareParameters(new SqlOutParameter("out_price", Types.INTEGER))

				.returningResultSet("products", new ProductRowMapper())
				.execute();

		Product product = null;
		if (MapUtils.isNotEmpty(out)) {
			product = new Product();
			product.setName((String) out.get("out_name"));
			product.setPrice((Integer) out.get("out_price"));
			product.setBrand((String) out.get("out_brand"));
		}
		return Collections.emptyList();
	}

	@Override
	public void insertProduct(Product product) {

		SqlParameterSource sqlParameterSource = new BeanPropertySqlParameterSource(product);

		simpleJdbcCall.withProcedureName("insert_product")
			.declareParameters(new SqlParameter("inprod_id", Types.INTEGER))
			.declareParameters(new SqlParameter("in_name", Types.VARCHAR))
			.declareParameters(new SqlParameter("in_brand", Types.VARCHAR))
			.declareParameters(new SqlParameter("in_price", Types.INTEGER))
			
			.execute(sqlParameterSource);

	}
}