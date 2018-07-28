package de.atcs.beans;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import de.atcs.model.AircraftXCheckIn;

@JsonInclude(Include.NON_EMPTY)
public class Aircraft{
	
	private String acId;
	
	private String size;
	
	private String type;
	
	private Date checkIn;

	public String getAcId() {
		return acId;
	}

	public void setAcId(String acId) {
		this.acId = acId;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Date getCheckIn() {
		return checkIn;
	}

	public void setCheckIn(Date checkIn) {
		this.checkIn = checkIn;
	}

	@Override
	public String toString() {
		return "Aircraft [acId=" + acId + ", size=" + size + ", type=" + type + ", checkIn=" + checkIn + "]";
	}
	
	
	
}
