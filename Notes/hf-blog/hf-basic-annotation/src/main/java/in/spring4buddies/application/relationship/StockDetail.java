package in.spring4buddies.application.relationship;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "stock_detail")
public class StockDetail implements java.io.Serializable {

	private static final long serialVersionUID = -6815273231922798851L;

	// @GenericGenerator(name = "generator", strategy = "foreign", parameters =
	// @Parameter(name = "property", value = "stock"))
	@Id
	// @GeneratedValue(generator = "generator")
	@SequenceGenerator(name = "seq", sequenceName = "stock_dtl_seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
	@Column(name = "STOCK_DTL_ID", unique = true, nullable = false)
	private Integer StockDetailId;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	// @PrimaryKeyJoinColumn
	@JoinColumn(name = "STOCK_ID", nullable = false)
	private Stock stock;

	@Column(name = "COMP_NAME", nullable = false, length = 100)
	private String compName;

	@Column(name = "COMP_DESC", nullable = false)
	private String compDesc;

	@Column(name = "REMARK", nullable = false)
	private String remark;

	@Temporal(TemporalType.DATE)
	@Column(name = "LISTED_DATE", nullable = false, length = 10)
	private Date listedDate;

	public StockDetail() {
	}

	public StockDetail(Stock stock, String compName, String compDesc,
			String remark, Date listedDate) {
		this.stock = stock;
		this.compName = compName;
		this.compDesc = compDesc;
		this.remark = remark;
		this.listedDate = listedDate;
	}

	public Integer getStockDetailId() {
		return StockDetailId;
	}

	public void setStockDetailId(Integer stockDetailId) {
		StockDetailId = stockDetailId;
	}

	public Stock getStock() {
		return this.stock;
	}

	public void setStock(Stock stock) {
		this.stock = stock;
	}

	public String getCompName() {
		return this.compName;
	}

	public void setCompName(String compName) {
		this.compName = compName;
	}

	public String getCompDesc() {
		return this.compDesc;
	}

	public void setCompDesc(String compDesc) {
		this.compDesc = compDesc;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Date getListedDate() {
		return this.listedDate;
	}

	public void setListedDate(Date listedDate) {
		this.listedDate = listedDate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((StockDetailId == null) ? 0 : StockDetailId.hashCode());
		result = prime * result
				+ ((compDesc == null) ? 0 : compDesc.hashCode());
		result = prime * result
				+ ((compName == null) ? 0 : compName.hashCode());
		result = prime * result
				+ ((listedDate == null) ? 0 : listedDate.hashCode());
		result = prime * result + ((remark == null) ? 0 : remark.hashCode());
		result = prime * result + ((stock == null) ? 0 : stock.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StockDetail other = (StockDetail) obj;
		if (StockDetailId == null) {
			if (other.StockDetailId != null)
				return false;
		} else if (!StockDetailId.equals(other.StockDetailId))
			return false;
		if (compDesc == null) {
			if (other.compDesc != null)
				return false;
		} else if (!compDesc.equals(other.compDesc))
			return false;
		if (compName == null) {
			if (other.compName != null)
				return false;
		} else if (!compName.equals(other.compName))
			return false;
		if (listedDate == null) {
			if (other.listedDate != null)
				return false;
		} else if (!listedDate.equals(other.listedDate))
			return false;
		if (remark == null) {
			if (other.remark != null)
				return false;
		} else if (!remark.equals(other.remark))
			return false;
		if (stock == null) {
			if (other.stock != null)
				return false;
		} else if (!stock.equals(other.stock))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "StockDetail [StockDetailId=" + StockDetailId 
				 + ", compName=" + compName + ", compDesc=" + compDesc
				+ ", remark=" + remark + ", listedDate=" + listedDate + "]";
	}

}