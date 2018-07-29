package de.atcs.jpa.manager.atcs;

import java.util.List;

import de.atcs.model.AircraftXCheckIn;

public interface AircraftXCheckInManager {
	 List<AircraftXCheckIn> fetchAllAcDetails();
	 AircraftXCheckIn save(AircraftXCheckIn aircraftXCheckIn);
	 void delete(AircraftXCheckIn aircraftXCheckIn);
}
