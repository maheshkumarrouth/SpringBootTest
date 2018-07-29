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
	private PriorityQueueManager priorityQueueManager;
	
	@Autowired
	private AircraftXCheckInManager aircraftXCheckInManager;
	
	public AircraftData fetchAllAcDetails(){
		List<Aircraft> airCraptList = priorityQueueManager.fetchAllAcDetails();
		AircraftData aircraftData = new AircraftData();
		aircraftData.setAircraftData(airCraptList);
		return aircraftData;
	}
	
	public void enQueueAc(Aircraft aircraft) {
		AircraftXCheckIn aircraftChekIn = aircraftXCheckInManager.save(aircraft);
		priorityQueueManager.getAcQueue().add(aircraftChekIn);
	}
	
	public boolean isSystemBooted() {
		return priorityQueueManager.isSystemBooted();
	}

	@Override
	public void bootTheApplication() {
		priorityQueueManager.bootTheApplication();
	}
}
