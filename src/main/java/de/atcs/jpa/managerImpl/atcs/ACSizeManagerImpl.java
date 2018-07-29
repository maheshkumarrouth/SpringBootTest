package de.atcs.jpa.managerImpl.atcs;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import de.atcs.jpa.atcs.ACSizeRepository;
import de.atcs.jpa.manager.atcs.ACSizeManager;
import de.atcs.model.ACSize;

@Component
public class ACSizeManagerImpl implements ACSizeManager{

	@Autowired
	private ACSizeRepository acSizeRepository;
	
	@Override
	public HashMap<Integer, String> getACSizeMap() {
		HashMap<Integer, String> acHashMap = new HashMap<>();
		List<ACSize>  aCSizeList = acSizeRepository.findAll();
		if(aCSizeList!=null&&!aCSizeList.isEmpty()) {
			aCSizeList.forEach(acSize->{
				acHashMap.put(acSize.getId(),acSize.getSize());
			});
		}
		// TODO Auto-generated method stub
		return acHashMap;
	}
	
	@Override
	public HashMap<String,Integer> getACSizKeyeMap() {
		HashMap<String,Integer> acHashMap = new HashMap<>();
		List<ACSize>  aCSizeList = acSizeRepository.findAll();
		if(aCSizeList!=null&&!aCSizeList.isEmpty()) {
			aCSizeList.forEach(acSize->{
				acHashMap.put(acSize.getSize(),acSize.getId());
			});
		}
		// TODO Auto-generated method stub
		return acHashMap;
	}

}
