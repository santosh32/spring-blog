package in.spring4buddies.application.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the NODE_FULFILLMENT_TYPE_MAP database table.
 * 
 */
@Embeddable
public class NodeFulfillmentTypeMapPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="INVENTORY_ORGANIZATION_ID", insertable=false, updatable=false)
	private String inventoryOrganizationId;

	@Column(name="NODE_ID", insertable=false, updatable=false)
	private String nodeId;

	@Column(name="FULFILLMENT_TYPE_ID", insertable=false, updatable=false)
	private String fulfillmentTypeId;

	public NodeFulfillmentTypeMapPK() {
	}
	public String getInventoryOrganizationId() {
		return this.inventoryOrganizationId;
	}
	public void setInventoryOrganizationId(String inventoryOrganizationId) {
		this.inventoryOrganizationId = inventoryOrganizationId;
	}
	public String getNodeId() {
		return this.nodeId;
	}
	public void setNodeId(String nodeId) {
		this.nodeId = nodeId;
	}
	public String getFulfillmentTypeId() {
		return this.fulfillmentTypeId;
	}
	public void setFulfillmentTypeId(String fulfillmentTypeId) {
		this.fulfillmentTypeId = fulfillmentTypeId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof NodeFulfillmentTypeMapPK)) {
			return false;
		}
		NodeFulfillmentTypeMapPK castOther = (NodeFulfillmentTypeMapPK)other;
		return 
			this.inventoryOrganizationId.equals(castOther.inventoryOrganizationId)
			&& this.nodeId.equals(castOther.nodeId)
			&& this.fulfillmentTypeId.equals(castOther.fulfillmentTypeId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.inventoryOrganizationId.hashCode();
		hash = hash * prime + this.nodeId.hashCode();
		hash = hash * prime + this.fulfillmentTypeId.hashCode();
		
		return hash;
	}
}