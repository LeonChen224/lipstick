package com.cart.UserSeviceImpl;

import sun.security.jgss.LoginConfigImpl;

import com.cart.CartSeviceUtils.serviceUtils;
import com.cart.dao.UserDao;
import com.cart.dao.impl.UserDaoImpl;
import com.cart.exception.UserExistException;
import com.cn.User;

//为web层提供所有的业务服务
public class UserSeviceImpl {
	// 为web层提供注册功能
	
	private UserDao dao = new UserDaoImpl();// 工厂模式 或者 spring
	public void register(User user) throws UserExistException {

		
		// 判断当前用户是否存在
		boolean b = dao.find(user.getUsername());
		if(b){
			throw new UserExistException();//发现要注册的用户已经存在，给web层抛出编译时异常 提醒web层处理异常，并给出友好提示
		}else{
			//如果不存在，说明没有注册过，我们将他加入数据库(置入数据库之前给密码加密处理)
			user.setPassword(serviceUtils.md5(user.getPassword()));
			dao.addUser(user);
		}

	}

	// 为web层提供登录功能
	public User Login(String username, String password) {
		System.out.println("password"+password);
		System.out.println("username"+username);
		password=serviceUtils.md5(password);
		System.out.println("password"+password);
		System.out.println("username"+username);
		
		//如果找到
		return dao.find(username, password);

	}
	 
}
