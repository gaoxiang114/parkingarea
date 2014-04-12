/**
 * 
 */
package com.cyou.library.xh.user.service;

import java.util.List;
import java.util.Map;

import com.cyou.library.xh.common.util.MyException;
import com.cyou.library.xh.common.util.Page;
import com.cyou.library.xh.user.domain.Fun;
import com.cyou.library.xh.user.domain.User;

/**
 * @author lirenkui
 *
 */
public interface UserService {

	
	/**
	 * addUser:添加用户
	 * @author lirenkui
	 * @param user
	 * @return Integer 影响的行数
	 * @throws MyException 
	 */
	public int addUser(User user,int[] roleId) throws MyException;
	
	/**
	 * getUserById:通过loginId得到用户对象数据User
	 * @author lirenkui
	 * @param user
	 * @return User
	 */
	public User getUserByUserNum(User user);
	
	/**
	 * getUserByUserId:通过用户的user_id得到user对象
	 * @author lirenkui
	 * @param user
	 * @return
	 */
	public User getUserByUserId(User user);
	
	/**
	 * updateUser:根据用户的user_id修改用户信息
	 * @author lirenkui
	 * @param user
	 * @return int返回修改影响的记录数
	 */
	public int updateUser(User user);
	
	public int updateUserMail(User user);
	
	/**
	 * getAllUserRecords:得到用户记录总数
	 * @author lirenkui
	 * @return int 用户记录条数
	 */
	public int getAllUserRecords();
	
	/**
	 * getAllUsers:返回所有用户记录集合
	 * @author lirenkui
	 * @return
	 */
	public List<User> getAllUsers();
	
	/**
	 * getUserCountByUserNum:根据员工编号检索出来检索用户记录总数
	 * @author lirenkui
	 * @param user
	 * @return
	 */
	public int getCountByNum(User user);
	
	/**
	 * getCountByDepart:根据员工所属部门检索用户总记录数
	 * @author lirenkui
	 * @param user
	 * @return
	 */
	public int getCountByDepart(User user);
	
	/**
	 * getPageListByNum:根据员工编号检索出当前分页要显示的数据集合
	 * @author lirenkui
	 * @param page
	 * @return
	 */
	public List<User> getPageListByNum(Page page);
	
	/**
	 * getUserPageList:返回分页中要查看页的数据集合
	 * @author lirenkui
	 * @param pageIndex
	 * @param pageSize
	 * @param user
	 * @return
	 */
	public List<User> getUserPageList(int pageIndex,int pageSize,User user);
	/**
	 * getPageListByDepart:根据所属部门检索当前页面要显示的数据集合
	 * @author lirenkui
	 * @param page
	 * @return
	 */
	public List<User> getPageListByDepart(Page page);
	
	/**
	 * getPageUserList:返回分页中要查看页的数据集合
	 * @author lirenkui
	 * @param page
	 * @return List<User> 分页显示中某页的数据集合
	 */
	public List<User> getPageUserList(Page page);
	
	/**
	 * delUserList:批量删除用户记录
	 * @author lirenkui
	 * @param userList
	 * @return
	 */
	public int delUserList(List userList);
	
	/**
	 * updateUserPassword:跟新用户密码（需要先验证）
	 * @author lirenkui
	 * @param user
	 * @param oldpwd
	 * @param newpwd
	 * @return
	 * @throws MyException 
	 */
	public int updateUserPassword(User user,String oldpwd,String newpwd);
	
	/**
	 * updateBorrowNumById:更新userid的借书数量
	 * @author lirenkui
	 * @param user
	 * @return
	 */
	public int updateBorrowNumById(User user);
	
	/**
	 * getUserListByFuzzy:模糊查询获取对应的user集合
	 * @author lirenkui
	 * @param pageIndex
	 * @param pageSize
	 * @param inputString
	 * @param user
	 * @return
	 */
	public List<User> getUserListByFuzzy(int pageIndex,int pageSize,String inputString,User user);
	
	/**
	 * getCountByFuzzy:获取模糊查询对应集合的记录书
	 * @author lirenkui
	 * @param inputString
	 * @return
	 */
	public int getCountByFuzzy(String inputString);
	
	public User checkUser(User user);
	
	public Map<String,Object> login(User user);
}