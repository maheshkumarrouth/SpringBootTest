package de.atcs.validations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import de.atcs.beans.AircraftData;
import de.atcs.jpa.manager.AirTrafficControlManager;

@Component
public class ValidationServiceImpl implements ValidationService{
	
	@Autowired
	private AirTrafficControlManager airTrafficControlManager;
	
	public AircraftData fetchAllAcDetails(){
		return airTrafficControlManager.fetchAllAcDetails();
	}
}
