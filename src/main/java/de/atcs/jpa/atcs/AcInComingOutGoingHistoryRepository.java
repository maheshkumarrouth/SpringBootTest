package de.atcs.jpa.atcs;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import de.atcs.model.AcInComingOutGoingHistory;

@Repository
public interface AcInComingOutGoingHistoryRepository extends JpaRepository<AcInComingOutGoingHistory,Integer>{
	
	@Transactional(readOnly=false)
	AcInComingOutGoingHistory save(AcInComingOutGoingHistory acInComingOutGoingHistory);
	
	
}
