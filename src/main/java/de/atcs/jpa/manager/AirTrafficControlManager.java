package de.atcs.jpa.manager;

import de.atcs.beans.Aircraft;
import de.atcs.beans.AircraftData;

public interface AirTrafficControlManager {
	AircraftData fetchAllAcDetails();
	void bootTheApplication();
	boolean isSystemBooted();
	void enQueueAc(Aircraft aircraft);
	void dequeueAC();
	boolean isQueueEmpty();
	 AircraftData nextPlaneToBeDequeued();
}
