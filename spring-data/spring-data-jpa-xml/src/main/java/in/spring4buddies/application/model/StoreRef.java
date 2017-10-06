package in.spring4buddies.application.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the STORE_REF database table.
 * 
 */
@Entity
@Table(name="STORE_REF")
@NamedQuery(name="StoreRef.findAll", query="SELECT s FROM StoreRef s")
public class StoreRef implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="STORE_ID")
	private String storeId;

	@Column(name="CLIENT_ID")
	private String clientId;

	@Column(name="DEFAULT_LATEST_SHIP_DATE_DAYS")
	private BigDecimal defaultLatestShipDateDays;

	@Column(name="STORE_NAME")
	private String storeName;

	//bi-directional many-to-one association to FulfillmentTypeRef
	@ManyToOne
	@JoinColumn(name="DEFAULT_FULFILLMENT_TYPE_ID")
	private FulfillmentTypeRef fulfillmentTypeRef;

	//bi-directional many-to-one association to InventoryOrganizationRef
	@ManyToOne
	@JoinColumn(name="INVENTORY_ORGANIZATION_ID")
	private InventoryOrganizationRef inventoryOrganizationRef;

	public StoreRef() {
	}

	public String getStoreId() {
		return this.storeId;
	}

	public void setStoreId(String storeId) {
		this.storeId = storeId;
	}

	public String getClientId() {
		return this.clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public BigDecimal getDefaultLatestShipDateDays() {
		return this.defaultLatestShipDateDays;
	}

	public void setDefaultLatestShipDateDays(BigDecimal defaultLatestShipDateDays) {
		this.defaultLatestShipDateDays = defaultLatestShipDateDays;
	}

	public String getStoreName() {
		return this.storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
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

}