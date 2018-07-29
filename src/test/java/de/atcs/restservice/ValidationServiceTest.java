package de.atcs.restservice;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import de.atcs.beans.Aircraft;
import de.atcs.beans.AircraftData;
import de.atcs.jpa.manager.AirTrafficControlManager;
import de.atcs.validations.ValidationService;
import de.atcs.validations.ValidationServiceImpl;

@RunWith(SpringRunner.class)
public class ValidationServiceTest {
	
	@Mock
	private AirTrafficControlManager airTrafficControlManager;

	@InjectMocks
	private ValidationService service = new ValidationServiceImpl();

	@Test
	public void bootSystemTest() {
		doNothing().when(airTrafficControlManager).bootTheApplication();
		service.bootTheApplication();
	}

	@Test
	public void fetchAllAcDetailsTest() {
		when(airTrafficControlManager.isSystemBooted()).thenReturn(true);
		Aircraft airCrapt = new Aircraft();
		airCrapt.setAcId("12345");
		airCrapt.setCheckIn(new Date());
		airCrapt.setType("VIP");

		AircraftData aircraftData = new AircraftData();
		aircraftData.setAircraftData(Arrays.asList(airCrapt));

		when(airTrafficControlManager.fetchAllAcDetails()).thenReturn(aircraftData);

		AircraftData fetchAllAcDetails = service.fetchAllAcDetails();
		assertNotNull(fetchAllAcDetails.getAircraftData());
		assertEquals(fetchAllAcDetails.getAircraftData().get(0).getAcId(), "12345");
	}
}
