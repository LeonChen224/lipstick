package com.cart;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Vector;
import java.util.concurrent.CopyOnWriteArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cart.dao.impl.ProductDaoImpl;
import com.cn.Cart;
import com.cn.Product;
import com.cn.User;


public class BuyCartServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("进入buyCartServlet");
		HttpSession session = request.getSession();			
		String[] pids = request.getParameterValues("single");
		
		String user_id = (String) session.getAttribute("user_id");
		Object obj = session.getAttribute("cart");
		System.out.println("obj:"+obj);
		if(obj == null){
			return;
		}
		//根据pids循环遍历到cart中的商品显示对应的商品
		ProductDaoImpl pdl = new ProductDaoImpl();
		ArrayList<Cart> cart = (ArrayList<Cart>) obj;
		if(pids != null){
			System.out.println("pids不为空");			
			session.setAttribute("buycart", pdl.findCart(user_id,pids,cart));
			ArrayList<Cart> buycartlist = (ArrayList<Cart>) session.getAttribute("buycart");
			int sum = 0;
			int nums = 0;			
			for(Cart buycart:buycartlist){
				sum += buycart.getTotal();
				nums += buycart.getNum();
			}
			System.out.println("购买的总和："+sum);
			session.setAttribute("buysum", sum);
			System.out.println("nums:"+nums);
			session.setAttribute("nums", nums);
		}
		//获取用户的收货信息
		String address = "";
		String username = "";
		String phone = "";
		request.setAttribute("deliverylist", pdl.findDeliveryInfo(user_id));
		ArrayList<User> deliverylist = (ArrayList<User>) request.getAttribute("deliverylist");
		for(User userdelivery:deliverylist){			
			username = userdelivery.getUsername();
			address = userdelivery.getAddress();
			phone = userdelivery.getPhone();
			System.out.println("address1:"+address);
		}
		System.out.println("address2:"+address);
		request.setAttribute("address", address);
		request.setAttribute("username", username);
		request.setAttribute("phone", phone);
		request.getRequestDispatcher("JspCartPage/buyCart.jsp").forward(request, response);
	}

   }

