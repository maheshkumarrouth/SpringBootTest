package de.atcs.jpa.managerImpl.atcs;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import de.atcs.jpa.atcs.AircraftXCheckInRepository;
import de.atcs.jpa.manager.atcs.AircraftXCheckInManager;
import de.atcs.model.AircraftXCheckIn;

@Component
public class AircraftXCheckInManagerImpl implements AircraftXCheckInManager{
	
	@Autowired
	private AircraftXCheckInRepository aircraftXCheckInRepository;
	
	public List<AircraftXCheckIn> fetchAllAcDetails(){
		return aircraftXCheckInRepository.findAll();
	}
	
	public AircraftXCheckIn save(AircraftXCheckIn aircraftXCheckIn) {
		
		aircraftXCheckIn = aircraftXCheckInRepository.save(aircraftXCheckIn);
		return aircraftXCheckIn;
	}
	
	public void delete(AircraftXCheckIn aircraftXCheckIn) {		
		aircraftXCheckInRepository.delete(aircraftXCheckIn);
	}
}
