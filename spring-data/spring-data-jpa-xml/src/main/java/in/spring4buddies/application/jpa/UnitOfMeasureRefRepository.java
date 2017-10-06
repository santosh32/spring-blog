package in.spring4buddies.application.jpa;

import org.springframework.data.repository.PagingAndSortingRepository;

import in.spring4buddies.application.model.UnitOfMeasureRef;

public interface UnitOfMeasureRefRepository extends PagingAndSortingRepository<UnitOfMeasureRef, String> {
}
