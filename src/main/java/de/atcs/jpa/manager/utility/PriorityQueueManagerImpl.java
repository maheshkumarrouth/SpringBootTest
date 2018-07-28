package de.atcs.jpa.manager.utility;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import de.atcs.beans.Aircraft;
import de.atcs.jpa.manager.atcs.ACSizeManager;
import de.atcs.jpa.manager.atcs.AircraftXCheckInManager;
import de.atcs.jpa.manager.atcs.PriorityTypesManager;
import de.atcs.model.AircraftXCheckIn;

@Component
public class PriorityQueueManagerImpl implements PriorityQueueManager{
	
	private BlockingQueue<Aircraft> acQueue = null;
	
	private HashMap<Integer,String> priorityMap = null;
	
	private HashMap<Integer,String> acSizeMap = null;
	
	@Autowired
	private PriorityTypesManager priorityTypesManager;
	
	@Autowired
	private ACSizeManager acSizeManager;
	
	@Autowired
	private AircraftXCheckInManager aircraftXCheckInManager;
	
	private boolean isSystemBooted;
	
	public boolean isSystemBooted() {
		return isSystemBooted;
	}

	public void setSystemBooted(boolean isSystemBooted) {
		this.isSystemBooted = isSystemBooted;
	}

	public void buildAcBasedOnProority(List<AircraftXCheckIn> aircraftXCheckIns) {
		
		if(aircraftXCheckIns!=null&&!aircraftXCheckIns.isEmpty()) {
			aircraftXCheckIns.stream().forEach(aircraftXCheckIn->{
				Aircraft aircraft = new Aircraft();
				aircraft.setAcId(aircraftXCheckIn.getAcId());
				aircraft.setSize(acSizeMap.get(aircraftXCheckIn.getSize()));
				aircraft.setType(priorityMap.get(aircraftXCheckIn.getPriority()));
				acQueue.add(aircraft);
			});
		}
	}
	
	public List<Aircraft> fetchAllAcDetails(){
		List<Aircraft> aircrafts = new ArrayList<>();
		acQueue.forEach(airCrapt->{
			aircrafts.add(airCrapt);
		});
		return aircrafts;
	}
	
	public void bootTheApplication() {
		if(acQueue == null) {
			isSystemBooted = true;
			acQueue = new PriorityBlockingQueue<>(11,new AircraftComparator());
			priorityMap = priorityTypesManager.getPriorityTypeMap();
			acSizeMap = acSizeManager.getACSizeMap();
			List<AircraftXCheckIn> aircraftXCheckIns = aircraftXCheckInManager.fetchAllAcDetails();
			this.buildAcBasedOnProority(aircraftXCheckIns);
		}
	}
	
	
}
