package in.spring4buddies.application.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the FULFILLMENT_TYPE_REF database table.
 * 
 */
@Entity
@Table(name="FULFILLMENT_TYPE_REF")
@NamedQuery(name="FulfillmentTypeRef.findAll", query="SELECT f FROM FulfillmentTypeRef f")
public class FulfillmentTypeRef implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="FULFILLMENT_TYPE_ID")
	private String fulfillmentTypeId;

	private String description;

	//bi-directional many-to-one association to NodeFulfillmentTypeMap
	@OneToMany(mappedBy="fulfillmentTypeRef")
	private List<NodeFulfillmentTypeMap> nodeFulfillmentTypeMaps;

	//bi-directional many-to-one association to StoreRef
	@OneToMany(mappedBy="fulfillmentTypeRef")
	private List<StoreRef> storeRefs;

	public FulfillmentTypeRef() {
	}

	public String getFulfillmentTypeId() {
		return this.fulfillmentTypeId;
	}

	public void setFulfillmentTypeId(String fulfillmentTypeId) {
		this.fulfillmentTypeId = fulfillmentTypeId;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<NodeFulfillmentTypeMap> getNodeFulfillmentTypeMaps() {
		return this.nodeFulfillmentTypeMaps;
	}

	public void setNodeFulfillmentTypeMaps(List<NodeFulfillmentTypeMap> nodeFulfillmentTypeMaps) {
		this.nodeFulfillmentTypeMaps = nodeFulfillmentTypeMaps;
	}

	public NodeFulfillmentTypeMap addNodeFulfillmentTypeMap(NodeFulfillmentTypeMap nodeFulfillmentTypeMap) {
		getNodeFulfillmentTypeMaps().add(nodeFulfillmentTypeMap);
		nodeFulfillmentTypeMap.setFulfillmentTypeRef(this);

		return nodeFulfillmentTypeMap;
	}

	public NodeFulfillmentTypeMap removeNodeFulfillmentTypeMap(NodeFulfillmentTypeMap nodeFulfillmentTypeMap) {
		getNodeFulfillmentTypeMaps().remove(nodeFulfillmentTypeMap);
		nodeFulfillmentTypeMap.setFulfillmentTypeRef(null);

		return nodeFulfillmentTypeMap;
	}

	public List<StoreRef> getStoreRefs() {
		return this.storeRefs;
	}

	public void setStoreRefs(List<StoreRef> storeRefs) {
		this.storeRefs = storeRefs;
	}

	public StoreRef addStoreRef(StoreRef storeRef) {
		getStoreRefs().add(storeRef);
		storeRef.setFulfillmentTypeRef(this);

		return storeRef;
	}

	public StoreRef removeStoreRef(StoreRef storeRef) {
		getStoreRefs().remove(storeRef);
		storeRef.setFulfillmentTypeRef(null);

		return storeRef;
	}

}