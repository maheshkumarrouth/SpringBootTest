package de.atcs.jpa.manager;

import java.util.ArrayList;
import java.util.Date;
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
	
	public AircraftData nextPlaneToBeDequeued() {
		AircraftXCheckIn aircraftXCheckIn = priorityQueueManager.getAcQueue().peek();
		AircraftData aircraftData = new AircraftData();
		Aircraft aircraft = new Aircraft();
		aircraft.setAcId(aircraftXCheckIn.getAcId());
		aircraft.setSize(priorityQueueManager.getAcSizeMap().get(aircraftXCheckIn.getSize()));
		aircraft.setType(this.priorityQueueManager.getPriorityMap().get(aircraftXCheckIn.getPriority()));
		List<Aircraft> list = new ArrayList<>();
		list.add(aircraft);
		aircraftData.setAircraftData(list);
		return aircraftData;
		
	}
	
	public boolean isQueueEmpty() {
		return priorityQueueManager.getAcQueue().isEmpty();
	}
	
	public void enQueueAc(Aircraft aircraft) {
		AircraftXCheckIn aircraftXCheckIn = new AircraftXCheckIn();
		aircraftXCheckIn.setAcId(aircraft.getAcId());
		aircraftXCheckIn.setCheckIn(new Date());
		aircraftXCheckIn.setPriority(priorityQueueManager.getPriorityTypeByName(aircraft.getType()));
		aircraftXCheckIn.setSize(priorityQueueManager.getSizeTypeByName(aircraft.getSize()));
		AircraftXCheckIn aircraftChekIn = aircraftXCheckInManager.save(aircraftXCheckIn);
		priorityQueueManager.getAcQueue().add(aircraftChekIn);
	}
	
	public void dequeueAC() {
		try {
			AircraftXCheckIn aircraftXCheckIn = priorityQueueManager.getAcQueue().take();
			aircraftXCheckInManager.delete(aircraftXCheckIn);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public boolean isSystemBooted() {
		return priorityQueueManager.isSystemBooted();
	}

	@Override
	public void bootTheApplication() {
		priorityQueueManager.bootTheApplication();
	}
}
