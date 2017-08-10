package com.cart.dao;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class logoutSrevlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//只得内存的session
		HttpSession session=request.getSession(false);
		if(session!=null){
			session.removeAttribute("user");
			System.out.println("移除了user");
		}
//	    request.setAttribute("message", "注销成功！！！<meta http-equiv='refresh' content='10;Uri='index.jsp''>");
//	    request.getRequestDispatcher("/message").forward(request, response);
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		out.print("注销成功,三秒钟跳回首页！！！");
		response.setHeader("refresh","3;url=JspCartPage/Home.jsp");

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
