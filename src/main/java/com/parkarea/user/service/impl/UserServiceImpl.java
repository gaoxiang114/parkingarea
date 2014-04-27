package com.parkarea.user.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.parkarea.user.dao.UserDao;
import com.parkarea.user.model.User;
import com.parkarea.user.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService{

	@Resource(name="userDao")
	private UserDao userDao;
	
	public User getUser(int userId) {
		return userDao.getUser(userId);
	}

	public User checkUser(User user) {
		return userDao.checkUser(user);
	}

	@Override
	public void editPasswd(User user) {
		userDao.editPasswd(user);
	}

}
