package com.bnpparibas.hackathon.parking.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bnpparibas.hackathon.parking.api.model.Parking;

import java.util.List;

@Repository
public interface ParkingRepository extends JpaRepository<Parking, Long>{

    Parking findByBuilding(String building);

}
