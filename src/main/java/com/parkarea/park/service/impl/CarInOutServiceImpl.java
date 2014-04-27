package com.parkarea.park.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.parkarea.park.dao.CarInOutDao;
import com.parkarea.park.model.CarInOut;
import com.parkarea.park.service.CarInOutService;

@Service("carInOutService")

public class CarInOutServiceImpl implements CarInOutService {

	@Resource(name="carInOutDao")
	private CarInOutDao carInOutDao;
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
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
	public Integer getAllCount(CarInOut carInOut) {
		return this.carInOutDao.getAllCount(carInOut);
	}

	@Override
	public List<CarInOut> getHistoryList(int pageIndex, int pageSize,CarInOut carInOut) {
		return this.carInOutDao.getHistoryList(pageIndex, pageSize, carInOut);
	}

	@Override
	public Integer getHistoryAllCount(CarInOut carInOut) {
		return this.carInOutDao.getHistoryAllCount(carInOut);
	}

	@Override
	public Map<String, Object> countParkCarNum() {
		String sql = "select count(*) todayCount,(select count(*) from car_in_out) allCount from car_in_out where DATE(start_time) = CURDATE()";
		Map<String,Object> data = jdbcTemplate.queryForMap(sql);
		Map<String,Object> todayCountIChartJs = new HashMap<String,Object>();
		Map<String,Object> allCountIChartJs = new HashMap<String,Object>();
		Map<String,Object> result = new HashMap<String,Object>();
		List<Map<String,Object>> list = null;
		if(data!=null){
			list = new ArrayList<Map<String,Object>>();
			todayCountIChartJs.put("name", "今日停车数量");
			todayCountIChartJs.put("value", data.get("todayCount"));
			todayCountIChartJs.put("color", "#3883bd");
			allCountIChartJs.put("name", "总停车数量");
			allCountIChartJs.put("value", data.get("allCount"));
			allCountIChartJs.put("color", "#3F5C71");
			list.add(todayCountIChartJs);
			list.add(allCountIChartJs);
			result.put("data", list);
			result.put("title", "停车场停车数量统计图");
			return result;
		}
		return null;
	}

	@Override
	public Map<String, Object> countParkMoney() {
		String sql = "select sum(total_price) todayMoney,(select sum(total_price) from car_in_out) allMoney from car_in_out where DATE(start_time) = CURDATE()";
		Map<String,Object> data = jdbcTemplate.queryForMap(sql);
		Map<String,Object> todayCountIChartJs = new HashMap<String,Object>();
		Map<String,Object> allCountIChartJs = new HashMap<String,Object>();
		Map<String,Object> result = new HashMap<String,Object>();
		List<Map<String,Object>> list = null;
		if(data!=null){
			list = new ArrayList<Map<String,Object>>();
			todayCountIChartJs.put("name", "今日收费");
			todayCountIChartJs.put("value", data.get("todayMoney"));
			todayCountIChartJs.put("color", "#3883bd");
			allCountIChartJs.put("name", "总收费");
			allCountIChartJs.put("value", data.get("allMoney"));
			allCountIChartJs.put("color", "#3F5C71");
			list.add(todayCountIChartJs);
			list.add(allCountIChartJs);
			result.put("data", list);
			result.put("title", "停车场停车收益统计图");
			return result;
		}
		return null;
	}

	@Override
	public Integer checkCarPark(String carNum) {
		return this.carInOutDao.checkCarPark(carNum);
	}
	
	
	
	

}
