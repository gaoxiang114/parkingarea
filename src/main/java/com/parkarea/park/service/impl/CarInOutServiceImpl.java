package com.parkarea.park.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.parkarea.park.dao.CarInOutDao;
import com.parkarea.park.model.CarInOut;
import com.parkarea.park.service.CarInOutService;

@Service("carInOutService")

public class CarInOutServiceImpl implements CarInOutService {

	@Resource(name="carInOutDao")
	private CarInOutDao carInOutDao;
	
	@Override
	public void addCarInOut(CarInOut carInOut) {
		this.carInOutDao.addCarInOut(carInOut);
	}

	@Override
	public void updateCarInOut(CarInOut carInOut) {
		this.carInOutDao.updateCarInOut(carInOut);
	}

	@Override
	public void delCarInOut(Integer[] ids) {
		this.carInOutDao.delCarInOut(ids);
	}

	@Override
	public CarInOut getCarInOutById(int id) {
		return this.carInOutDao.getCarInOutById(id);
	}

	@Override
	public List<CarInOut> getCarInOutList() {
		return this.carInOutDao.getCarInOutList();
	}

	@Override
	public List<CarInOut> getCarInOutPageList(int pageIndex, int pageSize,CarInOut carInOut) {
		return this.carInOutDao.getCarInOutPageList(pageIndex, pageSize, carInOut);
	}

	@Override
	public Integer getAllCount() {
		return this.carInOutDao.getAllCount();
	}

}
