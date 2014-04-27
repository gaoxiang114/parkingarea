package com.parkarea.position.model;

import java.io.Serializable;

public class ParkingPosition implements Serializable{

	private static final long serialVersionUID = 1L;

	private Integer parkingId;
	private String parkingNum;
	private Integer parkingStatus;
	
	public Integer getParkingId() {
		return parkingId;
	}
	public void setParkingId(Integer parkingId) {
		this.parkingId = parkingId;
	}
	public String getParkingNum() {
		return parkingNum;
	}
	public void setParkingNum(String parkingNum) {
		this.parkingNum = parkingNum;
	}
	public Integer getParkingStatus() {
		return parkingStatus;
	}
	public void setParkingStatus(Integer parkingStatus) {
		this.parkingStatus = parkingStatus;
	}
}
