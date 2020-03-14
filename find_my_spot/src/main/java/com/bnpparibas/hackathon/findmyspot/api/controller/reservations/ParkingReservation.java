package com.bnpparibas.hackathon.findmyspot.api.controller.reservations;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class ParkingReservation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private long userId;
    private long parkingLotId;

    @Enumerated(EnumType.ORDINAL)
    private ParkingLotState status;

    public enum ParkingLotState { RESERVED, OCCUPIED }

}
