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

		//ֻ���ڴ��session
		HttpSession session=request.getSession(false);
		if(session!=null){
			session.removeAttribute("user");
			System.out.println("�Ƴ���user");
		}
//	    request.setAttribute("message", "ע���ɹ�������<meta http-equiv='refresh' content='10;Uri='index.jsp''>");
//	    request.getRequestDispatcher("/message").forward(request, response);
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		out.print("ע���ɹ�,������������ҳ������");
		response.setHeader("refresh","3;url=JspCartPage/Home.jsp");

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
