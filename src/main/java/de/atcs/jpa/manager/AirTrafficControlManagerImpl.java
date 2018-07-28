package de.atcs.jpa.manager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import de.atcs.beans.Aircraft;
import de.atcs.beans.AircraftData;
import de.atcs.jpa.manager.atcs.AircraftXCheckInManager;
import de.atcs.jpa.manager.utility.PriorityQueueManager;
import de.atcs.model.AircraftXCheckIn;

@Component
public class AirTrafficControlManagerImpl implements AirTrafficControlManager{
	
	@Autowired
	private AircraftXCheckInManager aircraftXCheckInManager;
	
	@Autowired
	private PriorityQueueManager priorityQueueManager;
	
	public AircraftData fetchAllAcDetails(){
		List<AircraftXCheckIn> aircraftXCheckIns = aircraftXCheckInManager.fetchAllAcDetails();
		List<Aircraft> airCraptList = priorityQueueManager.fetchAllAcDetails(aircraftXCheckIns);
		AircraftData aircraftData = new AircraftData();
		aircraftData.setAircraftData(airCraptList);
		return aircraftData;
	}
}
