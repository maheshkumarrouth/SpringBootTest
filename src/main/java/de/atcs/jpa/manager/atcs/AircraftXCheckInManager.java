package de.atcs.jpa.manager.atcs;

import java.util.List;

import de.atcs.beans.Aircraft;
import de.atcs.model.AircraftXCheckIn;

public interface AircraftXCheckInManager {
	 List<AircraftXCheckIn> fetchAllAcDetails();
	 AircraftXCheckIn save(Aircraft aircraft);
}
