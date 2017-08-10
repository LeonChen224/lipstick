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
		//У��ɹ�������service�е�ע�᷽��
    
		UserSeviceImpl seviceImpl = new UserSeviceImpl();
		User user = new User();
		user.setUser_id(WebUtils.generateID());
		session.setAttribute("user_id", WebUtils.generateID());
		user.setPassword(request.getParameter("password"));
		user.setUsername(request.getParameter("username"));

		//��form�е�����copy��user��ȥ
		//WebUtils.copyBean(form, user);

		try {
			System.out.println("111111" + user.getUsername());
			System.out.println("2222222" + user.getPassword());
			seviceImpl.register(user);
			// service����ɹ���ע��ɹ�����Ϣ
			out.println("��ϲ�㣬ע��ɹ�");
			response.setHeader("refresh", "3;uri=JspCartPage/Home.jsp");
			//request.setAttribute("message", "��ϲ�㣬ע��ɹ�");
			//request.getRequestDispatcher("JspCartPage/message.jsp").forward(request,response);
			return;
		} catch (UserExistException e) {
			// service�����ɹ����Ѿ�����,���ص�ע��ҳ��
			form.getErrors().put("username", "�û��Ѿ����ڣ�����");
			request.setAttribute("form", form);
			// request.setAttribute("message", "�û��Ѿ����ڣ�����");
			request.getRequestDispatcher("JspCartPage/register.jsp").forward(request,response);
			return;
		} catch (Exception e) {
			// �����ɹ� �����������⣬��ת����վ��ȫ����Ϣ��ʾҳ��
			request.setAttribute("message", "����������δ֪���󣡣���");
			request.getRequestDispatcher("JspCartPage/message.jsp").forward(request,response);
			return;
		}
	
	}

	
}