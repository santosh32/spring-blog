package in.spring4buddies.application.dao;

import in.spring4buddies.application.dao.helper.ProductRowMapper;

import java.sql.Types;

import oracle.jdbc.OracleTypes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.SqlInOutParameter;
import org.springframework.jdbc.core.SqlOutParameter;
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

		Double price = simpleJdbcCall.withFunctionName("get_product_by_id")
				.declareParameters(new SqlInOutParameter("in_prod_id", Types.INTEGER))
				.declareParameters(new SqlOutParameter("out_recordset", OracleTypes.CURSOR, new ProductRowMapper()))
			.executeFunction(Double.class, sqlParameterSource);

		return price;
	}
}