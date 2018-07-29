package de.atcs.restservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import de.atcs.beans.Aircraft;
import de.atcs.beans.AircraftData;
import de.atcs.validations.ValidationService;

@RestController
@RequestMapping(value="/atc")
public class AirTrafficControl {

	@Autowired
	private ValidationService validationService;
	
	@RequestMapping(value="/enqueue",method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE)
	public void enqueueAC(@RequestBody Aircraft aircraft) {
		validationService.enQueueAc(aircraft);
	}
	
	@RequestMapping(value="/dequeue",method=RequestMethod.DELETE)
	public void dequeueAC() {
		validationService.dequeueAC();
	}
	
	@RequestMapping(value="/aclist",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public AircraftData acListing() {
		return validationService.fetchAllAcDetails();
	}
	
	@RequestMapping(value="/nextDqAc",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public AircraftData nextPlaneToBeDequeued() {
		return validationService.nextPlaneToBeDequeued();
	}
	
	
	
	@RequestMapping(value="/boot")
	public void bootTheSystem() {
		validationService.bootTheApplication();
	}
	
}
