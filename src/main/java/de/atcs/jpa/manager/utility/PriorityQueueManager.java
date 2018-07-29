package de.atcs.jpa.manager.utility;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.BlockingQueue;

import de.atcs.beans.Aircraft;
import de.atcs.model.AircraftXCheckIn;

public interface PriorityQueueManager {
	List<Aircraft> fetchAllAcDetails();
	void bootTheApplication();
	boolean isSystemBooted();
	Integer getPriorityTypeByName(String priority);
	Integer getSizeTypeByName(String name);
	BlockingQueue<AircraftXCheckIn> getAcQueue();
	HashMap<Integer, String> getPriorityMap();
	HashMap<Integer, String> getAcSizeMap();
}
