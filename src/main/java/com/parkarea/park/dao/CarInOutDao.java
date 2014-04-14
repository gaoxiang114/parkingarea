package com.parkarea.park.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.parkarea.common.dao.BaseDao;
import com.parkarea.park.model.CarInOut;

@Component("carInOutDao")
public class CarInOutDao extends BaseDao {
	
	public void addCarInOut(CarInOut carInOut){
		this.add("addCarInOut", carInOut);
	}
	
	public void updateCarInOut(CarInOut carInOut){
		this.update("updateCarInOut", carInOut);
	}
	
	public void delCarInOut(Integer[] ids){
		List<Integer> idList = new ArrayList<Integer>(ids.length);
		for(Integer id : ids){
			idList.add(id);
		}
		this.delete("delCarInOut", idList);
	}
	
	public CarInOut getCarInOutById(int id){
		return this.getUniqueOne("getCarInOutById", id);
	}
	
	public List<CarInOut> getCarInOutList(){
		return this.getList("getCarInOutList");
	}
	
	public List<CarInOut> getCarInOutPageList(int pageIndex, int pageSize,CarInOut carInOut){
		 List<CarInOut> list = null;
		    
		    try {
		    	Map<String,Object> map = new HashMap<String,Object>();
		    	map.put("pageIndex", pageIndex*pageSize);
		    	map.put("pageSize", pageSize);
		    	
			    if(-1 == pageIndex && 0 == pageSize){
			    	list = this.getList("getCarInOutPageList", map);
			    }else{
			    	list = this.getList("getCarInOutPageList", map);
			    }
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			
			return  list;
	}
	
	public Integer getAllCount(){
		return this.getCount("getAllCount");
	}
}
