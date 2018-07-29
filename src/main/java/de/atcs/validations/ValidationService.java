package de.atcs.validations;

import de.atcs.beans.Aircraft;
import de.atcs.beans.AircraftData;

public interface ValidationService {
	AircraftData fetchAllAcDetails();
	void bootTheApplication();
	void enQueueAc(Aircraft aircraft);
	void dequeueAC();
	AircraftData nextPlaneToBeDequeued();
}
