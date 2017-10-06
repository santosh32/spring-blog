package in.spring4buddies.application.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the DAY_OF_WEEK_REF database table.
 * 
 */
@Embeddable
public class DayOfWeekRefPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="INVENTORY_ORGANIZATION_ID", insertable=false, updatable=false)
	private String inventoryOrganizationId;

	@Column(name="CALENDAR_ID", insertable=false, updatable=false)
	private String calendarId;

	@Column(name="DAY_ID", insertable=false, updatable=false)
	private long dayId;

	public DayOfWeekRefPK() {
	}
	public String getInventoryOrganizationId() {
		return this.inventoryOrganizationId;
	}
	public void setInventoryOrganizationId(String inventoryOrganizationId) {
		this.inventoryOrganizationId = inventoryOrganizationId;
	}
	public String getCalendarId() {
		return this.calendarId;
	}
	public void setCalendarId(String calendarId) {
		this.calendarId = calendarId;
	}
	public long getDayId() {
		return this.dayId;
	}
	public void setDayId(long dayId) {
		this.dayId = dayId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof DayOfWeekRefPK)) {
			return false;
		}
		DayOfWeekRefPK castOther = (DayOfWeekRefPK)other;
		return 
			this.inventoryOrganizationId.equals(castOther.inventoryOrganizationId)
			&& this.calendarId.equals(castOther.calendarId)
			&& (this.dayId == castOther.dayId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.inventoryOrganizationId.hashCode();
		hash = hash * prime + this.calendarId.hashCode();
		hash = hash * prime + ((int) (this.dayId ^ (this.dayId >>> 32)));
		
		return hash;
	}
}