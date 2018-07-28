package de.atcs.validations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import de.atcs.beans.AircraftData;
import de.atcs.exception.AirTrafficControlException;
import de.atcs.jpa.manager.AirTrafficControlManager;

@Component
public class ValidationServiceImpl implements ValidationService{
	
	@Autowired
	private AirTrafficControlManager airTrafficControlManager;
	
	public boolean isSystemBooted() {
		return airTrafficControlManager.isSystemBooted();
	}
	
	public AircraftData fetchAllAcDetails(){
		if(this.isSystemBooted())
			return airTrafficControlManager.fetchAllAcDetails();
		throw new AirTrafficControlException("System not yet started",HttpStatus.SERVICE_UNAVAILABLE);
	}
	
	public void bootTheApplication() {
		airTrafficControlManager.bootTheApplication();
	}
	
}
