package com.parkarea.position.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.parkarea.common.dao.BaseDao;
import com.parkarea.position.model.ParkingPosition;

@Component("positionDao")
public class PositionDao extends BaseDao{

	public void addPosition(ParkingPosition position){
			this.add("addPosition", position);
	}
	
	public void updatePosition(ParkingPosition position){
		this.update("updatePosition", position);
	}
	
	public void delPosition(Integer[] ids){
		List<Integer> idList = new ArrayList<Integer>(ids.length);
		for(Integer id : ids){
			idList.add(id);
		}
		this.delete("delPosition", idList);
	}
	
	public ParkingPosition getPositionById(int id){
		return this.getUniqueOne("getPositionById", id);
	}
	
	public List<ParkingPosition> getPositionList(){
		return this.getList("getPositionList");
	}
	
	public List<ParkingPosition> getPositionPageList(int pageIndex, int pageSize,ParkingPosition position){
		 List<ParkingPosition> list = null;
		    
		    try {
		    	Map<String,Object> map = new HashMap<String,Object>();
		    	map.put("pageIndex", pageIndex*pageSize);
		    	map.put("pageSize", pageSize);
		    	map.put("parkingNum", position.getParkingNum());
		    	map.put("parkingStatus", position.getParkingStatus());
		    	
			    if(-1 == pageIndex && 0 == pageSize){
			    	list = this.getList("getPositionPageList", map);
			    }else{
			    	list = this.getList("getPositionPageList", map);
			    }
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			
			return  list;
	}
	
	public Integer getAllCount(ParkingPosition position){
		return this.getCount("getAllCount",position);
	}
	
	public Integer checkPositionExist(String parkingNum){
		return this.getCount("checkPositionExist",parkingNum);
	}
	
}
