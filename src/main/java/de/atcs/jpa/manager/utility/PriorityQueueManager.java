package de.atcs.jpa.manager.utility;

import java.util.List;

import de.atcs.beans.Aircraft;
import de.atcs.model.AircraftXCheckIn;

public interface PriorityQueueManager {
	List<Aircraft> fetchAllAcDetails(List<AircraftXCheckIn> arAircraftXCheckIns);
}
