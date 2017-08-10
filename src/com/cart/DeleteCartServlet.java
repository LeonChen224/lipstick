package com.cart;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.CopyOnWriteArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cart.dao.ProductDao;
import com.cart.dao.impl.ProductDaoImpl;
import com.cn.Product;


public class DeleteCartServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	System.out.println("Ω¯»ÎDeleteCartServet");
	String user_id = request.getParameter("user_id");
	Integer pid = Integer.parseInt(request.getParameter("pid"));
	System.out.println(user_id+pid);
	ProductDao pdl = new ProductDaoImpl();
	pdl.deleteCart(user_id,pid);
    request.getRequestDispatcher("ListCartServlet").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
