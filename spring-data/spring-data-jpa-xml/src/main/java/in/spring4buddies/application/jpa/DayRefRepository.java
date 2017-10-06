package in.spring4buddies.application.jpa;

import org.springframework.data.repository.PagingAndSortingRepository;

import in.spring4buddies.application.model.DayRef;

public interface DayRefRepository extends PagingAndSortingRepository<DayRef, Long> {
}
