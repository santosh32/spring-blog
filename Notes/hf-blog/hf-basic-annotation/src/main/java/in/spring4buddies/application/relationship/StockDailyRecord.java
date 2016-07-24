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
@Table(name = "stock_daily_record"/*
								 * , uniqueConstraints =
								 * 
								 * @UniqueConstraint(columnNames = "DATE")
								 */)
public class StockDailyRecord implements java.io.Serializable {

	private static final long serialVersionUID = 4829459366784450976L;

	@Id
	@SequenceGenerator(name = "seq", sequenceName = "stock_dly_rec_seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
	@Column(name = "RECORD_ID",/* unique = true,*/ nullable = false)
	private Integer recordId;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "STOCK_ID"/*, nullable = false*/)
	private Stock stock;

	@Column(name = "PRICE_OPEN", precision = 6)
	private Float priceOpen;

	@Column(name = "PRICE_CLOSE", precision = 6)
	private Float priceClose;

	@Column(name = "PRICE_CHANGE", precision = 6)
	private Float priceChange;

	@Column(name = "VOLUME")
	private Long volume;

	@Temporal(TemporalType.DATE)
	@Column(name = "CREATED_DATE"/*, unique = true*/, nullable = false, length = 10)
	private Date createdDate;

	public StockDailyRecord() {
	}

	public Integer getRecordId() {
		return recordId;
	}

	public Stock getStock() {
		return stock;
	}

	public void setStock(Stock stock) {
		this.stock = stock;
	}

	public void setRecordId(Integer recordId) {
		this.recordId = recordId;
	}

	public Float getPriceOpen() {
		return priceOpen;
	}

	public void setPriceOpen(Float priceOpen) {
		this.priceOpen = priceOpen;
	}

	public Float getPriceClose() {
		return priceClose;
	}

	public void setPriceClose(Float priceClose) {
		this.priceClose = priceClose;
	}

	public Float getPriceChange() {
		return priceChange;
	}

	public void setPriceChange(Float priceChange) {
		this.priceChange = priceChange;
	}

	public Long getVolume() {
		return volume;
	}

	public void setVolume(Long volume) {
		this.volume = volume;
	}

	public Date getDate() {
		return createdDate;
	}

	public void setDate(Date date) {
		this.createdDate = date;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((createdDate == null) ? 0 : createdDate.hashCode());
		result = prime * result
				+ ((priceChange == null) ? 0 : priceChange.hashCode());
		result = prime * result
				+ ((priceClose == null) ? 0 : priceClose.hashCode());
		result = prime * result
				+ ((priceOpen == null) ? 0 : priceOpen.hashCode());
		result = prime * result
				+ ((recordId == null) ? 0 : recordId.hashCode());
		result = prime * result + ((volume == null) ? 0 : volume.hashCode());
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
		StockDailyRecord other = (StockDailyRecord) obj;
		if (createdDate == null) {
			if (other.createdDate != null)
				return false;
		} else if (!createdDate.equals(other.createdDate))
			return false;
		if (priceChange == null) {
			if (other.priceChange != null)
				return false;
		} else if (!priceChange.equals(other.priceChange))
			return false;
		if (priceClose == null) {
			if (other.priceClose != null)
				return false;
		} else if (!priceClose.equals(other.priceClose))
			return false;
		if (priceOpen == null) {
			if (other.priceOpen != null)
				return false;
		} else if (!priceOpen.equals(other.priceOpen))
			return false;
		if (recordId == null) {
			if (other.recordId != null)
				return false;
		} else if (!recordId.equals(other.recordId))
			return false;
		if (volume == null) {
			if (other.volume != null)
				return false;
		} else if (!volume.equals(other.volume))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "StockDailyRecord [recordId=" + recordId + ", priceOpen="
				+ priceOpen + ", priceClose=" + priceClose + ", priceChange="
				+ priceChange + ", volume=" + volume + ", date=" + createdDate + "]";
	}
}