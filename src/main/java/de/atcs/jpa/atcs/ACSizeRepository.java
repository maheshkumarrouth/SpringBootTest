package de.atcs.jpa.atcs;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import de.atcs.model.ACSize;

@Repository
public interface ACSizeRepository extends JpaRepository<ACSize, Integer>{
	@Transactional(readOnly = true)
	List<ACSize> findAll();
}
