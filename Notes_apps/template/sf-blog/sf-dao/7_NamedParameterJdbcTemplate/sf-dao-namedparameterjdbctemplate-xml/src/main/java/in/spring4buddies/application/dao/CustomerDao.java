package in.spring4buddies.application.dao;

import in.spring4buddies.application.model.Customer;

import java.util.List;
import java.util.Map;

public interface CustomerDao {

	Customer findCustomerById_queryForObject(int custId);

	List<Customer> findAll_query_BeanPropertyRowMapper();

	List<Map<String, Object>> findCustomerByDept_queryForList(String dept);

	Map<String, Object> findCustomerByName_queryForMap(String name);

	List<Customer> findCustomerByDept_query_ResultSetExtractor(String dept);

}
