package com.cart.dao;

import com.cn.User;

public interface UserDao {

	void addUser(User user);

	// �û��Ƿ�������ݿ���
	boolean find(String username);
	String  findid(String username);
	User find(String username, String password);

}
