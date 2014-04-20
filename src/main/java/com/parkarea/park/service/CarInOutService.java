package com.parkarea.park.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.parkarea.park.model.CarInOut;

public interface CarInOutService {

	public void addCarInOut(CarInOut carInOut);
	
	public void updateCarInOut(CarInOut carInOut);
	
	public void delCarInOut(Integer[] ids);
	
	public CarInOut getCarInOutById(int id);
	
	public List<CarInOut> getCarInOutList();
	
	public List<CarInOut> getCarInOutPageList(int pageIndex, int pageSize,CarInOut carInOut);
	
	public Integer getAllCount();
	
	public List<CarInOut> getHistoryList(int pageIndex, int pageSize,CarInOut carInOut);
	
	public Integer getHistoryAllCount();
}
