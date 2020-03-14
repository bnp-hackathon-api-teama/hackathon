package com.bnpparibas.hackathon.findmyspot.api.controller.reservations;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ParkingReservationDao extends JpaRepository<ParkingReservation, Long> {


    ParkingReservation getParkingReservationByUserId(Long userId);

    @Query("delete from ParkingReservation P where p.parkingLotId = ?1")
    void deleteReservation(Long parkingId);

    @Query("update ParkingReservation set status = ParkingLotState.OCCUPIED where parkingLotId = ?!")
    void setParkingOccupied(Long parkingId);

    ParkingReservation findByUserIdAndParkingLotId(Long userId, Long parkId);



}
