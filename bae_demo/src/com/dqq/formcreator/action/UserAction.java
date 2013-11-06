package com.dqq.formcreator.action;

import java.sql.Timestamp;
import java.util.Date;

import com.dqq.formcreator.biz.UserBiz;
import com.dqq.formcreator.po.User;

public class UserAction extends BaseAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7284252439661098878L;
	
	private String username;
	private String password;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String insert()
	{
		try {
			UserBiz userBiz = new UserBiz();
			User user = new User();
			user.setUsername(username);
			user.setPassword(password);
			user.setCreatedBy("admin");
			user.setCreatedDate(new Timestamp(new Date().getTime()));
			user.setDeptId("1");
			user.setDesc("descrptionDemo");
			user.setRoleIds("1");
			userBiz.insertUser(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "fail";
		}
		return SUCCESS;
	}
}
