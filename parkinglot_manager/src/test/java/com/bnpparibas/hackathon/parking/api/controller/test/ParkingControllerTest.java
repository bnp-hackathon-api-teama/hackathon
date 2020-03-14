package com.bnpparibas.hackathon.parking.api.controller.test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Optional;

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
	
	@InjectMocks
	private ParkingController parkingController;
	
	@Mock
	private ParkingRepository parkingRepository;
	@Mock
	private ParkingLotRepository parkingLotRepository;
	
	@Test
	public void testGetParkingLotById() {
		// Given conditions		
		Parking parking = new Parking();
		parking.setBuilding("1");
		parking.setId(0);
		parking.setName("Edificio");
		parking.setParkingLot(new ArrayList<ParkingLot>());
		
		
		ParkingLot parkingLot1 = new ParkingLot();
		parkingLot1.setId(1);
		parkingLot1.setFloor(1);
		parkingLot1.setHeight(1801);
		parkingLot1.setParking(parking);
		parkingLot1.setWidth(1001);
		
		ParkingLot parkingLot2 = new ParkingLot();
		parkingLot2.setId(2);
		parkingLot2.setFloor(2);
		parkingLot2.setHeight(1802);
		parkingLot2.setParking(parking);
		parkingLot2.setWidth(1002);
		
		parking.getParkingLot().add(parkingLot1);
		parking.getParkingLot().add(parkingLot2);


		RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(new MockHttpServletRequest()));

		when(parkingLotRepository.findById(eq(1L))).thenReturn(Optional.of(parkingLot1));

		// when...
		ResponseEntity<ParkingLot> responseEntity;
		try {
			responseEntity = parkingController.getParkingLotById(1L);
		} catch (ResourceNotFoundException e) {
			fail("Unexpected exception, employee not found.");
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
		
		assertThat(returnedParkingLot.getParking().getName()).isEqualTo("Edificio");
		assertThat(returnedParkingLot.getParking().getId()).isEqualTo(0);
	}
	

}
