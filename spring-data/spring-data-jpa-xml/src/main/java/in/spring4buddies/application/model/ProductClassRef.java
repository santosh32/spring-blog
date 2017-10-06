package in.spring4buddies.application.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the PRODUCT_CLASS_REF database table.
 * 
 */
@Entity
@Table(name="PRODUCT_CLASS_REF")
@NamedQuery(name="ProductClassRef.findAll", query="SELECT p FROM ProductClassRef p")
public class ProductClassRef implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="PRODUCT_CLASS_ID")
	private String productClassId;

	private String description;

	//bi-directional many-to-one association to InventoryOrganizationRef
	@OneToMany(mappedBy="productClassRef")
	private List<InventoryOrganizationRef> inventoryOrganizationRefs;

	public ProductClassRef() {
	}

	public String getProductClassId() {
		return this.productClassId;
	}

	public void setProductClassId(String productClassId) {
		this.productClassId = productClassId;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<InventoryOrganizationRef> getInventoryOrganizationRefs() {
		return this.inventoryOrganizationRefs;
	}

	public void setInventoryOrganizationRefs(List<InventoryOrganizationRef> inventoryOrganizationRefs) {
		this.inventoryOrganizationRefs = inventoryOrganizationRefs;
	}

	public InventoryOrganizationRef addInventoryOrganizationRef(InventoryOrganizationRef inventoryOrganizationRef) {
		getInventoryOrganizationRefs().add(inventoryOrganizationRef);
		inventoryOrganizationRef.setProductClassRef(this);

		return inventoryOrganizationRef;
	}

	public InventoryOrganizationRef removeInventoryOrganizationRef(InventoryOrganizationRef inventoryOrganizationRef) {
		getInventoryOrganizationRefs().remove(inventoryOrganizationRef);
		inventoryOrganizationRef.setProductClassRef(null);

		return inventoryOrganizationRef;
	}

}