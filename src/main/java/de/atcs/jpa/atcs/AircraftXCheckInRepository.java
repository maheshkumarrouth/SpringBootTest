package de.atcs.jpa.atcs;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import de.atcs.model.AircraftXCheckIn;

@Repository
public interface AircraftXCheckInRepository extends JpaRepository<AircraftXCheckIn, Integer>{
	
	@Transactional(readOnly = true)
	List<AircraftXCheckIn> findAll();
	
	@Transactional(readOnly = false)
	AircraftXCheckIn save(AircraftXCheckIn arAircraftXCheckIn);
	
	@Transactional(readOnly = false)
	void delete(AircraftXCheckIn arAircraftXCheckIn);
}
