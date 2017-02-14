package in.spring4buddies.application.dao;

import java.sql.Types;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.SqlInOutParameter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

public class ProductDaoImpl implements ProductDao {

	@Autowired
	private SimpleJdbcCall simpleJdbcCall;

	public void setSimpleJdbcCall(SimpleJdbcCall simpleJdbcCall) {
		this.simpleJdbcCall = simpleJdbcCall;
	}

	@Override
	public Double getPriceById(int prod_id) {

		SqlParameterSource sqlParameterSource = new MapSqlParameterSource()
			.addValue("in_prod_id", prod_id, Types.INTEGER);

		Double price = simpleJdbcCall.withFunctionName("get_price_by_id")
				.declareParameters(new SqlInOutParameter("price", Types.INTEGER))
			.executeFunction(Double.class, sqlParameterSource);

		return price;
	}
}