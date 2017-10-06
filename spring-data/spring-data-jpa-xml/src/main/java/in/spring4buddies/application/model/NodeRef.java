package in.spring4buddies.application.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the NODE_REF database table.
 * 
 */
@Entity
@Table(name="NODE_REF")
@NamedQuery(name="NodeRef.findAll", query="SELECT n FROM NodeRef n")
public class NodeRef implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private NodeRefPK id;

	@Column(name="ACTIVE_FOR_AVAILABILITY_FLAG")
	private String activeForAvailabilityFlag;

	@Column(name="GIFTWRAP_ALLOWED_FLAG")
	private String giftwrapAllowedFlag;

	@Column(name="INFINITE_FLAG")
	private String infiniteFlag;

	@Column(name="LOCALE_CODE")
	private String localeCode;

	@Column(name="MAX_SHIPMENT_PROCESSING_DAYS")
	private BigDecimal maxShipmentProcessingDays;

	@Column(name="MIN_SHIPMENT_PROCESSING_DAYS")
	private BigDecimal minShipmentProcessingDays;

	@Column(name="NODE_DESCRIPTION")
	private String nodeDescription;

	@Column(name="NODE_LATITUDE")
	private BigDecimal nodeLatitude;

	@Column(name="NODE_LONGITUDE")
	private BigDecimal nodeLongitude;

	@Column(name="NODE_PRIORITY")
	private BigDecimal nodePriority;

	@Column(name="NODE_REJECTED_SUPPLY_ACTION")
	private String nodeRejectedSupplyAction;

	@Column(name="RECEIPT_PROCESSING_DAYS")
	private BigDecimal receiptProcessingDays;

	@Column(name="SHIP_NODE_FLAG")
	private String shipNodeFlag;

	@Column(name="ZONE_ID")
	private String zoneId;

	//bi-directional many-to-one association to NodeFulfillmentTypeMap
	@OneToMany(mappedBy="nodeRef")
	private List<NodeFulfillmentTypeMap> nodeFulfillmentTypeMaps;

	//bi-directional many-to-one association to NodeGroupNodeMap
	@OneToMany(mappedBy="nodeRef")
	private List<NodeGroupNodeMap> nodeGroupNodeMaps;

	//bi-directional many-to-one association to AddressRef
	@ManyToOne
//	@JoinColumn(name="ADDRESS_ID")
	private AddressRef addressRef;

	//bi-directional many-to-one association to CalendarRef
	@ManyToOne
//	@JoinColumns({
//		@JoinColumn(name="INVENTORY_ORGANIZATION_ID", referencedColumnName="INVENTORY_ORGANIZATION_ID"),
//		@JoinColumn(name="SHIPPING_CALENDAR_ID", referencedColumnName="CALENDAR_ID")
//		})
	private CalendarRef calendarRef;

	//bi-directional many-to-one association to InventoryOrganizationRef
	@ManyToOne
//	@JoinColumn(name="INVENTORY_ORGANIZATION_ID")
	private InventoryOrganizationRef inventoryOrganizationRef;

	//bi-directional many-to-one association to NodeTypeRef
	@ManyToOne
//	@JoinColumn(name="NODE_TYPE_ID")
	private NodeTypeRef nodeTypeRef;

	public NodeRef() {
	}

	public NodeRefPK getId() {
		return this.id;
	}

	public void setId(NodeRefPK id) {
		this.id = id;
	}

	public String getActiveForAvailabilityFlag() {
		return this.activeForAvailabilityFlag;
	}

	public void setActiveForAvailabilityFlag(String activeForAvailabilityFlag) {
		this.activeForAvailabilityFlag = activeForAvailabilityFlag;
	}

	public String getGiftwrapAllowedFlag() {
		return this.giftwrapAllowedFlag;
	}

	public void setGiftwrapAllowedFlag(String giftwrapAllowedFlag) {
		this.giftwrapAllowedFlag = giftwrapAllowedFlag;
	}

	public String getInfiniteFlag() {
		return this.infiniteFlag;
	}

	public void setInfiniteFlag(String infiniteFlag) {
		this.infiniteFlag = infiniteFlag;
	}

	public String getLocaleCode() {
		return this.localeCode;
	}

	public void setLocaleCode(String localeCode) {
		this.localeCode = localeCode;
	}

	public BigDecimal getMaxShipmentProcessingDays() {
		return this.maxShipmentProcessingDays;
	}

	public void setMaxShipmentProcessingDays(BigDecimal maxShipmentProcessingDays) {
		this.maxShipmentProcessingDays = maxShipmentProcessingDays;
	}

	public BigDecimal getMinShipmentProcessingDays() {
		return this.minShipmentProcessingDays;
	}

	public void setMinShipmentProcessingDays(BigDecimal minShipmentProcessingDays) {
		this.minShipmentProcessingDays = minShipmentProcessingDays;
	}

	public String getNodeDescription() {
		return this.nodeDescription;
	}

	public void setNodeDescription(String nodeDescription) {
		this.nodeDescription = nodeDescription;
	}

	public BigDecimal getNodeLatitude() {
		return this.nodeLatitude;
	}

	public void setNodeLatitude(BigDecimal nodeLatitude) {
		this.nodeLatitude = nodeLatitude;
	}

	public BigDecimal getNodeLongitude() {
		return this.nodeLongitude;
	}

	public void setNodeLongitude(BigDecimal nodeLongitude) {
		this.nodeLongitude = nodeLongitude;
	}

	public BigDecimal getNodePriority() {
		return this.nodePriority;
	}

	public void setNodePriority(BigDecimal nodePriority) {
		this.nodePriority = nodePriority;
	}

	public String getNodeRejectedSupplyAction() {
		return this.nodeRejectedSupplyAction;
	}

	public void setNodeRejectedSupplyAction(String nodeRejectedSupplyAction) {
		this.nodeRejectedSupplyAction = nodeRejectedSupplyAction;
	}

	public BigDecimal getReceiptProcessingDays() {
		return this.receiptProcessingDays;
	}

	public void setReceiptProcessingDays(BigDecimal receiptProcessingDays) {
		this.receiptProcessingDays = receiptProcessingDays;
	}

	public String getShipNodeFlag() {
		return this.shipNodeFlag;
	}

	public void setShipNodeFlag(String shipNodeFlag) {
		this.shipNodeFlag = shipNodeFlag;
	}

	public String getZoneId() {
		return this.zoneId;
	}

	public void setZoneId(String zoneId) {
		this.zoneId = zoneId;
	}

	public List<NodeFulfillmentTypeMap> getNodeFulfillmentTypeMaps() {
		return this.nodeFulfillmentTypeMaps;
	}

	public void setNodeFulfillmentTypeMaps(List<NodeFulfillmentTypeMap> nodeFulfillmentTypeMaps) {
		this.nodeFulfillmentTypeMaps = nodeFulfillmentTypeMaps;
	}

	public NodeFulfillmentTypeMap addNodeFulfillmentTypeMap(NodeFulfillmentTypeMap nodeFulfillmentTypeMap) {
		getNodeFulfillmentTypeMaps().add(nodeFulfillmentTypeMap);
		nodeFulfillmentTypeMap.setNodeRef(this);

		return nodeFulfillmentTypeMap;
	}

	public NodeFulfillmentTypeMap removeNodeFulfillmentTypeMap(NodeFulfillmentTypeMap nodeFulfillmentTypeMap) {
		getNodeFulfillmentTypeMaps().remove(nodeFulfillmentTypeMap);
		nodeFulfillmentTypeMap.setNodeRef(null);

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
		nodeGroupNodeMap.setNodeRef(this);

		return nodeGroupNodeMap;
	}

	public NodeGroupNodeMap removeNodeGroupNodeMap(NodeGroupNodeMap nodeGroupNodeMap) {
		getNodeGroupNodeMaps().remove(nodeGroupNodeMap);
		nodeGroupNodeMap.setNodeRef(null);

		return nodeGroupNodeMap;
	}

	public AddressRef getAddressRef() {
		return this.addressRef;
	}

	public void setAddressRef(AddressRef addressRef) {
		this.addressRef = addressRef;
	}

	public CalendarRef getCalendarRef() {
		return this.calendarRef;
	}

	public void setCalendarRef(CalendarRef calendarRef) {
		this.calendarRef = calendarRef;
	}

	public InventoryOrganizationRef getInventoryOrganizationRef() {
		return this.inventoryOrganizationRef;
	}

	public void setInventoryOrganizationRef(InventoryOrganizationRef inventoryOrganizationRef) {
		this.inventoryOrganizationRef = inventoryOrganizationRef;
	}

	public NodeTypeRef getNodeTypeRef() {
		return this.nodeTypeRef;
	}

	public void setNodeTypeRef(NodeTypeRef nodeTypeRef) {
		this.nodeTypeRef = nodeTypeRef;
	}

}