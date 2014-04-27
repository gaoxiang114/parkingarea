package com.parkarea.position.service;

import java.util.List;

import com.parkarea.position.model.ParkingPosition;

public interface ParkingPositionService {

	public void addPosition(ParkingPosition position);
	
	public void updatePosition(ParkingPosition position);
	
	public void delPosition(Integer[] ids);
	
	public ParkingPosition getPositionById(int id);
	
	public List<ParkingPosition> getPositionList();
	
	public List<ParkingPosition> getPositionPageList(int pageIndex, int pageSize,ParkingPosition position);
	
	public Integer getAllCount(ParkingPosition position);
	
	public Integer checkPositionExist(String parkingNum);
}
