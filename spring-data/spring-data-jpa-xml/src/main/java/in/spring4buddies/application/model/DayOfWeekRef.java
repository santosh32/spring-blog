package in.spring4buddies.application.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the DAY_OF_WEEK_REF database table.
 * 
 */
@Entity
@Table(name="DAY_OF_WEEK_REF")
@NamedQuery(name="DayOfWeekRef.findAll", query="SELECT d FROM DayOfWeekRef d")
public class DayOfWeekRef implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private DayOfWeekRefPK id;

	@Column(name="DAY_OF_WEEK")
	private BigDecimal dayOfWeek;

	//bi-directional many-to-one association to CalendarRef
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name="CALENDAR_ID", referencedColumnName="CALENDAR_ID"),
		@JoinColumn(name="INVENTORY_ORGANIZATION_ID", referencedColumnName="INVENTORY_ORGANIZATION_ID")
		})
	private CalendarRef calendarRef;

	//bi-directional many-to-one association to DayRef
	@ManyToOne
	@JoinColumn(name="DAY_ID")
	private DayRef dayRef;

	//bi-directional many-to-one association to InventoryOrganizationRef
	@ManyToOne
	@JoinColumn(name="INVENTORY_ORGANIZATION_ID")
	private InventoryOrganizationRef inventoryOrganizationRef;

	public DayOfWeekRef() {
	}

	public DayOfWeekRefPK getId() {
		return this.id;
	}

	public void setId(DayOfWeekRefPK id) {
		this.id = id;
	}

	public BigDecimal getDayOfWeek() {
		return this.dayOfWeek;
	}

	public void setDayOfWeek(BigDecimal dayOfWeek) {
		this.dayOfWeek = dayOfWeek;
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