package in.spring4buddies.application.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the ADDRESS_REF database table.
 * 
 */
@Entity
@Table(name="ADDRESS_REF")
@NamedQuery(name="AddressRef.findAll", query="SELECT a FROM AddressRef a")
public class AddressRef implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ADDRESS_ID")
	private long addressId;

	@Column(name="ADDRESS_CITY")
	private String addressCity;

	@Column(name="ADDRESS_EMAIL")
	private String addressEmail;

	@Column(name="ADDRESS_LINE1")
	private String addressLine1;

	@Column(name="ADDRESS_LINE2")
	private String addressLine2;

	@Column(name="ADDRESS_LINE3")
	private String addressLine3;

	@Column(name="ADDRESS_LINE4")
	private String addressLine4;

	@Column(name="ADDRESS_PHONE")
	private String addressPhone;

	@Column(name="COUNTRY_CODE")
	private String countryCode;

	@Column(name="MAIN_DIVISION_CODE")
	private String mainDivisionCode;

	@Column(name="POSTAL_CODE")
	private String postalCode;

	//bi-directional many-to-one association to NodeRef
	@OneToMany(mappedBy="addressRef")
	private List<NodeRef> nodeRefs;

	public AddressRef() {
	}

	public long getAddressId() {
		return this.addressId;
	}

	public void setAddressId(long addressId) {
		this.addressId = addressId;
	}

	public String getAddressCity() {
		return this.addressCity;
	}

	public void setAddressCity(String addressCity) {
		this.addressCity = addressCity;
	}

	public String getAddressEmail() {
		return this.addressEmail;
	}

	public void setAddressEmail(String addressEmail) {
		this.addressEmail = addressEmail;
	}

	public String getAddressLine1() {
		return this.addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return this.addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getAddressLine3() {
		return this.addressLine3;
	}

	public void setAddressLine3(String addressLine3) {
		this.addressLine3 = addressLine3;
	}

	public String getAddressLine4() {
		return this.addressLine4;
	}

	public void setAddressLine4(String addressLine4) {
		this.addressLine4 = addressLine4;
	}

	public String getAddressPhone() {
		return this.addressPhone;
	}

	public void setAddressPhone(String addressPhone) {
		this.addressPhone = addressPhone;
	}

	public String getCountryCode() {
		return this.countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getMainDivisionCode() {
		return this.mainDivisionCode;
	}

	public void setMainDivisionCode(String mainDivisionCode) {
		this.mainDivisionCode = mainDivisionCode;
	}

	public String getPostalCode() {
		return this.postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public List<NodeRef> getNodeRefs() {
		return this.nodeRefs;
	}

	public void setNodeRefs(List<NodeRef> nodeRefs) {
		this.nodeRefs = nodeRefs;
	}

	public NodeRef addNodeRef(NodeRef nodeRef) {
		getNodeRefs().add(nodeRef);
		nodeRef.setAddressRef(this);

		return nodeRef;
	}

	public NodeRef removeNodeRef(NodeRef nodeRef) {
		getNodeRefs().remove(nodeRef);
		nodeRef.setAddressRef(null);

		return nodeRef;
	}

}