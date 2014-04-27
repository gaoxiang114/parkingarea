package com.parkarea.park.model;

import java.io.Serializable;
import java.util.Date;

import com.parkarea.position.model.ParkingPosition;

public class CarInOut implements Serializable{

	private static final long serialVersionUID = 1L;

	private int id;
	private String carNum;
	private String idCard;
	private String realname;
	private String telephone;
	private Date startTime;
	private Date endTime;
	private String status;
	private Double priceHour;
	private Double totalPrice;
	private ParkingPosition position;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCarNum() {
		return carNum;
	}
	public void setCarNum(String carNum) {
		this.carNum = carNum;
	}
	public String getIdCard() {
		return idCard;
	}
	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}
	public String getRealname() {
		return realname;
	}
	public void setRealname(String realname) {
		this.realname = realname;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Double getPriceHour() {
		return priceHour;
	}
	public void setPriceHour(Double priceHour) {
		this.priceHour = priceHour;
	}
	public Double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public ParkingPosition getPosition() {
		return position;
	}
	public void setPosition(ParkingPosition position) {
		this.position = position;
	}
	
}
