package in.spring4buddies.application.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the INVENTORY_ORGANIZATION_REF database table.
 * 
 */
@Entity
@Table(name="INVENTORY_ORGANIZATION_REF")
@NamedQuery(name="InventoryOrganizationRef.findAll", query="SELECT i FROM InventoryOrganizationRef i")
public class InventoryOrganizationRef implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="INVENTORY_ORGANIZATION_ID")
	private String inventoryOrganizationId;

	@Column(name="ACTIVE_FOR_AVAILABILITY_FLAG")
	private String activeForAvailabilityFlag;

	@Column(name="INVENTORY_ORGANIZATION_NAME")
	private String inventoryOrganizationName;

	@Column(name="NODE_REJECTED_SUPPLY_ACTION")
	private String nodeRejectedSupplyAction;

	//bi-directional many-to-one association to CalendarExceptionRef
	@OneToMany(mappedBy="inventoryOrganizationRef")
	private List<CalendarExceptionRef> calendarExceptionRefs;

	//bi-directional many-to-one association to CalendarRef
	@OneToMany(mappedBy="inventoryOrganizationRef")
	private List<CalendarRef> calendarRefs;

	//bi-directional many-to-one association to DayOfWeekRef
	@OneToMany(mappedBy="inventoryOrganizationRef")
	private List<DayOfWeekRef> dayOfWeekRefs;

	//bi-directional many-to-one association to CalendarRef
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name="DEFAULT_SHIPPING_CALENDAR_ID", referencedColumnName="CALENDAR_ID"),
		@JoinColumn(name="INVENTORY_ORGANIZATION_ID", referencedColumnName="INVENTORY_ORGANIZATION_ID")
		})
	private CalendarRef calendarRef;

	//bi-directional many-to-one association to NodeGroupRef
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name="DEFAULT_NODE_GROUP_ID", referencedColumnName="NODE_GROUP_ID"),
		@JoinColumn(name="INVENTORY_ORGANIZATION_ID", referencedColumnName="INVENTORY_ORGANIZATION_ID")
		})
	private NodeGroupRef nodeGroupRef;

	//bi-directional many-to-one association to ProductClassRef
	@ManyToOne
	@JoinColumn(name="DEFAULT_PRODUCT_CLASS_ID")
	private ProductClassRef productClassRef;

	//bi-directional many-to-one association to UnitOfMeasureRef
	@ManyToOne
	@JoinColumn(name="DEFAULT_UNIT_OF_MEASURE_ID")
	private UnitOfMeasureRef unitOfMeasureRef;

	//bi-directional many-to-one association to NodeFulfillmentTypeMap
	@OneToMany(mappedBy="inventoryOrganizationRef")
	private List<NodeFulfillmentTypeMap> nodeFulfillmentTypeMaps;

	//bi-directional many-to-one association to NodeGroupNodeMap
	@OneToMany(mappedBy="inventoryOrganizationRef")
	private List<NodeGroupNodeMap> nodeGroupNodeMaps;

	//bi-directional many-to-one association to NodeGroupRef
	@OneToMany(mappedBy="inventoryOrganizationRef")
	private List<NodeGroupRef> nodeGroupRefs;

	//bi-directional many-to-one association to NodeRef
	@OneToMany(mappedBy="inventoryOrganizationRef")
	private List<NodeRef> nodeRefs;

	//bi-directional many-to-one association to StoreRef
	@OneToMany(mappedBy="inventoryOrganizationRef")
	private List<StoreRef> storeRefs;

	public InventoryOrganizationRef() {
	}

	public String getInventoryOrganizationId() {
		return this.inventoryOrganizationId;
	}

	public void setInventoryOrganizationId(String inventoryOrganizationId) {
		this.inventoryOrganizationId = inventoryOrganizationId;
	}

	public String getActiveForAvailabilityFlag() {
		return this.activeForAvailabilityFlag;
	}

	public void setActiveForAvailabilityFlag(String activeForAvailabilityFlag) {
		this.activeForAvailabilityFlag = activeForAvailabilityFlag;
	}

	public String getInventoryOrganizationName() {
		return this.inventoryOrganizationName;
	}

	public void setInventoryOrganizationName(String inventoryOrganizationName) {
		this.inventoryOrganizationName = inventoryOrganizationName;
	}

	public String getNodeRejectedSupplyAction() {
		return this.nodeRejectedSupplyAction;
	}

	public void setNodeRejectedSupplyAction(String nodeRejectedSupplyAction) {
		this.nodeRejectedSupplyAction = nodeRejectedSupplyAction;
	}

	public List<CalendarExceptionRef> getCalendarExceptionRefs() {
		return this.calendarExceptionRefs;
	}

	public void setCalendarExceptionRefs(List<CalendarExceptionRef> calendarExceptionRefs) {
		this.calendarExceptionRefs = calendarExceptionRefs;
	}

	public CalendarExceptionRef addCalendarExceptionRef(CalendarExceptionRef calendarExceptionRef) {
		getCalendarExceptionRefs().add(calendarExceptionRef);
		calendarExceptionRef.setInventoryOrganizationRef(this);

		return calendarExceptionRef;
	}

	public CalendarExceptionRef removeCalendarExceptionRef(CalendarExceptionRef calendarExceptionRef) {
		getCalendarExceptionRefs().remove(calendarExceptionRef);
		calendarExceptionRef.setInventoryOrganizationRef(null);

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
		calendarRef.setInventoryOrganizationRef(this);

		return calendarRef;
	}

	public CalendarRef removeCalendarRef(CalendarRef calendarRef) {
		getCalendarRefs().remove(calendarRef);
		calendarRef.setInventoryOrganizationRef(null);

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
		dayOfWeekRef.setInventoryOrganizationRef(this);

		return dayOfWeekRef;
	}

	public DayOfWeekRef removeDayOfWeekRef(DayOfWeekRef dayOfWeekRef) {
		getDayOfWeekRefs().remove(dayOfWeekRef);
		dayOfWeekRef.setInventoryOrganizationRef(null);

		return dayOfWeekRef;
	}

	public CalendarRef getCalendarRef() {
		return this.calendarRef;
	}

	public void setCalendarRef(CalendarRef calendarRef) {
		this.calendarRef = calendarRef;
	}

	public NodeGroupRef getNodeGroupRef() {
		return this.nodeGroupRef;
	}

	public void setNodeGroupRef(NodeGroupRef nodeGroupRef) {
		this.nodeGroupRef = nodeGroupRef;
	}

	public ProductClassRef getProductClassRef() {
		return this.productClassRef;
	}

	public void setProductClassRef(ProductClassRef productClassRef) {
		this.productClassRef = productClassRef;
	}

	public UnitOfMeasureRef getUnitOfMeasureRef() {
		return this.unitOfMeasureRef;
	}

	public void setUnitOfMeasureRef(UnitOfMeasureRef unitOfMeasureRef) {
		this.unitOfMeasureRef = unitOfMeasureRef;
	}

	public List<NodeFulfillmentTypeMap> getNodeFulfillmentTypeMaps() {
		return this.nodeFulfillmentTypeMaps;
	}

	public void setNodeFulfillmentTypeMaps(List<NodeFulfillmentTypeMap> nodeFulfillmentTypeMaps) {
		this.nodeFulfillmentTypeMaps = nodeFulfillmentTypeMaps;
	}

	public NodeFulfillmentTypeMap addNodeFulfillmentTypeMap(NodeFulfillmentTypeMap nodeFulfillmentTypeMap) {
		getNodeFulfillmentTypeMaps().add(nodeFulfillmentTypeMap);
		nodeFulfillmentTypeMap.setInventoryOrganizationRef(this);

		return nodeFulfillmentTypeMap;
	}

	public NodeFulfillmentTypeMap removeNodeFulfillmentTypeMap(NodeFulfillmentTypeMap nodeFulfillmentTypeMap) {
		getNodeFulfillmentTypeMaps().remove(nodeFulfillmentTypeMap);
		nodeFulfillmentTypeMap.setInventoryOrganizationRef(null);

		return nodeFulfillmentTypeMap;
	}

	public List<NodeGroupNodeMap> getNodeGroupNodeMaps() {
		return this.nodeGroupNodeMaps;
	}

	public void setNodeGroupNodeMaps(List<NodeGroupNodeMap> nodeGroupNodeMaps) {
		this.nodeGroupNodeMaps = nodeGroupNodeMaps;
	}

	public NodeGroupNodeMap addNodeGroupNodeMap(NodeGroupNodeMap nodeGroupNodeMap) {
		getNodeGroupNodeMaps().add(nodeGroupNodeMap);
		nodeGroupNodeMap.setInventoryOrganizationRef(this);

		return nodeGroupNodeMap;
	}

	public NodeGroupNodeMap removeNodeGroupNodeMap(NodeGroupNodeMap nodeGroupNodeMap) {
		getNodeGroupNodeMaps().remove(nodeGroupNodeMap);
		nodeGroupNodeMap.setInventoryOrganizationRef(null);

		return nodeGroupNodeMap;
	}

	public List<NodeGroupRef> getNodeGroupRefs() {
		return this.nodeGroupRefs;
	}

	public void setNodeGroupRefs(List<NodeGroupRef> nodeGroupRefs) {
		this.nodeGroupRefs = nodeGroupRefs;
	}

	public NodeGroupRef addNodeGroupRef(NodeGroupRef nodeGroupRef) {
		getNodeGroupRefs().add(nodeGroupRef);
		nodeGroupRef.setInventoryOrganizationRef(this);

		return nodeGroupRef;
	}

	public NodeGroupRef removeNodeGroupRef(NodeGroupRef nodeGroupRef) {
		getNodeGroupRefs().remove(nodeGroupRef);
		nodeGroupRef.setInventoryOrganizationRef(null);

		return nodeGroupRef;
	}

	public List<NodeRef> getNodeRefs() {
		return this.nodeRefs;
	}

	public void setNodeRefs(List<NodeRef> nodeRefs) {
		this.nodeRefs = nodeRefs;
	}

	public NodeRef addNodeRef(NodeRef nodeRef) {
		getNodeRefs().add(nodeRef);
		nodeRef.setInventoryOrganizationRef(this);

		return nodeRef;
	}

	public NodeRef removeNodeRef(NodeRef nodeRef) {
		getNodeRefs().remove(nodeRef);
		nodeRef.setInventoryOrganizationRef(null);

		return nodeRef;
	}

	public List<StoreRef> getStoreRefs() {
		return this.storeRefs;
	}

	public void setStoreRefs(List<StoreRef> storeRefs) {
		this.storeRefs = storeRefs;
	}

	public StoreRef addStoreRef(StoreRef storeRef) {
		getStoreRefs().add(storeRef);
		storeRef.setInventoryOrganizationRef(this);

		return storeRef;
	}

	public StoreRef removeStoreRef(StoreRef storeRef) {
		getStoreRefs().remove(storeRef);
		storeRef.setInventoryOrganizationRef(null);

		return storeRef;
	}

}