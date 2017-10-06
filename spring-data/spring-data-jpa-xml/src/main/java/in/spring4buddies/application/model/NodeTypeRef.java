package in.spring4buddies.application.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the NODE_TYPE_REF database table.
 * 
 */
@Entity
@Table(name="NODE_TYPE_REF")
@NamedQuery(name="NodeTypeRef.findAll", query="SELECT n FROM NodeTypeRef n")
public class NodeTypeRef implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="NODE_TYPE_ID")
	private String nodeTypeId;

	private String description;

	//bi-directional many-to-one association to NodeRef
	@OneToMany(mappedBy="nodeTypeRef")
	private List<NodeRef> nodeRefs;

	public NodeTypeRef() {
	}

	public String getNodeTypeId() {
		return this.nodeTypeId;
	}

	public void setNodeTypeId(String nodeTypeId) {
		this.nodeTypeId = nodeTypeId;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<NodeRef> getNodeRefs() {
		return this.nodeRefs;
	}

	public void setNodeRefs(List<NodeRef> nodeRefs) {
		this.nodeRefs = nodeRefs;
	}

	public NodeRef addNodeRef(NodeRef nodeRef) {
		getNodeRefs().add(nodeRef);
		nodeRef.setNodeTypeRef(this);

		return nodeRef;
	}

	public NodeRef removeNodeRef(NodeRef nodeRef) {
		getNodeRefs().remove(nodeRef);
		nodeRef.setNodeTypeRef(null);

		return nodeRef;
	}

}