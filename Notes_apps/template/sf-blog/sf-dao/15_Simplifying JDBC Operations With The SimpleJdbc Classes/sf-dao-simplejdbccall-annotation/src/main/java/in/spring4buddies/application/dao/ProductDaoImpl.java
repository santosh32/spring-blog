package in.spring4buddies.application.dao;

import in.spring4buddies.application.dao.helper.ProductRowMapper;
import in.spring4buddies.application.model.Product;

import java.sql.Types;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import oracle.jdbc.OracleTypes;

import org.apache.commons.collections.MapUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.SqlInOutParameter;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

public class ProductDaoImpl implements ProductDao {

	@Autowired
	private SimpleJdbcCall simpleJdbcCallForGet;

	@Autowired
	private SimpleJdbcCall simpleJdbcCallForStore;

	public void setSimpleJdbcCallForGet(SimpleJdbcCall simpleJdbcCallForGet) {
		this.simpleJdbcCallForGet = simpleJdbcCallForGet;
	}

	public void setSimpleJdbcCallForStore(SimpleJdbcCall simpleJdbcCallForStore) {
		this.simpleJdbcCallForStore = simpleJdbcCallForStore;
	}

	@Override
	public List<Product> getProductById(int prod_id) {

		SqlParameterSource sqlParameterSource = new MapSqlParameterSource()
			.addValue("in_prod_id", prod_id, Types.INTEGER);

		Map<String, Object> simpleJdbcCallResult = simpleJdbcCallForGet.withProcedureName("get_product_by_id")
				.declareParameters(new SqlInOutParameter("in_prod_id", Types.INTEGER))
				.declareParameters(new SqlOutParameter("out_recordset", OracleTypes.CURSOR, new ProductRowMapper()))
			.execute(sqlParameterSource);

		List<Product> products = Collections.emptyList();
		if (MapUtils.isNotEmpty(simpleJdbcCallResult)) {
			products = (List<Product>) simpleJdbcCallResult.get("out_recordset");
		}

		return products;
	}

	@Override
	public List<Product> getAllProducts() {
		return Collections.emptyList();
	}

	@Override
	public void insertProduct(Product product) {

		// SqlParameterSource sqlParameterSource = new
		// BeanPropertySqlParameterSource(product);

		SqlParameterSource sqlParameterSource = new MapSqlParameterSource()
			.addValue("in_prod_id", product.getProductId(), Types.INTEGER)
			.addValue("in_name", product.getName(), Types.VARCHAR)
			.addValue("in_brand", product.getBrand(), Types.VARCHAR)
			.addValue("in_price", product.getPrice(), Types.INTEGER);

		simpleJdbcCallForStore.withProcedureName("insert_product")
			.declareParameters(new SqlParameter("in_prod_id", Types.INTEGER))
			.declareParameters(new SqlParameter("in_name", Types.VARCHAR))
			.declareParameters(new SqlParameter("in_brand", Types.VARCHAR))
			.declareParameters(new SqlParameter("in_price", Types.INTEGER))
		.execute(sqlParameterSource);

	}
}