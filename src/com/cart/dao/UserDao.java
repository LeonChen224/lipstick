package com.cart.dao;

import com.cn.User;

public interface UserDao {

	void addUser(User user);

	// 用户是否存在数据库里
	boolean find(String username);
	String  findid(String username);
	User find(String username, String password);

}
