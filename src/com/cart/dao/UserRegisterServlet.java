package com.cart.dao;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cart.CartSeviceUtils.WebUtils;
import com.cart.UserSeviceImpl.UserSeviceImpl;
import com.cart.exception.UserExistException;
import com.cart.web.form.RegisterForm;
import com.cn.User;


public class UserRegisterServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setCharacterEncoding("utf-8");
		response.setContentType("textml;utf-8");
		response.setHeader("Content-Type", "character=utf-8");


		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		RegisterForm form = WebUtils.request2Bean(request, RegisterForm.class);
		boolean b = form.validate();
		if (!b) {
			request.setAttribute("form", form);
			request.getRequestDispatcher("JspCartPage/register.jsp").forward(request,response);
			return;
		}
		//校验成功，调用service中的注册方法
    
		UserSeviceImpl seviceImpl = new UserSeviceImpl();
		User user = new User();
		user.setUser_id(WebUtils.generateID());
		session.setAttribute("user_id", WebUtils.generateID());
		user.setPassword(request.getParameter("password"));
		user.setUsername(request.getParameter("username"));

		//把form中的属性copy到user中去
		//WebUtils.copyBean(form, user);

		try {
			System.out.println("111111" + user.getUsername());
			System.out.println("2222222" + user.getPassword());
			seviceImpl.register(user);
			// service处理成功，注册成功的消息
			out.println("恭喜你，注册成功");
			response.setHeader("refresh", "3;uri=JspCartPage/Home.jsp");
			//request.setAttribute("message", "恭喜你，注册成功");
			//request.getRequestDispatcher("JspCartPage/message.jsp").forward(request,response);
			return;
		} catch (UserExistException e) {
			// service处理不成功，已经存在,跳回到注册页面
			form.getErrors().put("username", "用户已经存在！！！");
			request.setAttribute("form", form);
			// request.setAttribute("message", "用户已经存在！！！");
			request.getRequestDispatcher("JspCartPage/register.jsp").forward(request,response);
			return;
		} catch (Exception e) {
			// 处理不成功 且是其它问题，跳转到网站的全局消息显示页面
			request.setAttribute("message", "服务器出现未知错误！！！");
			request.getRequestDispatcher("JspCartPage/message.jsp").forward(request,response);
			return;
		}
	
	}

	
}