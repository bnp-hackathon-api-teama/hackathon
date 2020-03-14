package com.bnpparibas.hackathon.parking.api.controller.test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.bnpparibas.hackathon.commons.api.exception.ResourceNotFoundException;
import com.bnpparibas.hackathon.parking.api.controller.impl.ParkingController;
import com.bnpparibas.hackathon.parking.api.model.Parking;
import com.bnpparibas.hackathon.parking.api.model.ParkingLot;
import com.bnpparibas.hackathon.parking.api.repository.ParkingLotRepository;
import com.bnpparibas.hackathon.parking.api.repository.ParkingRepository;

@ExtendWith(SpringExtension.class)
public class ParkingControllerTest {
	protected Parking parking1;
	protected Parking parking2;
	protected ParkingLot parkingLot1;
	protected ParkingLot parkingLot2;
	
	
	@InjectMocks
	private ParkingController parkingController;
	
	@Mock
	private ParkingRepository parkingRepository;
	@Mock
	private ParkingLotRepository parkingLotRepository;
	
	@BeforeEach
	protected void setUp() throws Exception {
        System.out.println("Setting it up!");
		// Given conditions		
		parking1 = new Parking();
		parking1.setBuilding("1");
		parking1.setId(1);
		parking1.setName("Edificio 1");
		parking1.setParkingLot(new ArrayList<ParkingLot>());
		
		parking2 = new Parking();
		parking2.setBuilding("2");
		parking2.setId(2);
		parking2.setName("Edificio 2");
		parking2.setParkingLot(new ArrayList<ParkingLot>());

		
		parkingLot1 = new ParkingLot();
		parkingLot1.setId(1);
		parkingLot1.setFloor(1);
		parkingLot1.setHeight(1801);
		parkingLot1.setParking(parking1);
		parkingLot1.setWidth(1001);
		
		parking1.getParkingLot().add(parkingLot1);
		parking1.getParkingLot().add(parkingLot2);
		
		parkingLot2 = new ParkingLot();
		parkingLot2.setId(2);
		parkingLot2.setFloor(2);
		parkingLot2.setHeight(1802);
		parkingLot2.setParking(parking1);
		parkingLot2.setWidth(1002);
		
    }
     
	
	@Test
	public void testGetParkingLotById() {

		RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(new MockHttpServletRequest()));

		when(parkingLotRepository.findById(eq(1L))).thenReturn(Optional.of(parkingLot1));

		// when...
		ResponseEntity<ParkingLot> responseEntity;
		try {
			responseEntity = parkingController.getParkingLotById(1L);
		} catch (ResourceNotFoundException e) {
			fail("Unexpected exception, parking lot not found.");
			return;
		}

		// then the outcome is validated
		assertThat(responseEntity.getStatusCodeValue()).isEqualTo(HttpStatus.OK.value());

		ParkingLot returnedParkingLot = responseEntity.getBody();
		assertThat(returnedParkingLot).isNotNull();
		assertThat(returnedParkingLot.getFloor()).isEqualTo(1);
		assertThat(returnedParkingLot.getHeight()).isEqualTo(1801);
		assertThat(returnedParkingLot.getWidth()).isEqualTo(1001);
		assertThat(returnedParkingLot.getId()).isEqualTo(1);
		
		assertThat(returnedParkingLot.getParking().getName()).isEqualTo("Edificio 1");
		assertThat(returnedParkingLot.getParking().getId()).isEqualTo(1);
	}
	
	@Test
	public void testGetParkingById() {
		RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(new MockHttpServletRequest()));

		when(parkingRepository.findById(eq(2L))).thenReturn(Optional.of(parking2));
		when(parkingRepository.getOne(eq(2L))).thenReturn(parking2);
		
		// when...
		ResponseEntity<Parking> responseEntity;
		try {
			responseEntity = parkingController.getParkingById(2L);
		} catch (ResourceNotFoundException e) {
			fail("Unexpected exception, parking not found.");
			return;
		}
		
		// then the outcome is validated
		Parking returnedParking = responseEntity.getBody();

		assertThat(responseEntity.getStatusCodeValue()).isEqualTo(HttpStatus.OK.value());
		assertThat(returnedParking.getName()).isEqualTo("Edificio 2");
		assertThat(returnedParking.getId()).isEqualTo(2);


		
	}
	

	@Test
	public void testGetParkingByBuilding() {

		RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(new MockHttpServletRequest()));
		when(parkingRepository.findByBuilding(eq("Edificio 1"))).thenReturn(parking1);
		
		// when...
		ResponseEntity<Parking> responseEntity;
		try {
			responseEntity = parkingController.getParkingByBuilding("Edificio 1");
		} catch (ResourceNotFoundException e) {
			fail("Unexpected exception, parking not found.");
			return;
		}
		
		// then the outcome is validated
		Parking returnedParking = responseEntity.getBody();

		assertThat(responseEntity.getStatusCodeValue()).isEqualTo(HttpStatus.OK.value());
		assertThat(returnedParking.getName()).isEqualTo("Edificio 1");
		assertThat(returnedParking.getId()).isEqualTo(1);


	}
	

	
	

}
