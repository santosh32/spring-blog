package in.spring4buddies.application.jpa.repository;

import in.spring4buddies.application.jpa.domain.Address;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends CrudRepository<Address, Long> {

}
