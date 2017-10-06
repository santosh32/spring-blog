package in.spring4buddies.application.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the NODE_FULFILLMENT_TYPE_MAP database table.
 * 
 */
@Entity
@Table(name="NODE_FULFILLMENT_TYPE_MAP")
@NamedQuery(name="NodeFulfillmentTypeMap.findAll", query="SELECT n FROM NodeFulfillmentTypeMap n")
public class NodeFulfillmentTypeMap implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private NodeFulfillmentTypeMapPK id;

	//bi-directional many-to-one association to FulfillmentTypeRef
	@ManyToOne
//	@JoinColumn(name="FULFILLMENT_TYPE_ID" )
	private FulfillmentTypeRef fulfillmentTypeRef;

	//bi-directional many-to-one association to InventoryOrganizationRef
	@ManyToOne
//	@JoinColumn(name="INVENTORY_ORGANIZATION_ID")
	private InventoryOrganizationRef inventoryOrganizationRef;

	//bi-directional many-to-one association to NodeRef
	@ManyToOne
//	@JoinColumns({
//		@JoinColumn(name="INVENTORY_ORGANIZATION_ID", referencedColumnName="INVENTORY_ORGANIZATION_ID"),
//		@JoinColumn(name="NODE_ID", referencedColumnName="NODE_ID")
//		})
	private NodeRef nodeRef;

	public NodeFulfillmentTypeMap() {
	}

	public NodeFulfillmentTypeMapPK getId() {
		return this.id;
	}

	public void setId(NodeFulfillmentTypeMapPK id) {
		this.id = id;
	}

	public FulfillmentTypeRef getFulfillmentTypeRef() {
		return this.fulfillmentTypeRef;
	}

	public void setFulfillmentTypeRef(FulfillmentTypeRef fulfillmentTypeRef) {
		this.fulfillmentTypeRef = fulfillmentTypeRef;
	}

	public InventoryOrganizationRef getInventoryOrganizationRef() {
		return this.inventoryOrganizationRef;
	}

	public void setInventoryOrganizationRef(InventoryOrganizationRef inventoryOrganizationRef) {
		this.inventoryOrganizationRef = inventoryOrganizationRef;
	}

	public NodeRef getNodeRef() {
		return this.nodeRef;
	}

	public void setNodeRef(NodeRef nodeRef) {
		this.nodeRef = nodeRef;
	}

}