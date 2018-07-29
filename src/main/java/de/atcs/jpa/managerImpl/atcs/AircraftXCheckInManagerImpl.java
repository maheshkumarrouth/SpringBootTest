package de.atcs.jpa.managerImpl.atcs;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import de.atcs.beans.Aircraft;
import de.atcs.jpa.atcs.AircraftXCheckInRepository;
import de.atcs.jpa.manager.atcs.AircraftXCheckInManager;
import de.atcs.jpa.manager.utility.PriorityQueueManager;
import de.atcs.model.AircraftXCheckIn;

@Component
public class AircraftXCheckInManagerImpl implements AircraftXCheckInManager{
	
	@Autowired
	private AircraftXCheckInRepository aircraftXCheckInRepository;
	
	@Autowired
	private PriorityQueueManager priorityQueueManager;
	
	public List<AircraftXCheckIn> fetchAllAcDetails(){
		return aircraftXCheckInRepository.findAll();
	}
	
	public AircraftXCheckIn save(Aircraft aircraft) {
		AircraftXCheckIn aircraftXCheckIn = new AircraftXCheckIn();
		aircraftXCheckIn.setAcId(aircraft.getAcId());
		aircraftXCheckIn.setCheckIn(new Date());
		aircraftXCheckIn.setPriority(priorityQueueManager.getPriorityTypeByName(aircraft.getType()));
		aircraftXCheckIn.setSize(priorityQueueManager.getSizeTypeByName(aircraft.getSize()));
		aircraftXCheckIn = aircraftXCheckInRepository.save(aircraftXCheckIn);
		return aircraftXCheckIn;
	}
}
