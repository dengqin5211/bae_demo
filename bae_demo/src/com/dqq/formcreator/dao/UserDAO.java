package com.dqq.formcreator.dao;

import java.util.List;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.dqq.formcreator.po.User;
import com.dqq.formcreator.util.MyBatisUtil;

public class UserDAO {

	static SqlSessionFactory sqlSessionFactory = null;
	static {
		sqlSessionFactory = MyBatisUtil.getSqlSessionFactory();
	}

	public void insertUser(User user) {
		SqlSession sqlSession = sqlSessionFactory.openSession(ExecutorType.BATCH);
		sqlSession.insert("insertUser", user);
		sqlSession.close();
	}
	
	public User getUserByUsername(String username) {
		SqlSession sqlSession = sqlSessionFactory.openSession(ExecutorType.BATCH);
		List list = sqlSession.selectList("getUser");
		sqlSession.close();
		if(list.isEmpty())
		{
			return null;
		}
		else
		{
			return (User) list.get(0);
		}
	}

}
