package in.spring4buddies.application.jpa;

import org.springframework.data.repository.PagingAndSortingRepository;

import in.spring4buddies.application.model.StoreRef;

public interface StoreRefRepository extends PagingAndSortingRepository<StoreRef, String> {
}
