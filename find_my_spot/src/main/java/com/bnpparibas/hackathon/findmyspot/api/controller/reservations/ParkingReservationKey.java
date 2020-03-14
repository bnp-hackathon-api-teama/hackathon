package com.bnpparibas.hackathon.findmyspot.api.controller.reservations;

import lombok.Data;

import java.io.Serializable;

@Data
public class ParkingReservationKey implements Serializable {

    private long userId;
    private long parkingLotId;

}
