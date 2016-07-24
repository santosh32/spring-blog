package in.spring4buddies.application.relationship;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "stock"/*
					 * , uniqueConstraints = {
					 * 
					 * @UniqueConstraint(columnNames = "STOCK_NAME"),
					 * 
					 * @UniqueConstraint(columnNames = "STOCK_CODE") }
					 */)
public class Stock implements java.io.Serializable {

	private static final long serialVersionUID = -7073504126526691065L;

	@Id
	@SequenceGenerator(name = "seq", sequenceName = "stock_seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
	@Column(name = "STOCK_ID", unique = true, nullable = false)
	private Integer stockId;

	@Column(name = "STOCK_CODE", /* unique = true, */nullable = false, length = 10)
	private String stockCode;

	@Column(name = "STOCK_NAME", /* unique = true, */nullable = false, length = 20)
	private String stockName;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "stock", cascade = CascadeType.ALL)
	private Set<StockDetail> stockDetail = new HashSet<StockDetail>();

	public Stock() {
	}

	public Stock(String stockCode, String stockName) {
		this.stockCode = stockCode;
		this.stockName = stockName;
	}

	public Stock(String stockCode, String stockName,
			Set<StockDetail> stockDetail) {
		this.stockCode = stockCode;
		this.stockName = stockName;
		this.stockDetail = stockDetail;
	}

	public Integer getStockId() {
		return this.stockId;
	}

	public void setStockId(Integer stockId) {
		this.stockId = stockId;
	}

	public String getStockCode() {
		return this.stockCode;
	}

	public void setStockCode(String stockCode) {
		this.stockCode = stockCode;
	}

	public String getStockName() {
		return this.stockName;
	}

	public void setStockName(String stockName) {
		this.stockName = stockName;
	}

	public Set<StockDetail> getStockDetail() {
		return this.stockDetail;
	}

	public void setStockDetail(Set<StockDetail> stockDetail) {
		this.stockDetail = stockDetail;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((stockCode == null) ? 0 : stockCode.hashCode());
		result = prime * result + ((stockId == null) ? 0 : stockId.hashCode());
		result = prime * result
				+ ((stockName == null) ? 0 : stockName.hashCode());
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
		Stock other = (Stock) obj;
		if (stockCode == null) {
			if (other.stockCode != null)
				return false;
		} else if (!stockCode.equals(other.stockCode))
			return false;
		if (stockId == null) {
			if (other.stockId != null)
				return false;
		} else if (!stockId.equals(other.stockId))
			return false;
		if (stockName == null) {
			if (other.stockName != null)
				return false;
		} else if (!stockName.equals(other.stockName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Stock = [stockId=" + stockId + ", stockCode=" + stockCode
				+ ", stockName=" + stockName + "]";
	}

}