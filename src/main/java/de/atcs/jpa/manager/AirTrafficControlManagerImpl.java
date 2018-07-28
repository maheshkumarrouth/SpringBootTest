package de.atcs.jpa.manager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import de.atcs.beans.Aircraft;
import de.atcs.beans.AircraftData;
import de.atcs.jpa.manager.utility.PriorityQueueManager;

@Component
public class AirTrafficControlManagerImpl implements AirTrafficControlManager{
	
	@Autowired
	private PriorityQueueManager priorityQueueManager;
	
	public AircraftData fetchAllAcDetails(){
		List<Aircraft> airCraptList = priorityQueueManager.fetchAllAcDetails();
		AircraftData aircraftData = new AircraftData();
		aircraftData.setAircraftData(airCraptList);
		return aircraftData;
	}
	
	public boolean isSystemBooted() {
		return priorityQueueManager.isSystemBooted();
	}

	@Override
	public void bootTheApplication() {
		priorityQueueManager.bootTheApplication();
	}
}
