package com.bnpparibas.hackathon.findmyspot.api.controller.impl;

import com.bnpparibas.hackathon.findmyspot.api.controller.FindMySpotControllerAPI;
import com.bnpparibas.hackathon.findmyspot.api.controller.model.ParkingSpot;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

public class FindMySpotControllerImpl implements FindMySpotControllerAPI {

    @GetMapping(name = "/parking-spots")
    public ParkingSpot findMySpot(@RequestParam Long userId) {
        return null;
    }
//
//    ASSIGN A USER TO AN
//    AVAILABLE PARKING LOT
//    IN A SPECIFIC BUILDING;
//
//    INFORM TO A USER WHERE
//    IS HIS ASSIGNED PARKING
//    LOT OR IF THE USER
//    DOESN'T HAVE ANY
//    ASSIGNED PARK;
//
//    WHEN THE USER ENTERS
//    IN THE BUILDING IT MARKS
//    THE PARKING LOT AS
//    OCCUPIED;
//
//    WHEN THE USER LEAVES
//    THE BUILDING IT MARKS
//    THE PARKING LOT AS

}
