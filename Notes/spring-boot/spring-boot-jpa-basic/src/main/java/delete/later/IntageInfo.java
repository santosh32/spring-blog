package delete.later;

import javax.xml.datatype.XMLGregorianCalendar;

public class IntageInfo {

	public XMLGregorianCalendar getActualStart() {
		return actualStart;
	}

	public void setActualStart(XMLGregorianCalendar actualStart) {
		this.actualStart = actualStart;
	}

	public XMLGregorianCalendar getActualEnd() {
		return actualEnd;
	}

	public void setActualEnd(XMLGregorianCalendar actualEnd) {
		this.actualEnd = actualEnd;
	}

	public XMLGregorianCalendar getPlannedStart() {
		return plannedStart;
	}

	public void setPlannedStart(XMLGregorianCalendar plannedStart) {
		this.plannedStart = plannedStart;
	}

	public XMLGregorianCalendar getPlannedEnd() {
		return plannedEnd;
	}

	public void setPlannedEnd(XMLGregorianCalendar plannedEnd) {
		this.plannedEnd = plannedEnd;
	}

	private XMLGregorianCalendar actualStart;

	private XMLGregorianCalendar actualEnd;

	private XMLGregorianCalendar plannedStart;

	private XMLGregorianCalendar plannedEnd;

}
