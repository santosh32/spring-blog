package in.spring4buddies.application.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the SHIFT_REF database table.
 * 
 */
@Entity
@Table(name="SHIFT_REF")
@NamedQuery(name="ShiftRef.findAll", query="SELECT s FROM ShiftRef s")
public class ShiftRef implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="SHIFT_ID")
	private long shiftId;

	@Column(name="END_TIME")
	private String endTime;

	@Column(name="MAX_ITEMS")
	private BigDecimal maxItems;

	@Column(name="START_TIME")
	private String startTime;

	//bi-directional many-to-one association to DayRef
	@ManyToOne
	@JoinColumn(name="DAY_ID")
	private DayRef dayRef;

	public ShiftRef() {
	}

	public long getShiftId() {
		return this.shiftId;
	}

	public void setShiftId(long shiftId) {
		this.shiftId = shiftId;
	}

	public String getEndTime() {
		return this.endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public BigDecimal getMaxItems() {
		return this.maxItems;
	}

	public void setMaxItems(BigDecimal maxItems) {
		this.maxItems = maxItems;
	}

	public String getStartTime() {
		return this.startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public DayRef getDayRef() {
		return this.dayRef;
	}

	public void setDayRef(DayRef dayRef) {
		this.dayRef = dayRef;
	}

}