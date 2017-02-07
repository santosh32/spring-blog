package in.spring4buddies.application.model;

public class Invoice {

	private int invoiceId;
	private String billedTo;
	private String amtBilled;
	private String country;
	private String amtInUS;
	private String billedBy;
	private String billedOn;
	private String paidOn;

	public Invoice() {

	}

	public Invoice(int invoiceId, String billedTo, String amtBilled, String country, String amtInUS, String billedBy, String billedOn, String paidOn) {
		super();
		this.invoiceId = invoiceId;
		this.billedTo = billedTo;
		this.amtBilled = amtBilled;
		this.country = country;
		this.amtInUS = amtInUS;
		this.billedBy = billedBy;
		this.billedOn = billedOn;
		this.paidOn = paidOn;
	}

	public int getInvoiceId() {
		return invoiceId;
	}

	public void setInvoiceId(int invoiceId) {
		this.invoiceId = invoiceId;
	}

	public String getBilledTo() {
		return billedTo;
	}

	public void setBilledTo(String billedTo) {
		this.billedTo = billedTo;
	}

	public String getAmtBilled() {
		return amtBilled;
	}

	public void setAmtBilled(String amtBilled) {
		this.amtBilled = amtBilled;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getAmtInUS() {
		return amtInUS;
	}

	public void setAmtInUS(String amtInUS) {
		this.amtInUS = amtInUS;
	}

	public String getBilledBy() {
		return billedBy;
	}

	public void setBilledBy(String billedBy) {
		this.billedBy = billedBy;
	}

	public String getBilledOn() {
		return billedOn;
	}

	public void setBilledOn(String billedOn) {
		this.billedOn = billedOn;
	}

	public String getPaidOn() {
		return paidOn;
	}

	public void setPaidOn(String paidOn) {
		this.paidOn = paidOn;
	}

	@Override
	public String toString() {
		return "Invoice [invoiceId=" + invoiceId + ", billedTo=" + billedTo + ", amtBilled=" + amtBilled + ", country=" + country + ", amtInUS="
				+ amtInUS + ", billedBy=" + billedBy + ", billedOn=" + billedOn + ", paidOn=" + paidOn + "]";
	}

}