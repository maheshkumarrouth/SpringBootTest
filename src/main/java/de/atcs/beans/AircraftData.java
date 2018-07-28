package de.atcs.beans;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_EMPTY)
public class AircraftData {
	
	private List<Aircraft> aircraftData = new ArrayList<>();

	public List<Aircraft> getAircraftData() {
		return aircraftData;
	}

	public void setAircraftData(List<Aircraft> aircraftData) {
		this.aircraftData = aircraftData;
	}

	
	
}
