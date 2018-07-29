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
	
	private BlockingQueue<AircraftXCheckIn> acQueue = null;
	
	private HashMap<Integer,String> priorityMap = null;
	
	private HashMap<String,Integer> priorityKeyMap = null;
	
	private HashMap<Integer,String> acSizeMap = null;
	
	private HashMap<String,Integer> acSizeKeyMap = null;
	
	@Autowired
	private PriorityTypesManager priorityTypesManager;
	
	@Autowired
	private ACSizeManager acSizeManager;
	
	@Autowired
	private AircraftXCheckInManager aircraftXCheckInManager;
	
	private boolean isSystemBooted;
	
	public BlockingQueue<AircraftXCheckIn> getAcQueue() {
		return acQueue;
	}

	public void setAcQueue(BlockingQueue<AircraftXCheckIn> acQueue) {
		this.acQueue = acQueue;
	}

	public boolean isSystemBooted() {
		return isSystemBooted;
	}

	public void setSystemBooted(boolean isSystemBooted) {
		this.isSystemBooted = isSystemBooted;
	}

	public void buildAcBasedOnProority(List<AircraftXCheckIn> aircraftXCheckIns) {
		System.out.println("aircraftXCheckIns"+aircraftXCheckIns.size());
		acQueue.addAll(aircraftXCheckIns);
	}
	
	public List<Aircraft> fetchAllAcDetails(){
		List<Aircraft> aircrafts = new ArrayList<>();
		acQueue.forEach(airCraptChekIn->{
			System.out.println("airCraptChekIn"+airCraptChekIn.getAcId());
			Aircraft aircraft = new Aircraft();
			aircraft.setAcId(airCraptChekIn.getAcId());
			aircraft.setSize(this.acSizeMap.get(airCraptChekIn.getSize()));
			aircraft.setType(this.priorityMap.get(airCraptChekIn.getPriority()));
			aircrafts.add(aircraft);
		});
		return aircrafts;
	}
	
	public void enQueueAc(Aircraft aircraft) {
		//acQueue.add(aircraft);
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
	
	public Integer getPriorityTypeByName(String priority) {
		return priorityKeyMap.get(priority);
	}
	
	public Integer getSizeTypeByName(String name) {
		return acSizeKeyMap.get(name);
	}
	
}
