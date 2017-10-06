package in.spring4buddies.application.jpa;

import org.springframework.data.repository.PagingAndSortingRepository;

import in.spring4buddies.application.model.CalendarExceptionRef;
import in.spring4buddies.application.model.CalendarExceptionRefPK;

public interface CalendarExceptionRefRepository
		extends PagingAndSortingRepository<CalendarExceptionRef, CalendarExceptionRefPK> {
}
