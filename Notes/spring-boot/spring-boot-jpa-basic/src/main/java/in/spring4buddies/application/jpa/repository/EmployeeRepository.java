package in.spring4buddies.application.jpa.repository;

import in.spring4buddies.application.jpa.domain.Employee;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long> {

}
