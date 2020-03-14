package com.bnpparibas.hackathon.parking.api.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.bnpparibas.hackathon.parking.api.model.Parking;
import com.bnpparibas.hackathon.parking.api.model.ParkingLot;
import com.bnpparibas.hackathon.parking.api.repository.ParkingLotRepository;
import com.bnpparibas.hackathon.parking.api.repository.ParkingRepository;

import java.util.Arrays;

@Configuration
public class LoadBD implements CommandLineRunner {

	ParkingLotRepository parkingLotRepository;
	ParkingRepository parkingRepository;
	
    public LoadBD(ParkingLotRepository parkingLotRepository, ParkingRepository parkingRepository) {
        this.parkingLotRepository = parkingLotRepository;
        this.parkingRepository = parkingRepository;
    }

    @Override
    public void run(String... args) throws Exception {

		Parking park1 = new Parking();
		park1.setBuilding("building 1");
		park1.setName("name 1");
		Parking save1 = parkingRepository.save(park1);

		Parking park2 = new Parking();
		park2.setBuilding("building 2");
		park2.setName("name 2");
		Parking save2 = parkingRepository.save(park2);






	}
}