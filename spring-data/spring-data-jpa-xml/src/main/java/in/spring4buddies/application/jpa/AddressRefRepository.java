package in.spring4buddies.application.jpa;

import org.springframework.data.repository.PagingAndSortingRepository;

import in.spring4buddies.application.model.AddressRef;

public interface AddressRefRepository extends PagingAndSortingRepository<AddressRef, Long> {
}
