package in.spring4buddies.application.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the NODE_GROUP_NODE_MAP database table.
 * 
 */
@Entity
@Table(name="NODE_GROUP_NODE_MAP")
@NamedQuery(name="NodeGroupNodeMap.findAll", query="SELECT n FROM NodeGroupNodeMap n")
public class NodeGroupNodeMap implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private NodeGroupNodeMapPK id;

	@Column(name="NODE_GROUP_NODE_ACTIVE_FLAG")
	private String nodeGroupNodeActiveFlag;

	@Temporal(TemporalType.DATE)
	@Column(name="NODE_GROUP_NODE_END_DATE")
	private Date nodeGroupNodeEndDate;

	@Column(name="NODE_GROUP_NODE_PRIORITY")
	private BigDecimal nodeGroupNodePriority;

	@Temporal(TemporalType.DATE)
	@Column(name="NODE_GROUP_NODE_START_DATE")
	private Date nodeGroupNodeStartDate;

	//bi-directional many-to-one association to InventoryOrganizationRef
	@ManyToOne
//	@JoinColumn(name="INVENTORY_ORGANIZATION_ID")
	private InventoryOrganizationRef inventoryOrganizationRef;

	//bi-directional many-to-one association to NodeGroupRef
	@ManyToOne
//	@JoinColumns({
//		@JoinColumn(name="INVENTORY_ORGANIZATION_ID", referencedColumnName="INVENTORY_ORGANIZATION_ID"),
//		@JoinColumn(name="NODE_GROUP_ID", referencedColumnName="NODE_GROUP_ID")
//		})
	private NodeGroupRef nodeGroupRef;

	//bi-directional many-to-one association to NodeRef
	@ManyToOne
//	@JoinColumns({
//		@JoinColumn(name="INVENTORY_ORGANIZATION_ID", referencedColumnName="INVENTORY_ORGANIZATION_ID"),
//		@JoinColumn(name="NODE_ID", referencedColumnName="NODE_ID")
//		})
	private NodeRef nodeRef;

	public NodeGroupNodeMap() {
	}

	public NodeGroupNodeMapPK getId() {
		return this.id;
	}

	public void setId(NodeGroupNodeMapPK id) {
		this.id = id;
	}

	public String getNodeGroupNodeActiveFlag() {
		return this.nodeGroupNodeActiveFlag;
	}

	public void setNodeGroupNodeActiveFlag(String nodeGroupNodeActiveFlag) {
		this.nodeGroupNodeActiveFlag = nodeGroupNodeActiveFlag;
	}

	public Date getNodeGroupNodeEndDate() {
		return this.nodeGroupNodeEndDate;
	}

	public void setNodeGroupNodeEndDate(Date nodeGroupNodeEndDate) {
		this.nodeGroupNodeEndDate = nodeGroupNodeEndDate;
	}

	public BigDecimal getNodeGroupNodePriority() {
		return this.nodeGroupNodePriority;
	}

	public void setNodeGroupNodePriority(BigDecimal nodeGroupNodePriority) {
		this.nodeGroupNodePriority = nodeGroupNodePriority;
	}

	public Date getNodeGroupNodeStartDate() {
		return this.nodeGroupNodeStartDate;
	}

	public void setNodeGroupNodeStartDate(Date nodeGroupNodeStartDate) {
		this.nodeGroupNodeStartDate = nodeGroupNodeStartDate;
	}

	public InventoryOrganizationRef getInventoryOrganizationRef() {
		return this.inventoryOrganizationRef;
	}

	public void setInventoryOrganizationRef(InventoryOrganizationRef inventoryOrganizationRef) {
		this.inventoryOrganizationRef = inventoryOrganizationRef;
	}

	public NodeGroupRef getNodeGroupRef() {
		return this.nodeGroupRef;
	}

	public void setNodeGroupRef(NodeGroupRef nodeGroupRef) {
		this.nodeGroupRef = nodeGroupRef;
	}

	public NodeRef getNodeRef() {
		return this.nodeRef;
	}

	public void setNodeRef(NodeRef nodeRef) {
		this.nodeRef = nodeRef;
	}

}