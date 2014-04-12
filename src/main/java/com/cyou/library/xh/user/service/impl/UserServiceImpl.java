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

import com.cyou.library.xh.common.util.Md5ConverterUtil;
import com.cyou.library.xh.common.util.MyException;
import com.cyou.library.xh.common.util.Page;
import com.cyou.library.xh.user.dao.AssignRolesDao;
import com.cyou.library.xh.user.dao.DivisionPowerDao;
import com.cyou.library.xh.user.dao.UserDao;
import com.cyou.library.xh.user.domain.AssignRoles;
import com.cyou.library.xh.user.domain.Fun;
import com.cyou.library.xh.user.domain.Role;
import com.cyou.library.xh.user.domain.User;
import com.cyou.library.xh.user.service.UserService;

/**
 * @author lirenkui
 *
 */
@Service("userService")
public class UserServiceImpl implements UserService {
	
	@Resource(name="userDao")
	private UserDao userDao;
	@Resource(name = "assignRolesDao")
	private AssignRolesDao assignRolesDao;
	@Resource(name = "divisionPowerDao")
	private DivisionPowerDao divisionPowerDao;
	
	public int addUser(User user,int[] roleId) throws MyException {
		
		AssignRoles  assignRoles =  new AssignRoles();
		if(userDao.getUserByUserNum(user)==null){
			userDao.addUser(user);
			user = userDao.getUserByUserNum(user);
			assignRoles.setUserId(user.getUser_id());
			for(int temp = 0;temp<roleId.length;temp++){
				assignRoles.setRoleId(roleId[temp]);
				assignRolesDao.addAssignRoles(assignRoles);
			}
			return 1;
		}
		else
			throw new MyException("对不起此用户已存在，请重新命名！");
	}

	public User getUserByUserNum(User user) {
		return userDao.getUserByUserNum(user);
	}
	
	public User getUserByUserId(User user) {
		
		user = userDao.getUserByUserId(user);
		List<Role> assignList = null;
		assignList = assignRolesDao.getRolesList(user.getUser_id());
		user.setAssignList(assignList);
		return user;
	}

	public int updateUser(User user) {
		return userDao.updateUserByUserId(user);
	}
	public int updateUserMail(User user) {
		return userDao.updateUserMailByUserId(user);
	}

	public int getAllUserRecords() {
		return userDao.getAllUserRecords();
	}

	public List<User> getPageUserList(Page page) {
		return userDao.getPageUserList(page);
	}

	public int delUserList(List idList) {
		return userDao.delUserList(idList);
	}

	public int updateUserPassword(User user,String oldpwd,String newpwd)/* throws MyException */{
		
	//	if(userDao.getUserByUserId(user).getUser_password().equals(Md5ConverterUtil.Md5(newpwd))){
			user.setUser_password(Md5ConverterUtil.Md5(newpwd));
			return userDao.updateUserPassword(user);
/*		}
		else{
				throw new MyException("原密码输入错误！");
		}*/
	}

	public int getCountByNum(User user) {
		return userDao.getCountByNum(user);
	}

	public int getCountByDepart(User user) {
		return userDao.getCountByDepart(user);
	}

	public List<User> getPageListByNum(Page page) {
		return userDao.getPageListByNum(page);
	}

	public List<User> getPageListByDepart(Page page) {
		return userDao.getPageListByDepart(page);
	}

	public List<User> getAllUsers() {
		return userDao.getAllUsers();
	}

	public List<User> getUserPageList(int pageIndex, int pageSize, User user) {
		
		List<Role> assignList = null;
		List<User> userList = this.userDao.getUserPageList(pageIndex, pageSize, user);
		for(int temp = 0;temp<userList.size();temp++){
			user = userList.get(temp);
			assignList = (List<Role>) assignRolesDao.getRolesList(user.getUser_id());
			user.setAssignList(assignList);
			userList.set(temp, user);
		}
		return userList;
	}

	public int updateBorrowNumById(User user) {
		return this.userDao.updateBorrowNumById(user);
	}

	public List<User> getUserListByFuzzy(int pageIndex,int pageSize,String inputString,User user) {
		return this.userDao.getUserListByFuzzy(pageIndex,pageSize,inputString,user);
	}

	public int getCountByFuzzy(String inputString) {
		return this.userDao.getCountByFuzzy(inputString);
	}

	public User checkUser(User user) {
		return this.userDao.checkUser(user);
	}

	/**
	 * login:登录时装入权限
	 * @param User user
	 * @return 返回 Map<String,Object> 对象
	 */
	public Map<String,Object> login(User user) {
		
		//用来接收user对象
		User u = null;
		//循环中的临时参数，用来接收功能对象，并将其子节点结合存入其中
		Fun fun = null;
		//存放权限的列表
		List<Fun> funList = null;
		//角色的id列表
		List<Integer> roleIdList= null;
		//临时的list用来接收每个根节点的子节点集合
		List<Fun> tempList = null;
		Map<String,Object> permitMap = new HashMap<String,Object>();
		try {
			u = this.userDao.checkUser(user);
			if(u != null){
				//根据用户id查询出所属的角色id列表
				roleIdList = this.assignRolesDao.getRoleIdList(user);
				//通过所属的角色获取第一级的功能列表
				List<Fun> funRootList = this.divisionPowerDao.getRootFunList(roleIdList);
				//将第一级功能列表装入list中
				if(funRootList != null && funRootList.size() > 0){
					//为临时列表分配空间
					funList = new ArrayList<Fun>(funRootList.size());
					//按根节点id和角色id查出第二级的功能列表
					for(int i=0 ; i < funRootList.size() ; i ++){
						//枚举第一级的功能列表,放入临时对象中
						fun = funRootList.get(i);
						//调用获取二级功能列表的方法
						tempList = this.divisionPowerDao.getSecondFunList(fun.getFunId(), roleIdList);
						//将子节点存入bean中
						fun.setChild(tempList);
						//把每个对象放入list集合中
						funList.add(fun);
					}
					//将权限封装到map对象中
					permitMap.put("funList", funList);
				}
			}
			
			permitMap.put("roleIdList", roleIdList);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
		
		return permitMap;
	}

}
