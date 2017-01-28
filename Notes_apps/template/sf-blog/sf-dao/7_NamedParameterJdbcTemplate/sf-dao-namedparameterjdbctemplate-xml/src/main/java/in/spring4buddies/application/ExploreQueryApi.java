package in.spring4buddies.application;

import in.spring4buddies.application.dao.CustomerDao;
import in.spring4buddies.application.model.Customer;

import java.util.List;
import java.util.Map;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ExploreQueryApi {

	public static void main(String[] args) throws Exception {
		String confFile = "beans.xml";
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(confFile);

		CustomerDao customerDao = (CustomerDao) context.getBean("customerDao");

		System.out.println(" *****  Select customer using queryForObject(): BeanPropertyRowMapper ******");
		Customer cust = customerDao.findCustomerById_queryForObject(1);
		System.out.println(cust.getCust_Id() + " | " + cust.getName() + " | " + cust.getSalary() + " | " + cust.getDept());

		System.out.println(" *****  Select customer using query(): BeanPropertyRowMapper ******");
		List<Customer> customers = customerDao.findAll_query_BeanPropertyRowMapper();
		for (Customer customer : customers) {
			System.out.println(customer.getCust_Id() + " | " + customer.getName() + " | " + customer.getSalary() + " | " + customer.getDept());
		}

		System.out.println(" *****  Select customer using queryForList() : MapSqlParameterSource******");
		List<Map<String, Object>> list = customerDao.findCustomerByDept_queryForList("DBA");
		for (Map<String, Object> row : list) {
			System.out.println(row.get("cust_id") + " | " + row.get("name") + " | " + row.get("salary") + " | " + row.get("dept"));
		}

		System.out.println(" *****  Select customer using queryForMap() ******");
		Map<String, Object> map = customerDao.findCustomerByName_queryForMap("Frederick");
		for (Map.Entry<String, Object> entry : map.entrySet()) {
			System.out.println(entry.getKey() + " | " + entry.getValue());
		}

		context.close();
	}
}
