package in.spring4buddies.application.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the UNIT_OF_MEASURE_REF database table.
 * 
 */
@Entity
@Table(name="UNIT_OF_MEASURE_REF")
@NamedQuery(name="UnitOfMeasureRef.findAll", query="SELECT u FROM UnitOfMeasureRef u")
public class UnitOfMeasureRef implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="UNIT_OF_MEASURE_ID")
	private String unitOfMeasureId;

	private String description;

	@Column(name="UNIT_OF_MEASURE_TYPE")
	private String unitOfMeasureType;

	//bi-directional many-to-one association to InventoryOrganizationRef
	@OneToMany(mappedBy="unitOfMeasureRef")
	private List<InventoryOrganizationRef> inventoryOrganizationRefs;

	public UnitOfMeasureRef() {
	}

	public String getUnitOfMeasureId() {
		return this.unitOfMeasureId;
	}

	public void setUnitOfMeasureId(String unitOfMeasureId) {
		this.unitOfMeasureId = unitOfMeasureId;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getUnitOfMeasureType() {
		return this.unitOfMeasureType;
	}

	public void setUnitOfMeasureType(String unitOfMeasureType) {
		this.unitOfMeasureType = unitOfMeasureType;
	}

	public List<InventoryOrganizationRef> getInventoryOrganizationRefs() {
		return this.inventoryOrganizationRefs;
	}

	public void setInventoryOrganizationRefs(List<InventoryOrganizationRef> inventoryOrganizationRefs) {
		this.inventoryOrganizationRefs = inventoryOrganizationRefs;
	}

	public InventoryOrganizationRef addInventoryOrganizationRef(InventoryOrganizationRef inventoryOrganizationRef) {
		getInventoryOrganizationRefs().add(inventoryOrganizationRef);
		inventoryOrganizationRef.setUnitOfMeasureRef(this);

		return inventoryOrganizationRef;
	}

	public InventoryOrganizationRef removeInventoryOrganizationRef(InventoryOrganizationRef inventoryOrganizationRef) {
		getInventoryOrganizationRefs().remove(inventoryOrganizationRef);
		inventoryOrganizationRef.setUnitOfMeasureRef(null);

		return inventoryOrganizationRef;
	}

}