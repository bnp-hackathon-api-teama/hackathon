package com.bnpparibas.hackathon.parking.api.controller.test;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.bnpparibas.hackathon.parking.api.controller.impl.ParkingController;
import com.bnpparibas.hackathon.parking.api.repository.ParkingRepository;

@ExtendWith(SpringExtension.class)
public class ParkingControllerTest {
	
	@InjectMocks
	private ParkingController parkingController;
	
	@Mock
	private ParkingRepository parkingRepository;
	

}
