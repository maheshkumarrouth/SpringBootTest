package de.atcs.jpa.manager.utility;

import java.util.List;

import de.atcs.beans.Aircraft;

public interface PriorityQueueManager {
	List<Aircraft> fetchAllAcDetails();
	void bootTheApplication();
	boolean isSystemBooted();
}
