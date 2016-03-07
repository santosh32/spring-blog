package in.spring4buddies.application.repository;

import in.spring4buddies.application.domain.Employee;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, String> {
}
