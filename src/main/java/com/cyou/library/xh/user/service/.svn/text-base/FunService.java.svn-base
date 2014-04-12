/**
 * 
 */
package com.cyou.library.xh.user.service;

import java.util.List;
import java.util.Map;

import com.cyou.library.xh.common.util.MyException;
import com.cyou.library.xh.user.domain.Fun;

/**
 * @author lirenkui
 *
 */

public interface FunService {
	
/*	*//**
	 * getFirstByFatherId:得到第一级目录导航
	 * @author lirenkui
	 * @return
	 */
	public List<Fun> getFirstByFatherId(Fun fun);
	
	/**
	 * getSencondLevelFun:得到第二级目录导航
	 * @author lirenkui
	 * @return
	 *//*
	public List<Fun> getSencondLevelFun();
	*/
	
	/**
	 * getSecondByFatherId:得到通过一级目录的funId第二级目录导航
	 * @author lirenkui
	 * @param Fun:funId
	 * @return List<Fun>
	 */
	public List<Fun> getSecondByFatherId(Fun fun);
	
	/**
	 * getFunById:通过fun_id得到当前当前功能的Fun对象信息包括fun_fatherid,fun_fathername
	 * @author lirenkui
	 * @param fun
	 * @return
	 */
	public Fun getFunById(int fun_id);
	
	/**
	 * 根据fatherId获取对应的父级功能对象fun
	 * @author lirenkui
	 * @param fun
	 * @return
	 */
	public Fun getFatherFunById(Fun fun);
	
	/**
	 * getFunByFatherId:根据当前用户的fun_fatherid得到当前功能的父级功能Fun对象包括父级功能的fun_fatherid,fun_fathernam
	 * @author lirenkui
	 * @param fun
	 * @return
	 */
	public Fun getFunByFatherId(Fun fun);
	
	/**
	 * getAllLevelFun:返回当前导航集合
	 * @author lirenkui
	 * @return
	 * @throws MyException 
	 */
	public List<Fun> getAllLevelFun();
	
	/**
	 * addFirstLevelFun:添加功能
	 * @author lirenkui
	 * @param Fun 
	 * @return int 添加影响的行数
	 * @throws MyException 
	 */
	public int addFun(Fun fun) throws MyException;
	
	
	/**
	 * updateFun：跟新fun
	 * @author lirenkui
	 * @param fun
	 * @return
	 * @throws MyException
	 */
	public int updateFun(Fun fun) throws MyException;
	
	/**
	 * getLength:获取各个一级功能所对应的二级功能的个数
	 * @author lirenkui
	 * @return
	 */
	public Map<String,Integer> getLength();
	
	/**
	 * getFunList:获取功能功能集合
	 * @author lirenkui
	 * @return
	 */
	public List<Fun> getFunList(int pageIndex,int pageSize,Fun fun);
	/**
	 * getOneToThreeLevel:返回功能集合：第一级到第三季
	 * @author lirenkui
	 * @return
	 *//*
	public int getOneToThreeLevel();*/
	
	public int getThirdLevelCount();
}
