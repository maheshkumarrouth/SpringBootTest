package de.atcs.jpa.atcs;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import de.atcs.model.PriorityTypes;

@Repository
public interface PriorityTypesRepository extends JpaRepository<PriorityTypes, Integer>{
	
	 @Transactional(readOnly = true)
	 List<PriorityTypes> findAll();
	 
	 
	 
}
