package in.spring4buddies.application.repository;

import in.spring4buddies.application.domain.Payroll;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PayrollRepository extends CrudRepository<Payroll, Integer> {

}
