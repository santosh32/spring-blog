package in.spring4buddies.application.jpa;

import org.springframework.data.repository.PagingAndSortingRepository;

import in.spring4buddies.application.model.FulfillmentTypeRef;

public interface FulfillmentTypeRefRepository extends PagingAndSortingRepository<FulfillmentTypeRef, String> {
}
