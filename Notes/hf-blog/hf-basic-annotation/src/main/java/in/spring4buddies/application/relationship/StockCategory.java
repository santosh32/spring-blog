package in.spring4buddies.application.relationship;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "category")
public class StockCategory implements java.io.Serializable {

	private static final long serialVersionUID = 4566414601663347635L;

	@Id
	@SequenceGenerator(name = "seq", sequenceName = "stock_ctgy_seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
	@Column(name = "CATEGORY_ID", unique = true, nullable = false)
	private Integer categoryId;

	@Column(name = "NAME", nullable = false, length = 10)
	private String name;

	@Column(name = "DESC", nullable = false)
	private String desc;

	@ManyToMany(fetch = FetchType.LAZY)
	private Set<Stock> stocks = new HashSet<Stock>(0);

	public StockCategory() {
	}

	public StockCategory(String name, String desc) {
		this.name = name;
		this.desc = desc;
	}

	public StockCategory(String name, String desc, Set<Stock> stocks) {
		this.name = name;
		this.desc = desc;
		this.stocks = stocks;
	}

	public Integer getCategoryId() {
		return this.categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return this.desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public Set<Stock> getStocks() {
		return this.stocks;
	}

	public void setStocks(Set<Stock> stocks) {
		this.stocks = stocks;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((categoryId == null) ? 0 : categoryId.hashCode());
		result = prime * result + ((desc == null) ? 0 : desc.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		StockCategory other = (StockCategory) obj;
		if (categoryId == null) {
			if (other.categoryId != null)
				return false;
		} else if (!categoryId.equals(other.categoryId))
			return false;
		if (desc == null) {
			if (other.desc != null)
				return false;
		} else if (!desc.equals(other.desc))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "StockCategory [categoryId=" + categoryId + ", name=" + name
				+ ", desc=" + desc + "]";
	}
}