package com.bnpparibas.hackathon.parking.api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "parking_lot")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class ParkingLot {
	
	private long id;
	private String aliasLotId;
	private int floor;
	private int width;
	private int height;
	private boolean available;
	private String newAttr;
	private Parking parking;
	
	public ParkingLot() {}
	
	public ParkingLot(String aliasLotId, int floor, int width, int height, Parking parking, boolean available) {
		this.aliasLotId = aliasLotId;
		this.floor = floor;
		this.width = width;
		this.height = height;
		this.parking = parking;
		this.available = available;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}

	@Column(name = "alias_lot_id", nullable = false, unique=true)
	public String getLotId() {
		return aliasLotId;
	}

	public void setLotId(String aliasLotId) {
		this.aliasLotId = aliasLotId;
	}

	@Column(name = "floor", nullable = false)
	public int getFloor() {
		return floor;
	}

	public void setFloor(int floor) {
		this.floor = floor;
	}

	@Column(name = "width", nullable = false)
	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	@Column(name = "height", nullable = false)
	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER,optional = false)
	public Parking getParking() {
		return parking;
	}

	public void setParking(Parking parking) {
		this.parking = parking;
	}

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}
}
