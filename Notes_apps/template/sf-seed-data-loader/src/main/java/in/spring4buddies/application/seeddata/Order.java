package in.spring4buddies.application.seeddata;

public class Order {

	private int orderId;
	private String stockId;
	private String length;
	private String fabCharges;
	private String shipTo;
	private String orderDate;
	private String shipped;
	private String takenBy;
	private String proccessdBy;
	private String specinstr;

	public Order() {

	}

	public Order(int orderId, String stockId, String length, String fabCharges, String shipTo, String orderDate, String shipped, String takenBy,
			String proccessdBy, String specinstr) {
		super();
		this.orderId = orderId;
		this.stockId = stockId;
		this.length = length;
		this.fabCharges = fabCharges;
		this.shipTo = shipTo;
		this.orderDate = orderDate;
		this.shipped = shipped;
		this.takenBy = takenBy;
		this.proccessdBy = proccessdBy;
		this.specinstr = specinstr;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getStockId() {
		return stockId;
	}

	public void setStockId(String stockId) {
		this.stockId = stockId;
	}

	public String getLength() {
		return length;
	}

	public void setLength(String length) {
		this.length = length;
	}

	public String getFabCharges() {
		return fabCharges;
	}

	public void setFabCharges(String fabCharges) {
		this.fabCharges = fabCharges;
	}

	public String getShipTo() {
		return shipTo;
	}

	public void setShipTo(String shipTo) {
		this.shipTo = shipTo;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public String getShipped() {
		return shipped;
	}

	public void setShipped(String shipped) {
		this.shipped = shipped;
	}

	public String getTakenBy() {
		return takenBy;
	}

	public void setTakenBy(String takenBy) {
		this.takenBy = takenBy;
	}

	public String getProccessdBy() {
		return proccessdBy;
	}

	public void setProccessdBy(String proccessdBy) {
		this.proccessdBy = proccessdBy;
	}

	public String getSpecinstr() {
		return specinstr;
	}

	public void setSpecinstr(String specinstr) {
		this.specinstr = specinstr;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", stockId=" + stockId + ", length=" + length + ", fabCharges=" + fabCharges + ", shipTo=" + shipTo
				+ ", orderDate=" + orderDate + ", shipped=" + shipped + ", takenBy=" + takenBy + ", proccessdBy=" + proccessdBy + ", specinstr="
				+ specinstr + "]";
	}
}