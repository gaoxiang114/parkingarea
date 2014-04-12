/**
 * 
 */
package com.cyou.library.xh.user.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cyou.library.xh.common.util.MyException;
import com.cyou.library.xh.user.dao.FunDao;
import com.cyou.library.xh.user.domain.Fun;
import com.cyou.library.xh.user.service.FunService;
import com.sun.corba.se.spi.orbutil.fsm.Guard.Result;

/**
 * @author lirenkui
 * 
 */
@Service("funService")
public class FunServiceImpl implements FunService {

	@Resource(name = "funDao")
	private FunDao funDao;

	public int addFun(Fun fun) throws MyException {
		if (funDao.getFunByName(fun) == null)
			return funDao.addFun(fun);
		else
			throw new MyException("对不起，系统中已存在此名称的功能！");
	}

	public List<Fun> getAllLevelFun() {

		/*
		 * Fun fun = new Fun();
		 * 
		 * Fun first = null; Fun second = null; List<Fun> firstLevel = null;
		 * List<Fun> secondLevel = null; List<Fun> thirdLevel = null; List<Fun>
		 * funList = new ArrayList<Fun>();
		 * 
		 * firstLevel=
		 * this.funDao.getFirstByFatherId(fun);//获取一级功能目录集合：firstLevel for(int
		 * i=0;i<firstLevel.size();i++){ first = firstLevel.get(i);
		 * funList.add(first);//将一级目录加入到allFun集合中
		 * 
		 * secondLevel =
		 * this.funDao.getSecondByFatherId(first);//通过一级目录的funId获得二级目录集合 for(int
		 * j=0;j<secondLevel.size();j++){ second = secondLevel.get(j);
		 * funList.add(second);//将二级目录插入到集合allFun中 thirdLevel =
		 * this.funDao.getThirdByFatherId(second);
		 * funList.addAll(thirdLevel);//将第三级目录集合插入到funList } }
		 */
		List<Fun> funList = null;// 存放全部
		List<Fun> sonList = null;// 存放根据一级目录id得到的二级目录集合
		List<Fun> grandsonList = null;// 存放根据二级目录的id得到三级目录集合
		Fun first = null;
		Fun second = null;
		funList = this.funDao.getFirstByFatherId(new Fun());
		for (int i = 0; i < funList.size(); i++) {
			first = funList.get(i);
			sonList = this.funDao.getSecondByFatherId(first);
			for (int j = 0; j < sonList.size(); j++) {
				second = sonList.get(j);
				grandsonList = this.funDao.getThirdByFatherId(second);
				second.setChild(grandsonList);
			}
			first.setChild(sonList);
		}
		return funList;
	}

	public Fun getFunById(int fun_id) {
		return funDao.getFunById(fun_id);
	}

	public Fun getFunByFatherId(Fun fun) {
		return funDao.getFunByFatherId(fun);
	}

	public int updateFun(Fun fun) throws MyException {
		// if (funDao.getFunByName(fun) == null)
		return funDao.updateFun(fun);
		// else
		// throw new MyException("对不起，系统中已存在此名称的功能！");
	}

	public Fun getFatherFunById(Fun fun) {
		return funDao.getFatherFunById(fun);
	}

	/*
	 * public List<Fun> getSencondLevelFun() { return
	 * funDao.getSecondLevelFun(); }
	 *//**************************** 分配权限功能需要的方法 ****************************************/
	/*
	 * 
	 * public int getOneToThreeLevel() {
	 * 
	 * this.funDao.getFirstFun(); return 0; }
	 */

	public List<Fun> getSecondByFatherId(Fun fun) {
		return funDao.getSecondByFatherId(fun);
	}

	public List<Fun> getFirstByFatherId(Fun fun) {
		return funDao.getFirstByFatherId(fun);
	}

	public Map<String, Integer> getLength() {

		int length = -1;
		Fun fun = null;
		Map<String, Integer> lengthMap = new HashMap<String, Integer>();
		List<Fun> firstFuns = this.funDao.getFirstByFatherId(new Fun());
		for (int i = 0; i < firstFuns.size(); i++) {
			fun = firstFuns.get(i);
			length = this.funDao.getLength(fun);
			lengthMap.put(fun.getFunId() + "", length);
		}
		return lengthMap;
	}

	public List<Fun> getFunList(int pageIndex, int pageSize, Fun fun) {

/*		
		List<Fun> firstLevelList = this.funDao.getFirstByFatherId(new Fun());
		 * Fun firstFun = null; Fun third = null; Fun secondFun = null;
		 * List<Fun> result = null; List<Fun> secondLevelList = null; List<Fun>
		 * thirdLevelList = null; int fromIndex = pageIndex*pageSize; int temp =
		 * -1; int temp1 =0; secondLevelList = this.funDao.getSecondLevelFun();
		 * for(int i=0;i<secondLevelList.size();i++){ secondFun =
		 * secondLevelList.get(i); thirdLevelList =
		 * this.funDao.getThirdByFatherId(secondFun); //temp = temp +
		 * thirdLevelList.size(); if((temp +thirdLevelList.size())<fromIndex){
		 * secondFun.setChild(thirdLevelList); }else{ for(int
		 * j=0;j<thirdLevelList.size();j++){ temp1 = temp+1;
		 * if(temp1==fromIndex){
		 * 
		 * } } } }
		 */

		return this.funDao.getThirdLevelFunList(pageIndex, pageSize, fun);
	}

	@Override
	public int getThirdLevelCount() {
		return this.funDao.getThirdLevelCount();
	}

}
