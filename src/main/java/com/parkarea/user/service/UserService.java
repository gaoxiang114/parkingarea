package com.parkarea.user.service;

import com.parkarea.user.model.User;

public interface UserService {
	/**
	 * 
	 * Description: 按用户的id来查询用户实体对象
	 * @param userId
	 * @return
	 */
	public User getUser(int userId);
	
	/**
	 * 
	 * Description: 按用户名检验是否是本系统用户
	 * @param userId
	 * @return
	 */
	public User checkUser(User user);
	
	public void editPasswd(User user);
}
