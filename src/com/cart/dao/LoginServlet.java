package com.cart.dao;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cart.CartSeviceUtils.TimeFormat;
import com.cart.UserSeviceImpl.UserSeviceImpl;
import com.cart.dao.impl.UserDaoImpl;
import com.cn.User;

public class LoginServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("loginservlet,java1111111");

		HttpSession session = request.getSession();
		String file = (String)session.getAttribute("file");
		System.out.println("接收到的初始登录页面地址："+file);

		String username = request.getParameter("username");
		String password = request.getParameter("password");		

		UserSeviceImpl userSeviceImpl = new UserSeviceImpl();
		User user = userSeviceImpl.Login(username, password);
		UserDao userDaoImpl = new UserDaoImpl();
		
		System.out.println("user::"+user);
		
		String codeRequest = request.getParameter("code");
		String codeSession = String.valueOf(session.getAttribute("code"));
		System.out.println(codeRequest + "....." + codeSession);

		String user_id = userDaoImpl.findid(username);
		session.setAttribute("user_id",user_id);
		System.out.println("loginservlet中获取user_id:"+session.getAttribute("user_id"));
 
		if (user != null && codeRequest.equalsIgnoreCase(codeSession)) {
			session.setAttribute("codeRequest", codeRequest);
			session.setAttribute("user", user);
			System.out.println("user"+user);
			
			//两段代码用于处理在详情页面未登录跳转
			String page = (String) session.getAttribute("page");
			String btnmsg = (String) session.getAttribute("btnmsg");
			if(page != null && file != null && btnmsg.equals("addnow")){
				System.out.println("loginservlet中获取page:"+page+"\n"+"loginservlet中获取file:"+file);
				if(page.equals("InsertCartServlet") && file.equals("JspCartPage/login.jsp")){
					System.out.println("获取加入购物车页面成功");
					//response.sendRedirect("InsertCartServlet");
					request.getRequestDispatcher("InsertCartServlet").forward(request, response);
					return;
				} 
			}
			if(page != null && file != null && btnmsg.equals("buynow")){
				System.out.println("loginservlet中获取page:"+page+"\n"+"loginservlet中获取file:"+file);
				if(page.equals("BuyCartNowServlet") && file.equals("JspCartPage/login.jsp")){
					System.out.println("获取立即购买页面成功");
					request.getRequestDispatcher("BuyCartNowServlet").forward(request, response);
					return;
				} 
			}
			if(file.equals("JspCartPage/Home.jsp") || file.equals("JspCartPage/login.jsp") || file.equals("JspCartPage/addCart.jsp") || file.equals("JspCartPage/listCart.jsp")){					
				response.sendRedirect("JspCartPage/Home.jsp");
				//request.getRequestDispatcher("JspCartPage/Home.jsp").forward(request, response);
			  return;
			}
			
			
			request.getRequestDispatcher(file).forward(request, response);

			//response.sendRedirect(request.getContextPath()+file);
			return;
		}
		
		request.setAttribute("message", "登录错误！！！");
		request.getRequestDispatcher("JspCartPage/login.jsp").forward(request, response);


	}
	

}
