package de.atcs.jpa.manager.atcs;

import java.util.HashMap;

public interface PriorityTypesManager {
	HashMap<Integer,String> getPriorityTypeMap();
	HashMap<String,Integer> getPriorityMap();
}
