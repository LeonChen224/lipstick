package com.admin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cart.dao.impl.AdminProinfoDaoImpl;

public class DeleteProServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("½øÈëdeleteproservlet");
		Integer pid = Integer.parseInt(request.getParameter("pid"));
		AdminProinfoDaoImpl adl = new AdminProinfoDaoImpl();
		boolean b = adl.deletePro(pid);
		//request.getRequestDispatcher("AdminAllProductsServlet").forward(request, response);
		response.sendRedirect("AdminAllProductsServlet");
		return;
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
