/*
 * CopyRight (c) 2014 北京万佳信科技有限公司 保留所有权利。
 */
package com.parkarea.system.model;

/**
 * @author <a href="mailto:gaoxiang@good10000.com">高祥</a>
 * @version 1.0.0.2014年4月24日
 */
public class SystemInfo {

	private int sysId;
	private String parkingLot;
	private int parkingCount;
	private Double parkingMoney;
	
	public int getSysId() {
		return sysId;
	}
	public void setSysId(int sysId) {
		this.sysId = sysId;
	}
	public String getParkingLot() {
		return parkingLot;
	}
	public void setParkingLot(String parkingLot) {
		this.parkingLot = parkingLot;
	}
	public int getParkingCount() {
		return parkingCount;
	}
	public void setParkingCount(int parkingCount) {
		this.parkingCount = parkingCount;
	}
	public Double getParkingMoney() {
		return parkingMoney;
	}
	public void setParkingMoney(Double parkingMoney) {
		this.parkingMoney = parkingMoney;
	}
	
}

