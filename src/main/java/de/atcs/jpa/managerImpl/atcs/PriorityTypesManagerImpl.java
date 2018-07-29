package de.atcs.jpa.managerImpl.atcs;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import de.atcs.jpa.atcs.PriorityTypesRepository;
import de.atcs.jpa.manager.atcs.PriorityTypesManager;
import de.atcs.model.PriorityTypes;

@Component
public class PriorityTypesManagerImpl implements PriorityTypesManager{
	
	@Autowired
	private PriorityTypesRepository priorityTypesRepository;
	
	public HashMap<Integer,String> getPriorityTypeMap(){
		HashMap<Integer,String> priorityMap = new HashMap<>();
		List<PriorityTypes> priorityTypes = priorityTypesRepository.findAll();
		if(priorityTypes!=null&&!priorityTypes.isEmpty()) {
			priorityTypes.forEach(priorityType->{
				priorityMap.put(priorityType.getId(),priorityType.getType());
			});
		}
		return priorityMap;
	}
	
	public HashMap<String,Integer> getPriorityMap(){
		HashMap<String,Integer> priorityMap = new HashMap<>();
		List<PriorityTypes> priorityTypes = priorityTypesRepository.findAll();
		if(priorityTypes!=null&&!priorityTypes.isEmpty()) {
			priorityTypes.forEach(priorityType->{
				priorityMap.put(priorityType.getType(),priorityType.getId());
			});
		}
		return priorityMap;
	}
}
