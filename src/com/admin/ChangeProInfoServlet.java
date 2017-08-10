package com.admin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cart.dao.impl.AdminProinfoDaoImpl;

public class ChangeProInfoServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("进入changeproinfoservlet");
		Integer pid = Integer.parseInt(request.getParameter("pid"));
		//修改商品名称
		String newpname = request.getParameter("newpname");
		if(newpname != null){
			System.out.println("newpname:"+newpname);
			AdminProinfoDaoImpl adl = new AdminProinfoDaoImpl();
			adl.changePname(newpname,pid);
			//request.getRequestDispatcher("AdminAllProductsServlet").forward(request, response);
			response.sendRedirect("AdminAllProductsServlet");
			return;
		}
		
		//修改商品名称
		String newprices = request.getParameter("newprice");
		if(newprices != null){
			Integer newprice = Integer.parseInt(newprices);
			System.out.println("newprice:"+newprice);
			AdminProinfoDaoImpl adl = new AdminProinfoDaoImpl();
			adl.changePrice(newprice,pid);
			//request.getRequestDispatcher("AdminAllProductsServlet").forward(request, response);
			response.sendRedirect("AdminAllProductsServlet");
			return;
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		}
	}


