package in.spring4buddies.application.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the CALENDAR_REF database table.
 * 
 */
@Entity
@Table(name="CALENDAR_REF")
@NamedQuery(name="CalendarRef.findAll", query="SELECT c FROM CalendarRef c")
public class CalendarRef implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private CalendarRefPK id;

	@Column(name="CALENDAR_DESCRIPTION")
	private String calendarDescription;

	//bi-directional many-to-one association to CalendarExceptionRef
	@OneToMany(mappedBy="calendarRef")
	private List<CalendarExceptionRef> calendarExceptionRefs;

	//bi-directional many-to-one association to DayRef
	@ManyToOne
	@JoinColumn(name="DEFAULT_DAY_ID")
	private DayRef dayRef;

	//bi-directional many-to-one association to InventoryOrganizationRef
	@ManyToOne
//	@JoinColumn(name="INVENTORY_ORGANIZATION_ID")
	private InventoryOrganizationRef inventoryOrganizationRef;

	//bi-directional many-to-one association to DayOfWeekRef
	@OneToMany(mappedBy="calendarRef")
	private List<DayOfWeekRef> dayOfWeekRefs;

	//bi-directional many-to-one association to InventoryOrganizationRef
	@OneToMany(mappedBy="calendarRef")
	private List<InventoryOrganizationRef> inventoryOrganizationRefs;

	//bi-directional many-to-one association to NodeRef
	@OneToMany(mappedBy="calendarRef")
	private List<NodeRef> nodeRefs;

	public CalendarRef() {
	}

	public CalendarRefPK getId() {
		return this.id;
	}

	public void setId(CalendarRefPK id) {
		this.id = id;
	}

	public String getCalendarDescription() {
		return this.calendarDescription;
	}

	public void setCalendarDescription(String calendarDescription) {
		this.calendarDescription = calendarDescription;
	}

	public List<CalendarExceptionRef> getCalendarExceptionRefs() {
		return this.calendarExceptionRefs;
	}

	public void setCalendarExceptionRefs(List<CalendarExceptionRef> calendarExceptionRefs) {
		this.calendarExceptionRefs = calendarExceptionRefs;
	}

	public CalendarExceptionRef addCalendarExceptionRef(CalendarExceptionRef calendarExceptionRef) {
		getCalendarExceptionRefs().add(calendarExceptionRef);
		calendarExceptionRef.setCalendarRef(this);

		return calendarExceptionRef;
	}

	public CalendarExceptionRef removeCalendarExceptionRef(CalendarExceptionRef calendarExceptionRef) {
		getCalendarExceptionRefs().remove(calendarExceptionRef);
		calendarExceptionRef.setCalendarRef(null);

		return calendarExceptionRef;
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

	public List<DayOfWeekRef> getDayOfWeekRefs() {
		return this.dayOfWeekRefs;
	}

	public void setDayOfWeekRefs(List<DayOfWeekRef> dayOfWeekRefs) {
		this.dayOfWeekRefs = dayOfWeekRefs;
	}

	public DayOfWeekRef addDayOfWeekRef(DayOfWeekRef dayOfWeekRef) {
		getDayOfWeekRefs().add(dayOfWeekRef);
		dayOfWeekRef.setCalendarRef(this);

		return dayOfWeekRef;
	}

	public DayOfWeekRef removeDayOfWeekRef(DayOfWeekRef dayOfWeekRef) {
		getDayOfWeekRefs().remove(dayOfWeekRef);
		dayOfWeekRef.setCalendarRef(null);

		return dayOfWeekRef;
	}

	public List<InventoryOrganizationRef> getInventoryOrganizationRefs() {
		return this.inventoryOrganizationRefs;
	}

	public void setInventoryOrganizationRefs(List<InventoryOrganizationRef> inventoryOrganizationRefs) {
		this.inventoryOrganizationRefs = inventoryOrganizationRefs;
	}

	public InventoryOrganizationRef addInventoryOrganizationRef(InventoryOrganizationRef inventoryOrganizationRef) {
		getInventoryOrganizationRefs().add(inventoryOrganizationRef);
		inventoryOrganizationRef.setCalendarRef(this);

		return inventoryOrganizationRef;
	}

	public InventoryOrganizationRef removeInventoryOrganizationRef(InventoryOrganizationRef inventoryOrganizationRef) {
		getInventoryOrganizationRefs().remove(inventoryOrganizationRef);
		inventoryOrganizationRef.setCalendarRef(null);

		return inventoryOrganizationRef;
	}

	public List<NodeRef> getNodeRefs() {
		return this.nodeRefs;
	}

	public void setNodeRefs(List<NodeRef> nodeRefs) {
		this.nodeRefs = nodeRefs;
	}

	public NodeRef addNodeRef(NodeRef nodeRef) {
		getNodeRefs().add(nodeRef);
		nodeRef.setCalendarRef(this);

		return nodeRef;
	}

	public NodeRef removeNodeRef(NodeRef nodeRef) {
		getNodeRefs().remove(nodeRef);
		nodeRef.setCalendarRef(null);

		return nodeRef;
	}

}