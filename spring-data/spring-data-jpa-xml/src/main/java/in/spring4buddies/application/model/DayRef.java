package in.spring4buddies.application.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the DAY_REF database table.
 * 
 */
@Entity
@Table(name="DAY_REF")
@NamedQuery(name="DayRef.findAll", query="SELECT d FROM DayRef d")
public class DayRef implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="DAY_ID")
	private long dayId;

	@Column(name="WORKING_FLAG")
	private String workingFlag;

	//bi-directional many-to-one association to CalendarExceptionRef
	@OneToMany(mappedBy="dayRef")
	private List<CalendarExceptionRef> calendarExceptionRefs;

	//bi-directional many-to-one association to CalendarRef
	@OneToMany(mappedBy="dayRef")
	private List<CalendarRef> calendarRefs;

	//bi-directional many-to-one association to DayOfWeekRef
	@OneToMany(mappedBy="dayRef")
	private List<DayOfWeekRef> dayOfWeekRefs;

	//bi-directional many-to-one association to ShiftRef
	@OneToMany(mappedBy="dayRef")
	private List<ShiftRef> shiftRefs;

	public DayRef() {
	}

	public long getDayId() {
		return this.dayId;
	}

	public void setDayId(long dayId) {
		this.dayId = dayId;
	}

	public String getWorkingFlag() {
		return this.workingFlag;
	}

	public void setWorkingFlag(String workingFlag) {
		this.workingFlag = workingFlag;
	}

	public List<CalendarExceptionRef> getCalendarExceptionRefs() {
		return this.calendarExceptionRefs;
	}

	public void setCalendarExceptionRefs(List<CalendarExceptionRef> calendarExceptionRefs) {
		this.calendarExceptionRefs = calendarExceptionRefs;
	}

	public CalendarExceptionRef addCalendarExceptionRef(CalendarExceptionRef calendarExceptionRef) {
		getCalendarExceptionRefs().add(calendarExceptionRef);
		calendarExceptionRef.setDayRef(this);

		return calendarExceptionRef;
	}

	public CalendarExceptionRef removeCalendarExceptionRef(CalendarExceptionRef calendarExceptionRef) {
		getCalendarExceptionRefs().remove(calendarExceptionRef);
		calendarExceptionRef.setDayRef(null);

		return calendarExceptionRef;
	}

	public List<CalendarRef> getCalendarRefs() {
		return this.calendarRefs;
	}

	public void setCalendarRefs(List<CalendarRef> calendarRefs) {
		this.calendarRefs = calendarRefs;
	}

	public CalendarRef addCalendarRef(CalendarRef calendarRef) {
		getCalendarRefs().add(calendarRef);
		calendarRef.setDayRef(this);

		return calendarRef;
	}

	public CalendarRef removeCalendarRef(CalendarRef calendarRef) {
		getCalendarRefs().remove(calendarRef);
		calendarRef.setDayRef(null);

		return calendarRef;
	}

	public List<DayOfWeekRef> getDayOfWeekRefs() {
		return this.dayOfWeekRefs;
	}

	public void setDayOfWeekRefs(List<DayOfWeekRef> dayOfWeekRefs) {
		this.dayOfWeekRefs = dayOfWeekRefs;
	}

	public DayOfWeekRef addDayOfWeekRef(DayOfWeekRef dayOfWeekRef) {
		getDayOfWeekRefs().add(dayOfWeekRef);
		dayOfWeekRef.setDayRef(this);

		return dayOfWeekRef;
	}

	public DayOfWeekRef removeDayOfWeekRef(DayOfWeekRef dayOfWeekRef) {
		getDayOfWeekRefs().remove(dayOfWeekRef);
		dayOfWeekRef.setDayRef(null);

		return dayOfWeekRef;
	}

	public List<ShiftRef> getShiftRefs() {
		return this.shiftRefs;
	}

	public void setShiftRefs(List<ShiftRef> shiftRefs) {
		this.shiftRefs = shiftRefs;
	}

	public ShiftRef addShiftRef(ShiftRef shiftRef) {
		getShiftRefs().add(shiftRef);
		shiftRef.setDayRef(this);

		return shiftRef;
	}

	public ShiftRef removeShiftRef(ShiftRef shiftRef) {
		getShiftRefs().remove(shiftRef);
		shiftRef.setDayRef(null);

		return shiftRef;
	}

}