package de.atcs.jpa.manager.utility;

import java.util.Comparator;
import de.atcs.model.AircraftXCheckIn;

public class AircraftComparator implements Comparator<AircraftXCheckIn>{

	@Override
	public int compare(AircraftXCheckIn o1, AircraftXCheckIn o2) {
		int priorityCmp = o1.getPriority().compareTo(o2.getPriority());
		if(priorityCmp!=0) return priorityCmp;
		int sizeCmp = o1.getSize().compareTo(o2.getSize());
		if(sizeCmp!=0) return sizeCmp;
		int idComp = o1.getId().compareTo(o2.getId());
		return idComp;
	}

}
