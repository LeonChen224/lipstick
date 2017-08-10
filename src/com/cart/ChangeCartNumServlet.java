package com.cart;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cart.dao.impl.ProductDaoImpl;

public class ChangeCartNumServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String user_id = request.getParameter("user_id");
		//Integer num = Integer.parseInt(request.getParameter("num"));
		String num1 = request.getParameter("num");
		Integer num = null;
		if(num1 != null){
			num = Integer.parseInt(num1);
		}
		Integer pid = Integer.parseInt(request.getParameter("pid"));
		Integer price = Integer.parseInt(request.getParameter("price"));
		Integer oldtotal = Integer.parseInt(request.getParameter("oldtotal"));
		Integer newtotal = 0;
		newtotal = num * price;
		System.out.println("Ω¯»ÎChangeCartNumServlet£∫"+user_id+","+num+","+pid+","+newtotal);	
		ProductDaoImpl pdl = new ProductDaoImpl();
		pdl.changeCartNum(user_id,num,pid,newtotal);
		
		request.getRequestDispatcher("ListCartServlet").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
