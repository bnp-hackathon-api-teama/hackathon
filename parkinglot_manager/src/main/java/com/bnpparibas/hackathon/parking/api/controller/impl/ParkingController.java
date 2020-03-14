package com.bnpparibas.hackathon.parking.api.controller.impl;

import com.bnpparibas.hackathon.commons.api.exception.ResourceNotFoundException;
import com.bnpparibas.hackathon.parking.api.model.Parking;
import com.bnpparibas.hackathon.parking.api.model.ParkingLot;
import com.bnpparibas.hackathon.parking.api.repository.ParkingLotRepository;
import com.bnpparibas.hackathon.parking.api.repository.ParkingRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.bnpparibas.hackathon.parking.api.controller.ParkingControllerAPI;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class ParkingController implements ParkingControllerAPI{

    private final ParkingRepository parkingRepository;
    private final ParkingLotRepository parkingLotRepository;

    public ParkingController(ParkingRepository parkingRepository, ParkingLotRepository parkingLotRepository) {
        this.parkingRepository = parkingRepository;
        this.parkingLotRepository = parkingLotRepository;
    }

    @Override
    public ResponseEntity<ParkingLot> updateParkingLot(Long parkingLotId, @Valid ParkingLot parkingLotDetails) throws ResourceNotFoundException {
        return null;
    }

    @Override
    public ResponseEntity<Parking> updateParking(Long parkingId, @Valid Parking parkingDetails) throws ResourceNotFoundException {
        return null;
    }

    @Override
    public ParkingLot createParkingLot(@Valid ParkingLot parkingLot) {
        return parkingLotRepository.save(parkingLot);
    }

    @Override
    public Parking createParking(@Valid Parking parking) {
        return parkingRepository.save(parking);
    }

    @Override
    @GetMapping("/parkings/{id}")
    public ResponseEntity<Parking> getParkingById(@PathVariable Long id) throws ResourceNotFoundException {
        Optional<Parking> parking = parkingRepository.findById(id);

        if (parking.isPresent()) {
            return ResponseEntity.of(Optional.of(parkingRepository.getOne(id)));
        } else {
            throw new ResourceNotFoundException("Parking not found");
        }

    }

    @Override
    @GetMapping("/parkings")
    public ResponseEntity<Parking> getParkingByBuilding(@RequestParam String building) throws ResourceNotFoundException {

        Optional<Parking> byBuilding = Optional.ofNullable(parkingRepository.findByBuilding(building));
        if (byBuilding.isPresent()){
            return ResponseEntity.of(byBuilding);
        } else {
            throw new ResourceNotFoundException("Parking not found");
        }


    }

    @Override
    public List<Parking> getAllParkings() {
        return null;
    }

    @Override
    @GetMapping("/parking-lots/{id}")
    public ResponseEntity<ParkingLot> getParkingLotById(Long parkingLotId) throws ResourceNotFoundException {
    	
    	ParkingLot parkingLot = parkingLotRepository.findById(parkingLotId)
				.orElseThrow(() -> new ResourceNotFoundException("ParkingLot not found {id : " + parkingLotId +"}"));
		return ResponseEntity.ok().body(parkingLot);
    }

    @Override
    public ResponseEntity<ParkingLot> getParkingLotByAliasId(String aliasLotId) throws ResourceNotFoundException {
        return null;
    }

    @Override
    public List<ParkingLot> getParkingLotAvailableByBuilding(String building) throws ResourceNotFoundException {
        return null;
    }

    @Override
    public List<ParkingLot> getAllParkingLots() {
        return parkingLotRepository.findAll();
    }

    @Override
    public List<ParkingLot> getAllAvailableParkingLots() {
        return parkingLotRepository.findAllByAvailableEquals(true);
    }

}
