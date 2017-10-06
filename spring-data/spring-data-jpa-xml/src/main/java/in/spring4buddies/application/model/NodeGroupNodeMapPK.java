package in.spring4buddies.application.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the NODE_GROUP_NODE_MAP database table.
 * 
 */
@Embeddable
public class NodeGroupNodeMapPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="INVENTORY_ORGANIZATION_ID", insertable=false, updatable=false)
	private String inventoryOrganizationId;

	@Column(name="NODE_GROUP_ID", insertable=false, updatable=false)
	private String nodeGroupId;

	@Column(name="NODE_ID", insertable=false, updatable=false)
	private String nodeId;

	public NodeGroupNodeMapPK() {
	}
	public String getInventoryOrganizationId() {
		return this.inventoryOrganizationId;
	}
	public void setInventoryOrganizationId(String inventoryOrganizationId) {
		this.inventoryOrganizationId = inventoryOrganizationId;
	}
	public String getNodeGroupId() {
		return this.nodeGroupId;
	}
	public void setNodeGroupId(String nodeGroupId) {
		this.nodeGroupId = nodeGroupId;
	}
	public String getNodeId() {
		return this.nodeId;
	}
	public void setNodeId(String nodeId) {
		this.nodeId = nodeId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof NodeGroupNodeMapPK)) {
			return false;
		}
		NodeGroupNodeMapPK castOther = (NodeGroupNodeMapPK)other;
		return 
			this.inventoryOrganizationId.equals(castOther.inventoryOrganizationId)
			&& this.nodeGroupId.equals(castOther.nodeGroupId)
			&& this.nodeId.equals(castOther.nodeId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.inventoryOrganizationId.hashCode();
		hash = hash * prime + this.nodeGroupId.hashCode();
		hash = hash * prime + this.nodeId.hashCode();
		
		return hash;
	}
}