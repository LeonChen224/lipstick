package com.cart;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cart.dao.ProductDao;
import com.cart.dao.impl.ProductDaoImpl;
import com.cn.User;

public class ListCartServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
				
		User user = (User) session.getAttribute("user");
		String user_id = (String) session.getAttribute("user_id");
		if(user != null){ //如果用户已经登录
			System.out.println("listcartsevlet中获取到user_id:"+user_id);
			ProductDaoImpl pdl = new ProductDaoImpl();
			session.setAttribute("cart", pdl.selectCart(user_id));
			session.setAttribute("sum", pdl.calcSum(user_id));
		}else{ //如果用户没有登录
			System.out.println("listcartsevlet中获取不到user_id");
		}
		
		request.getRequestDispatcher("JspCartPage/listCart.jsp").forward(request, response);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
