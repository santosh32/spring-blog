package in.spring4buddies.application.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the CALENDAR_EXCEPTION_REF database table.
 * 
 */
@Entity
@Table(name="CALENDAR_EXCEPTION_REF")
@NamedQuery(name="CalendarExceptionRef.findAll", query="SELECT c FROM CalendarExceptionRef c")
public class CalendarExceptionRef implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private CalendarExceptionRefPK id;

	@Temporal(TemporalType.DATE)
	@Column(name="CALENDAR_DATE")
	private Date calendarDate;

	//bi-directional many-to-one association to CalendarRef
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name="CALENDAR_ID", referencedColumnName="CALENDAR_ID"),
		@JoinColumn(name="INVENTORY_ORGANIZATION_ID", referencedColumnName="INVENTORY_ORGANIZATION_ID")
		})
	private CalendarRef calendarRef;

	//bi-directional many-to-one association to DayRef
	@ManyToOne
	@JoinColumn(name="EXCEPTION_DAY_ID")
	private DayRef dayRef;

	//bi-directional many-to-one association to InventoryOrganizationRef
	@ManyToOne
	@JoinColumn(name="INVENTORY_ORGANIZATION_ID")
	private InventoryOrganizationRef inventoryOrganizationRef;

	public CalendarExceptionRef() {
	}

	public CalendarExceptionRefPK getId() {
		return this.id;
	}

	public void setId(CalendarExceptionRefPK id) {
		this.id = id;
	}

	public Date getCalendarDate() {
		return this.calendarDate;
	}

	public void setCalendarDate(Date calendarDate) {
		this.calendarDate = calendarDate;
	}

	public CalendarRef getCalendarRef() {
		return this.calendarRef;
	}

	public void setCalendarRef(CalendarRef calendarRef) {
		this.calendarRef = calendarRef;
	}

	public DayRef getDayRef() {
		return this.dayRef;
	}

	public void setDayRef(DayRef dayRef) {
		this.dayRef = dayRef;
	}

	public InventoryOrganizationRef getInventoryOrganizationRef() {
		return this.inventoryOrganizationRef;
	}

	public void setInventoryOrganizationRef(InventoryOrganizationRef inventoryOrganizationRef) {
		this.inventoryOrganizationRef = inventoryOrganizationRef;
	}

}