/**
 * 
 */
package com.cyou.library.xh.user.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.cyou.library.xh.common.dao.BaseDao;
import com.cyou.library.xh.user.domain.Fun;

/**
 * @author lirenkui
 *
 */
@Component("funDao")
public class FunDao extends BaseDao{

	/**
	 * getFirstByFatherId:获取一级导航的功能集合
	 * @author lirenkui
	 * @return
	 */
	public List<Fun> getFirstByFatherId(Fun fun){	
		return this.getList("getListByFatherId",fun);
	}
	
	/**
	 * getSecondLevelFun:获取二级导航的功能集合
	 * @author lirenkui
	 * @return
	 */
	public List<Fun> getSecondLevelFun(){	
		return this.getList("getSecondLevel");
	}
	
	/**
	 * getSecondByFatherId:通过一级功能的funId获取对应的二级功能List<Fun>
	 * @author lirenkui
	 * @param:Fun :funId
	 * @return List<Fun>
	 */
	public List<Fun> getSecondByFatherId(Fun fun){
		return this.getList("getListByFatherId", fun);
	}
	
	/**
	 * getThirdByFatherId:返回二级功能对应的三级功能集合（子模块）
	 * @author lirenkui
	 * @param fun
	 * @return
	 */
	public List<Fun> getThirdByFatherId(Fun fun){
		return this.getList("getListByFatherId", fun);
	}
	
	/**
	 * getThirdLevelFun:根据二级功能的funId获取对应的三级功能集合
	 * @author lirenkui
	 * @param fun
	 * @return
	 */
	public List<Fun> getThirdLevelFun(Fun fun){
		return null;
	}
	
	public List<Fun> getThirdLevelFunList(int pageIndex,int pageSize,Fun fun){
		
		List<Fun> list = null;
		try {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("pageIndex", pageIndex*pageSize);
	    	map.put("pageSize", pageSize);
	    	
	    	if(-1 == pageIndex && 0 == pageSize){
		    	list = this.getList("getThirdLevelFunList", map);
		    }else{
		    	list = this.getList("getThirdLevelFunLists", map);
		    }
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return list;
	}
	/**
	 * getFunById:通过Fun_id得到功能的Fun对象信息，其中包括他的fun_fatherid,fun_fathername
	 * @author lirenkui
	 * @param fun
	 * @return
	 */
	public Fun getFunById(int funId){
		return this.getUniqueOne("getFunById", funId);
	}
	
	/**
	 * getFunByFatherId:通过fatherId获取对应的功能对象Fun
	 * @author lirenkui
	 * @param fun
	 * @return
	 */
	public Fun getFunByFatherId(Fun fun){
		return this.getUniqueOne("getFunByFatherId", fun);
	}
	
	/**
	 * getFunByName:通过FunName获取对应的Fun
	 * @author lirenkui
	 * @param fun
	 * @return
	 */
	public Fun getFunByName(Fun fun){
		return this.getFirstOne("getFunByName", fun);
	}
	
	
	public Fun getFatherFunById(Fun fun){
	return this.getFirstOne("getFatherFunById", fun);
	}
	
	/**
	 * addFun:添加功能
	 * @author lirenkui
	 * @param fun
	 * @return
	 */
	public int addFun(Fun fun){
		return this.add("addFun", fun);
	}
	
	/**
	 * updateFun:更新功能
	 * @author lirenkui
	 * @param fun
	 * @return
	 */
	public int updateFun(Fun fun){
		return this.update("updateFun", fun);
	}
	
	/**
	 * getLength:通过fatherId获取获取此fatherid对应的子功能集合的大小
	 * @author lirenkui
	 * @param fun
	 * @return
	 */
	public int getLength(Fun fun){
		return this.getCount("getLength",fun);
	}
	
	public int getThirdLevelCount(){
		return this.getCount("getThirdLevelCount");
	}
}
