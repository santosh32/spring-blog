package in.spring4buddies.application.jpa;

import org.springframework.data.repository.PagingAndSortingRepository;

import in.spring4buddies.application.model.CalendarRef;
import in.spring4buddies.application.model.CalendarRefPK;

public interface CalendarRefRepository extends PagingAndSortingRepository<CalendarRef, CalendarRefPK> {
}
