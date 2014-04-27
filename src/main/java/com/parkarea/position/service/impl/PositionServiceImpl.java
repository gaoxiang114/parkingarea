package com.parkarea.position.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.parkarea.position.dao.PositionDao;
import com.parkarea.position.model.ParkingPosition;
import com.parkarea.position.service.ParkingPositionService;

@Service("parkingPositionService")
public class PositionServiceImpl implements ParkingPositionService {

	@Resource(name="positionDao")
	private PositionDao positionDao;
	
	@Override
	public void addPosition(ParkingPosition position) {
		positionDao.addPosition(position);
	}

	@Override
	public void updatePosition(ParkingPosition position) {
		positionDao.updatePosition(position);
	}

	@Override
	public void delPosition(Integer[] ids) {
		positionDao.delPosition(ids);
	}

	@Override
	public ParkingPosition getPositionById(int id) {
		return positionDao.getPositionById(id);
	}

	@Override
	public List<ParkingPosition> getPositionList() {
		return positionDao.getPositionList();
	}

	@Override
	public List<ParkingPosition> getPositionPageList(int pageIndex, int pageSize,ParkingPosition position) {
		return positionDao.getPositionPageList(pageIndex, pageSize, position);
	}

	@Override
	public Integer getAllCount(ParkingPosition position) {
		return positionDao.getAllCount(position);
	}

	@Override
	public Integer checkPositionExist(String parkingNum) {
		return positionDao.checkPositionExist(parkingNum);
	}

}
