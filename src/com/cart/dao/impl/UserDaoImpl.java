package com.cart.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.jws.soap.SOAPBinding.Use;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sun.security.timestamp.TSRequest;

import com.cart.dao.UserDao;
import com.cart.factory.DBHelp;
import com.cn.User;
import com.sun.org.apache.regexp.internal.recompile;
import com.sun.xml.internal.ws.client.RequestContext;

public class UserDaoImpl implements UserDao {

	private DBHelp db = new DBHelp();
	private PreparedStatement ps = null;
	private Connection conn = null;
	private ResultSet rs = null;
	private Statement stmt;

	// 增加用户信息

	public void addUser(User user) {
		System.out.println("user" + user);
		System.out.println(user.getPassword());
		System.out.println("1111111");

		String sql = "insert into userlogin(user_id,username,password,phone,mail,address) values(?,?,?,?,?,?)";

		System.out.println(sql);
		try {
			// System.out.println("2222");
			conn = db.getConnection();
			ps = conn.prepareStatement(sql);
			System.out.println("接口实现类");
			ps.setString(1, user.getUser_id());
			ps.setString(2, user.getUsername());
			ps.setString(3, user.getPassword());
			ps.setString(4, user.getPhone());
			ps.setString(5, user.getMail());
			ps.setString(6, user.getAddress());

			// System.out.println("user"+user.getUsername());
			int i = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		db.release(conn, ps, rs);
	}

	// 用户是否存在数据库里
	public boolean find(String username) {
		String sql = "select username from userlogin where username=?";

		try {
			System.out.println("find boolean");
			conn = db.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			System.out.println("username" + username);
			rs = ps.executeQuery();
			while (rs.next()) {
				// System.out.println("rs.getString(username)"+rs.getString("username"));
				if (rs.getString("username").equals(username)) {
					return true;
				}
			}
			// System.out.println("ps"+ps);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		db.release(conn, ps, rs);
		return false;

	}
	
	// 找到用户id
		public String findid(String username) {
			String sql = "select user_id from userlogin where username=?";

			try {
				System.out.println("findid"+username);
				conn = db.getConnection();
				ps = conn.prepareStatement(sql);
				ps.setString(1, username);
				System.out.println("username" + username);
				rs = ps.executeQuery();
				if (rs.next()) {
					// System.out.println("rs.getString(username)"+rs.getString("username"));
					//if (rs.getString("username").equals(username)) {
						System.out.println( rs.getString(1));
						return rs.getString(1);
					//}
				}else{
					System.out.println("1111");
				}
				// System.out.println("ps"+ps);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			db.release(conn, ps, rs);
			return null;

		}


	// 根据用户名和密码进行查找
	public User find(String username, String password) {
		User user = new User();

		try {
			conn = db.getConnection();
			stmt=conn.createStatement();
			String sql = "select username,password from userlogin";
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				//System.out.println(rs.getString("password"));
				//System.out.println(rs.getString("username"));
				if (username.equals(rs.getString("username"))
						&& password.equals(rs.getString("password"))) {
					//System.out.println(rs.getString("username")+"rs.getString(username)");
					//System.out.println(rs.getString("password")+"rs.getString(password)");
					user.setPassword(rs.getString("password"));
					user.setUsername(rs.getString("username"));
					//System.out.println("user find"+user);
					return user;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		db.release(conn, ps, rs);
		return null;
	}

	//通过user_id获取收货人信息
	public ArrayList<User> findUserInfo(String user_id) {
		String sql = "select username,address,phone from userlogin where user_id = ?";
		ArrayList<User> userInfolist = new ArrayList<User>();
		try {
			conn = db.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, user_id);
			rs = ps.executeQuery();
			while(rs.next()){
				userInfolist.add(new User(rs.getString(1),rs.getString(2),rs.getString(3)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return userInfolist;
		
		
	}

	

	// 在这里可以写管理员删除注册人信息
}
