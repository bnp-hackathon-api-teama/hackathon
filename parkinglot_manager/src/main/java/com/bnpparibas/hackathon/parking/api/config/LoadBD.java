package com.bnpparibas.hackathon.parking.api.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.bnpparibas.hackathon.parking.api.model.Parking;
import com.bnpparibas.hackathon.parking.api.model.ParkingLot;
import com.bnpparibas.hackathon.parking.api.repository.ParkingLotRepository;

@Configuration
public class LoadBD implements CommandLineRunner {

	ParkingLotRepository parkingRepository;

    public LoadBD(ParkingLotRepository parkingRepository) {
        this.parkingRepository = parkingRepository;
    }

    @Override
    public void run(String... args) throws Exception {
    	Parking park1 = new Parking();
    	park1.setId(1L);
    	park1.setBuilding("building 1");
    	park1.setName("name 1");
    	
    	ParkingLot parkLot11 = new ParkingLot();
    	parkLot11.setFloor(11);
    	parkLot11.setHeight(11);
    	parkLot11.setId(11L);
    	parkLot11.setLotId("aliasLotId 11");
    	parkLot11.setWidth(11);
    	parkLot11.setParking(park1);
    	
    	ParkingLot parkLot12 = new ParkingLot();
    	parkLot12.setFloor(12);
    	parkLot12.setHeight(12);
    	parkLot12.setId(12L);
    	parkLot12.setLotId("aliasLotId 12");
    	parkLot12.setWidth(12);
    	
    	parkLot12.setParking(park1);
    	
    	Parking park2 = new Parking();
    	park2.setId(2L);
    	park2.setBuilding("building 2");
    	park2.setName("name 2");
    	
    	ParkingLot parkLot21 = new ParkingLot();
    	parkLot21.setFloor(21);
    	parkLot21.setHeight(21);
    	parkLot21.setId(21L);
    	parkLot21.setLotId("aliasLotId 21");
    	parkLot21.setWidth(21);
    	parkLot21.setParking(park2);
    	
    	ParkingLot parkLot22 = new ParkingLot();
    	parkLot22.setFloor(22);
    	parkLot22.setHeight(22);
    	parkLot22.setId(22L);
    	parkLot22.setLotId("aliasLotId 22");
    	parkLot22.setWidth(22);
    	
    	parkLot22.setParking(park2);
    }
}