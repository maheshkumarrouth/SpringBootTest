package de.atcs.restservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import de.atcs.beans.AircraftData;
import de.atcs.validations.ValidationService;

@RestController
@RequestMapping(value="/atcs")
public class AirTrafficControl {

	@Autowired
	private ValidationService ValidationService;
	
	@RequestMapping(value="/boot")
	public void bootTheSystem() {
		ValidationService.bootTheApplication();
	}
	
	@RequestMapping(value="/enqueue")
	public void enqueueAC() {
		
	}
	
	@RequestMapping(value="/dequeue")
	public void dequeueAC() {
		
	}
	
	@RequestMapping(value="/aclist",produces=MediaType.APPLICATION_JSON_VALUE)
	public AircraftData acListing() {
		return ValidationService.fetchAllAcDetails();
	}
	
	
}
