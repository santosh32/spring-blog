package in.spring4buddies.application.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the NODE_GROUP_REF database table.
 * 
 */
@Entity
@Table(name="NODE_GROUP_REF")
@NamedQuery(name="NodeGroupRef.findAll", query="SELECT n FROM NodeGroupRef n")
public class NodeGroupRef implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private NodeGroupRefPK id;

	@Column(name="NODE_GROUP_DESCRIPTION")
	private String nodeGroupDescription;

	//bi-directional many-to-one association to InventoryOrganizationRef
	@OneToMany(mappedBy="nodeGroupRef")
	private List<InventoryOrganizationRef> inventoryOrganizationRefs;

	//bi-directional many-to-one association to NodeGroupNodeMap
	@OneToMany(mappedBy="nodeGroupRef")
	private List<NodeGroupNodeMap> nodeGroupNodeMaps;

	//bi-directional many-to-one association to InventoryOrganizationRef
	@ManyToOne
	@JoinColumn(name="INVENTORY_ORGANIZATION_ID")
	private InventoryOrganizationRef inventoryOrganizationRef;

	public NodeGroupRef() {
	}

	public NodeGroupRefPK getId() {
		return this.id;
	}

	public void setId(NodeGroupRefPK id) {
		this.id = id;
	}

	public String getNodeGroupDescription() {
		return this.nodeGroupDescription;
	}

	public void setNodeGroupDescription(String nodeGroupDescription) {
		this.nodeGroupDescription = nodeGroupDescription;
	}

	public List<InventoryOrganizationRef> getInventoryOrganizationRefs() {
		return this.inventoryOrganizationRefs;
	}

	public void setInventoryOrganizationRefs(List<InventoryOrganizationRef> inventoryOrganizationRefs) {
		this.inventoryOrganizationRefs = inventoryOrganizationRefs;
	}

	public InventoryOrganizationRef addInventoryOrganizationRef(InventoryOrganizationRef inventoryOrganizationRef) {
		getInventoryOrganizationRefs().add(inventoryOrganizationRef);
		inventoryOrganizationRef.setNodeGroupRef(this);

		return inventoryOrganizationRef;
	}

	public InventoryOrganizationRef removeInventoryOrganizationRef(InventoryOrganizationRef inventoryOrganizationRef) {
		getInventoryOrganizationRefs().remove(inventoryOrganizationRef);
		inventoryOrganizationRef.setNodeGroupRef(null);

		return inventoryOrganizationRef;
	}

	public List<NodeGroupNodeMap> getNodeGroupNodeMaps() {
		return this.nodeGroupNodeMaps;
	}

	public void setNodeGroupNodeMaps(List<NodeGroupNodeMap> nodeGroupNodeMaps) {
		this.nodeGroupNodeMaps = nodeGroupNodeMaps;
	}

	public NodeGroupNodeMap addNodeGroupNodeMap(NodeGroupNodeMap nodeGroupNodeMap) {
		getNodeGroupNodeMaps().add(nodeGroupNodeMap);
		nodeGroupNodeMap.setNodeGroupRef(this);

		return nodeGroupNodeMap;
	}

	public NodeGroupNodeMap removeNodeGroupNodeMap(NodeGroupNodeMap nodeGroupNodeMap) {
		getNodeGroupNodeMaps().remove(nodeGroupNodeMap);
		nodeGroupNodeMap.setNodeGroupRef(null);

		return nodeGroupNodeMap;
	}

	public InventoryOrganizationRef getInventoryOrganizationRef() {
		return this.inventoryOrganizationRef;
	}

	public void setInventoryOrganizationRef(InventoryOrganizationRef inventoryOrganizationRef) {
		this.inventoryOrganizationRef = inventoryOrganizationRef;
	}

}