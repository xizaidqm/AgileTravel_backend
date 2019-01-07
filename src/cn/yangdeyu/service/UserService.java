package cn.yangdeyu.service;

import cn.yangdeyu.Exception.UserException;
import cn.yangdeyu.bean.User;
import cn.yangdeyu.dao.UserDao;

public class UserService {
	private UserDao userDao = new UserDao();
	
	public User findById(String openid) {
		return userDao.findById(openid);
	}
	
	public void addUser(User user) throws UserException {
		User tuser = userDao.findById(user.getOpenid());
		if(tuser!=null) throw new UserException("you have been registered");
		userDao.addUser(user);
	}
	
	public void updateUser() {
		
	}

}
