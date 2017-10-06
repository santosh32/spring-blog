package in.spring4buddies.application.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the CALENDAR_EXCEPTION_REF database table.
 * 
 */
@Embeddable
public class CalendarExceptionRefPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="INVENTORY_ORGANIZATION_ID", insertable=false, updatable=false)
	private String inventoryOrganizationId;

	@Column(name="CALENDAR_EXCEPTION_ID")
	private long calendarExceptionId;

	public CalendarExceptionRefPK() {
	}
	public String getInventoryOrganizationId() {
		return this.inventoryOrganizationId;
	}
	public void setInventoryOrganizationId(String inventoryOrganizationId) {
		this.inventoryOrganizationId = inventoryOrganizationId;
	}
	public long getCalendarExceptionId() {
		return this.calendarExceptionId;
	}
	public void setCalendarExceptionId(long calendarExceptionId) {
		this.calendarExceptionId = calendarExceptionId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof CalendarExceptionRefPK)) {
			return false;
		}
		CalendarExceptionRefPK castOther = (CalendarExceptionRefPK)other;
		return 
			this.inventoryOrganizationId.equals(castOther.inventoryOrganizationId)
			&& (this.calendarExceptionId == castOther.calendarExceptionId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.inventoryOrganizationId.hashCode();
		hash = hash * prime + ((int) (this.calendarExceptionId ^ (this.calendarExceptionId >>> 32)));
		
		return hash;
	}
}