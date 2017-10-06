package in.spring4buddies.application.jpa;

import org.springframework.data.repository.PagingAndSortingRepository;

import in.spring4buddies.application.model.ProductClassRef;

public interface ProductClassRefRepository extends PagingAndSortingRepository<ProductClassRef, String> {
}
