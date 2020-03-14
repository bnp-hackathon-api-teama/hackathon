package com.bnpparibas.hackathon.findmyspot.api.controller.api;

import com.bnpparibas.hackathon.findmyspot.api.controller.reservations.ParkingReservation;
import com.bnpparibas.hackathon.findmyspot.api.controller.reservations.ParkingReservationDao;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class FindMySpotControllerImpl {

    private final ParkingReservationDao parkingReservationDao;

    public FindMySpotControllerImpl(ParkingReservationDao parkingReservationDao) {
        this.parkingReservationDao = parkingReservationDao;
    }

    @GetMapping("/parking-spots")
    @Operation(summary= "Request parking spot")
    public ResponseEntity<Void> getParkingSpot(@RequestParam Long userId) {
        ParkingReservation parkingReservationByUserId = parkingReservationDao.getParkingReservationByUserId(userId);

        //Plano aqui era gerar o cliente para as API a partir do --> swagger-codegen-maven-plugin. Mas estava a dar erro
        // Alternativa a isto era usar o restTemplate

        final String uri = "http://localhost:8080/api/v1/parkings/" + parkingReservationByUserId.getParkingLotId();
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(uri, String.class);
        System.out.println(result);



        //callApiToGetParkingDetail
        return null;
    }

    @PostMapping("/parking-spots")
    @Operation(summary= "Assign park to user")
    public ResponseEntity<Parking> assignParkingLot(@RequestParam Long userId, @RequestParam String building) {
        //TODO: call parkingAPI to get parkingLots by building
        List<Parking> parkingIds = new ArrayList<>();

        for (Parking parking : parkingIds) {
            //not the efficient way..
            ParkingReservation byUserIdAndParkingLotId = parkingReservationDao.findByUserIdAndParkingLotId(userId, parking.getId());
            if (byUserIdAndParkingLotId == null) {
                return ResponseEntity.of(Optional.of(parking));
            }
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/parking-spots/{id}")
    @Operation(summary= "Deletes park assignment")
    public ResponseEntity<Void> deleteParking(@PathVariable Long id) {
        parkingReservationDao.deleteReservation(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/parking-spots/{id}")
    @Operation(summary= "Sets park as occupied")
    public ResponseEntity<Void> updateParkingSpot(@PathVariable Long id) {
        parkingReservationDao.setParkingOccupied(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }




}
