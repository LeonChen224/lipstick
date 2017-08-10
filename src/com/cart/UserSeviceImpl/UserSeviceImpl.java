package com.cart.UserSeviceImpl;

import sun.security.jgss.LoginConfigImpl;

import com.cart.CartSeviceUtils.serviceUtils;
import com.cart.dao.UserDao;
import com.cart.dao.impl.UserDaoImpl;
import com.cart.exception.UserExistException;
import com.cn.User;

//Ϊweb���ṩ���е�ҵ�����
public class UserSeviceImpl {
	// Ϊweb���ṩע�Ṧ��
	
	private UserDao dao = new UserDaoImpl();// ����ģʽ ���� spring
	public void register(User user) throws UserExistException {

		
		// �жϵ�ǰ�û��Ƿ����
		boolean b = dao.find(user.getUsername());
		if(b){
			throw new UserExistException();//����Ҫע����û��Ѿ����ڣ���web���׳�����ʱ�쳣 ����web�㴦���쳣���������Ѻ���ʾ
		}else{
			//��������ڣ�˵��û��ע��������ǽ����������ݿ�(�������ݿ�֮ǰ��������ܴ���)
			user.setPassword(serviceUtils.md5(user.getPassword()));
			dao.addUser(user);
		}

	}

	// Ϊweb���ṩ��¼����
	public User Login(String username, String password) {
		System.out.println("password"+password);
		System.out.println("username"+username);
		password=serviceUtils.md5(password);
		System.out.println("password"+password);
		System.out.println("username"+username);
		
		//����ҵ�
		return dao.find(username, password);

	}
	 
}
