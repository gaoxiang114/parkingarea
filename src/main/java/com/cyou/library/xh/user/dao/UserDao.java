/**
 * 
 */
package com.cyou.library.xh.user.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.cyou.library.xh.common.dao.BaseDao;
import com.cyou.library.xh.common.util.Page;
import com.cyou.library.xh.user.domain.User;

/**
 * @author lirenkui
 *
 */
@Component("userDao")
public class UserDao extends BaseDao{

	/**
	 * addUser:添加用户信息
	 * @author lirenkui
	 * @param user
	 * @return int 添加影响的行数
	 */
	public int addUser(User user){
		return this.add("addUser", user);
	}
	
	/**
	 * getUserById:通过user_loginid查找用户信息
	 * @author lirenkui
	 * @param user
	 * @return User
	 */
	public User getUserByUserNum(User user){
		return this.getFirstOne("getUserByUserNum", user);
	}
	
	/**
	 * getUserByUserId:根据user_id获取用户User对象数据
	 * @author lirenkui
	 * @param user
	 * @return
	 */
	public User getUserByUserId(User user){
		return this.getUniqueOne("getUserById", user);
	}
	
	/**
	 * delUserList:删除多个用户
	 * @author lirenkui
	 * @param userlist
	 * @return int 删除的影响的行数
	 */
	public int delUserList(List idList){
		return this.delete("delUserList", idList);
	}
	
	/**
	 * updateUserByUserId:根据user_id更新用户信息
	 * @author lirenkui
	 * @param user
	 * @return int 更新影响的行数
	 */
	public int updateUserByUserId(User user){
		return this.update("updateUserByUserId", user);
	}
	public int updateUserMailByUserId(User user){
		return this.update("updateUserMailByUserId", user);
	}
	/**
	 * updateOrderNumById:根据user_id修改user_ordernum
	 * @author lirenkui
	 * @param user
	 * @return
	 */
	public int updateOrderNumById(User user){
		return this.update("updateOrderNumById", user);
	}
	
	/**
	 * updateBorrowNumById:根据user_id修改user_borrownum
	 * @author lirenkui
	 * @param user
	 * @return
	 */
	public int updateBorrowNumById(User user){
		return this.update("updateBorrowNumById", user);
	}
	
	/**
	 * getAllUserRecords:获取用户记录总数
	 * @author lirenkui
	 * @return int 用户记录数
	 */
	public int getAllUserRecords(){
		return this.getCount("getAllUserRecords");
	}
	
	/**
	 * getAllUsers:返回所有用户记录集合
	 * @author lirenkui
	 * @return
	 */
	public List<User> getAllUsers(){
		return this.getList("getAllUsers");
	}
	
	/**
	 * getUserCountByUserNum:根据员工编号检索出来检索用户记录总数
	 * @author lirenkui
	 * @param user
	 * @return
	 */
	public int getCountByNum(User user){
		return this.getCount("getCountByNum", user);
	}
	
	/**
	 * getCountByDepart:根据员工所属部门检索用户总记录数
	 * @author lirenkui
	 * @param user
	 * @return
	 */
	public int getCountByDepart(User user){
		return this.getCount("getCountByDepart", user);
	}	
	
	/**
	 * getPageUserList:得到当前分页的数据集合
	 * @author lirenkui
	 * @param page
	 * @return
	 */
	public List<User> getPageUserList(Page page){
		return this.getList("getPageUserList", page);
	}
	
	/**
	 * getUserPageList:得到当前分页的数据集合
	 * @author lirenkui
	 * @param pageIndex
	 * @param pageSize
	 * @param user
	 * @return
	 */
	public List getUserPageList(int pageIndex,int pageSize,User user){
		
		 List list = null;
		    
		    try {
		    	Map<String,Object> map = new HashMap<String,Object>();
		    	map.put("pageIndex", pageIndex*pageSize);
		    	map.put("pageSize", pageSize);
		    	
			    if(-1 == pageIndex && 0 == pageSize){
			    	list = this.getList("getAllUsers", map);
			    }else{
			    	list = this.getList("getUserPageList", map);
			    }
			    //list = this.getList("getUserPageList", map);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			
			return  list;
	}
	/**
	 * getPageListByNum:根据员工编号检索出当前分页要显示的数据集合
	 * @author lirenkui
	 * @param page
	 * @return
	 */
	public List<User> getPageListByNum(Page page){
		return this.getList("getPageListByNum", page);
	}

	/**
	 * getPageListByDepart:根据所属部门检索当前页面要显示的数据集合
	 * @author lirenkui
	 * @param page
	 * @return
	 */
	public List<User> getPageListByDepart(Page page){
		return this.getList("getPageListByDepart", page);
	}
	/**
	 * updateUserPassword:更改用戶密碼
	 * @author lirenkui
	 * @param user
	 * @return
	 */
	public int updateUserPassword(User user){
		return this.update("updateUserPassword", user);
	}
	
	/**
	 * getUserListByFuzzy:通过模糊查询获得的user对象集合
	 * @author lirenkui
	 * @param pageIndex
	 * @param pageSize
	 * @param inputString
	 * @param user
	 * @return
	 */
	public List<User> getUserListByFuzzy(int pageIndex,int pageSize,String inputString,User user){
		
		List list = null;
		try {
			Map<String,Object> map = new HashMap<String, Object>();
			map.put("pageIndex", pageIndex*pageSize);
			map.put("pageSize", pageSize);
			map.put("inputString", inputString);
		    if(-1 == pageIndex && 0 == pageSize){
		    	list = this.getList("getUserListByFuzzy", map);
		    }else{
			list = this.getList("getUserPageListByFuzzy", map);
		    }
			//list = this.getList("getUserPageListByFuzzy", map);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return list;
	}

	/**
	 * getCountByFuzzy:通过模糊查询获取结果集合的大小
	 * @author lirenkui
	 * @param inputString
	 * @return
	 */
	public int getCountByFuzzy(String inputString){
		return this.getCount("getCountByFuzzy", inputString);
	}
	
	public User checkUser(User user){
		return this.getUniqueOne("checkUser", user);
	}
}