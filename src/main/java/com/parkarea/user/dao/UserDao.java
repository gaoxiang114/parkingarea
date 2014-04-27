package com.parkarea.user.dao;

import org.springframework.stereotype.Component;

import com.parkarea.common.dao.BaseDao;
import com.parkarea.user.model.User;

@Component("userDao")
public class UserDao extends BaseDao {
	
	public User getUser(int id){
		return this.getUniqueOne("getUserById", 1);
	}
	
	public User checkUser(User user){
		return this.getUniqueOne("checkUser", user);
	}
	
	public void editPasswd(User user){
		this.update("editPasswd", user);
	}
}
