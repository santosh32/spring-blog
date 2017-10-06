package in.spring4buddies.application.jpa;

import org.springframework.data.repository.PagingAndSortingRepository;

import in.spring4buddies.application.model.ShiftRef;

public interface ShiftRefRepository extends PagingAndSortingRepository<ShiftRef, Long> {
}
