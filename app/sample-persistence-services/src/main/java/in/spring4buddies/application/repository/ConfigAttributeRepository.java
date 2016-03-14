package in.spring4buddies.application.repository;

import in.spring4buddies.application.domain.ConfigAttribute;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConfigAttributeRepository extends
		CrudRepository<ConfigAttribute, Integer> {

}
