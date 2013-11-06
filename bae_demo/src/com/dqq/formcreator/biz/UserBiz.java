package com.dqq.formcreator.biz;

import com.dqq.formcreator.dao.UserDAO;
import com.dqq.formcreator.po.User;

public class UserBiz {


	public void insertUser(User user) {
		new UserDAO().insertUser(user);
	}
	
	public User getUserByUsername(String username) {
		return new UserDAO().getUserByUsername(username);
	}

}
