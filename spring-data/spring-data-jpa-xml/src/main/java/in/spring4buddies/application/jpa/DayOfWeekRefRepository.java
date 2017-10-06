package in.spring4buddies.application.jpa;

import org.springframework.data.repository.PagingAndSortingRepository;

import in.spring4buddies.application.model.DayOfWeekRef;
import in.spring4buddies.application.model.DayOfWeekRefPK;

public interface DayOfWeekRefRepository extends PagingAndSortingRepository<DayOfWeekRef, DayOfWeekRefPK> {
}
