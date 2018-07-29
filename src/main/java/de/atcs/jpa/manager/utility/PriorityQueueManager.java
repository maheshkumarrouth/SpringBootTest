package de.atcs.jpa.manager.utility;

import java.util.List;
import java.util.concurrent.BlockingQueue;

import de.atcs.beans.Aircraft;
import de.atcs.model.AircraftXCheckIn;

public interface PriorityQueueManager {
	List<Aircraft> fetchAllAcDetails();
	void bootTheApplication();
	boolean isSystemBooted();
	void enQueueAc(Aircraft aircraft);
	Integer getPriorityTypeByName(String priority);
	Integer getSizeTypeByName(String name);
	BlockingQueue<AircraftXCheckIn> getAcQueue();
}
