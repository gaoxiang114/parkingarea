package com.cyou.library.xh.recommand.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.cyou.library.xh.common.dao.BaseDao;
import com.cyou.library.xh.recommand.domain.Recommand;
import com.google.gson.Gson;
@Component("recommandDao")
public class RecommandDao extends BaseDao {
	
	/**
	 * addRecommand:添加推荐书籍
	 * @param recommand
	 */
	public void addRecommand(Recommand recommand){
		this.add("addRecommand", recommand);
	}
	
	
	/**
	 * updateProcedure:修改流程的状态
	 * @param recommand
	 */
	public void updateRecommand(Recommand recommand){
		this.update("updateRecommand", recommand);
	}
	
	public void updateProcedure(Integer[] ids,int state){
		List<Integer> list = new ArrayList<Integer>(ids.length);
		Map<String,Object> map = new HashMap<String,Object>();
		for(Integer id : ids){
			list.add(id);
		}
		System.out.println(list);
		System.out.println(state);
		map.put("list", list);
		map.put("state", state);
		this.update("updateProcedure", map);
	}
	
	/**
	 * recommandList:推荐书籍列表的分页方法
	 * @param pageIndex
	 * @param pageSize
	 * @return List<Recommand>
	 */
	public List<Recommand> recommandList(int pageIndex,int pageSize,Integer recFlag){
		
		List list = null;
	    
	    try {
	    	Map<String,Object> map = new HashMap<String,Object>();
	    	map.put("pageIndex", pageIndex*pageSize);
	    	map.put("pageSize", pageSize);
	    	map.put("recFlag", recFlag);
	    	
		    if(-1 == pageIndex && 0 == pageSize){
		    	list = this.getList("getAllRecommandList", map);
		    }else{
		    	list = this.getList("getRecommandPageList", map);
		    }
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return  list;
	}
	
	public Recommand getRecommandById(int recId){
		return this.getUniqueOne("getRecommandById", recId);
	}
	
	public List<Recommand> recommandList(String[] idList){
		List<Integer> list = new ArrayList<Integer>();
		
		for(String id : idList){
			list.add(Integer.parseInt(id));
		}
		
		return this.getList("getRecommandLists", list);
	}
	
	public List<Recommand> recommandList(Integer state){
		return this.getList("recommandListByState", state);
	}
	
	public void deleteRecommand(int recId){
		this.delete("deleteRecommand", recId);
	}
	
	public List<Recommand> getAllRecommandList(){
		return this.getList("getAllRecommandList");
	}
	
	public Integer getRecommandCount(int state){
		return this.getCount("getAllCounts",state);
	}
	
	public List<String> checkBookName(String bookName){
		return this.getList("checkBookName", bookName);
	}
	
	public Integer getPersonRecommandCount(){
		return this.getCount("personRecommandCount");
	}
	
	public List<Recommand> personRecommandPageList(int pageIndex, int pageSize){
		List list = null;
	    
	    try {
	    	Map<String,Object> map = new HashMap<String,Object>();
	    	map.put("pageIndex", pageIndex*pageSize);
	    	map.put("pageSize", pageSize);
	    	
		    if(-1 == pageIndex && 0 == pageSize){
		    	list = this.getList("personRecommandPageList", map);
		    }else{
		    	list = this.getList("personRecommandPageList", map);
		    }
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return  list;
	}
	
}
