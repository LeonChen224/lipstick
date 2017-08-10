package com.cart;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;
import java.util.concurrent.CopyOnWriteArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cart.dao.ProductDao;
import com.cart.dao.impl.ProductDaoImpl;
import com.cart.factory.DBHelp;
import com.cn.Cart;
import com.cn.Product;
import com.cn.User;
import com.cn.TempCart;


public class InsertCartServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//PrintWriter out = response.getWriter();
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		HttpSession session = request.getSession();
        System.out.println("进入insertCartServlet");
		
		//获取用户
		User user = (User) session.getAttribute("user");
		//获取页面
		String page1 = (String) session.getAttribute("page");
		String file = (String)session.getAttribute("file");
		
		ProductDaoImpl pdl = new ProductDaoImpl();
				
		if(user != null && page1 == null){
			System.out.println("用户已登录："+user);		   
			String user_id = request.getParameter("user_id");
			//获取产品信息
			Integer productId = Integer.parseInt(request.getParameter("productId"));
			System.out.println("productId:"+productId);
			String productName = request.getParameter("productName");
			Integer productPrice = Integer.parseInt(request.getParameter("productPrice"));
			String productProvider = request.getParameter("productProvider");
			Integer num = Integer.parseInt(request.getParameter("num"));
			Integer total = Integer.parseInt(request.getParameter("total"));
			String product_path = request.getParameter("product_path");
			String product_type = request.getParameter("product_type");
			System.out.println(user_id+productName+productPrice+productProvider+num+total+product_path+product_type);	
			
		    boolean b = pdl.insertCart(user_id, productId, productName, productPrice, productProvider, num, total,product_path,product_type);
	        System.out.println("b:"+b);
	        
		    if(b){
		    	System.out.println("success");
		    	ArrayList<Cart> successlist = new ArrayList<Cart>();
		    	successlist.add(new Cart(user_id,productId,productName,productPrice,productProvider,num,total,product_path,product_type));
		    	request.setAttribute("successlist", successlist);
		    	//request.setAttribute("message", "亲~已成功加入购物车");
		    }
		    if(!b){
		    	System.out.println("fail");
		    	//request.setAttribute("message", "对不起，加入购物车失败！");
		    }
			//System.out.println(request.getAttribute("message"));
			request.getRequestDispatcher("JspCartPage/successAdd.jsp").forward(request, response); 
			return;
		}
		
		//用户登陆完 取session 的值
		if(user != null && page1.equals("InsertCartServlet") && file.equals("JspCartPage/login.jsp")){
			System.out.println("登录后进入session取值部分");
			
			ArrayList<TempCart> templist = (ArrayList<TempCart>) session.getAttribute("templist");
			String user_id = (String) session.getAttribute("user_id");
			Integer pid = 0;
			String pname = "";
			Integer price = 0;
			String provider = "";
			Integer pnum = 0;
			Integer ptotal = 0;
			String pproduct_path = "";
			String pproduct_type = "";
		    for(TempCart tempcart:templist){						
				pid = tempcart.getPid();
				pname =  tempcart.getPname();
				price = tempcart.getPrice();
				provider = tempcart.getProvider();
				pnum = tempcart.getNum();
				ptotal = tempcart.getTotal();
				pproduct_path = tempcart.getProduct_path();	
				pproduct_type = tempcart.getProduct_type();
		    }
		    System.out.println(user_id+","+pid+","+pname+","+price+","+provider+","+pnum+","+ptotal+","+pproduct_path);
		    boolean b = pdl.insertCart(user_id, pid, pname, price, provider, pnum, ptotal,pproduct_path,pproduct_type);
		    System.out.println("登录后加入与否："+b);
		    if(b){
		    	System.out.println("success");
			    ArrayList<Cart> successlist = new ArrayList<Cart>();
		    	successlist.add(new Cart(user_id,pid,pname,price,provider,pnum,ptotal,pproduct_path,pproduct_type));
		    	request.setAttribute("successlist", successlist);			    
		    }
		    if(!b){
		    	System.out.println("fail");
		    }
		    request.getRequestDispatcher("JspCartPage/successAdd.jsp").forward(request, response);
		}
		
		if(user == null){ 
			//没有登录
			System.out.println("用户没有登录");
			String uri = request.getRequestURI();
			System.out.println("uri:"+uri);
			String ss[] = uri.split("/");
			String page = ss[ss.length-1];//取最后一个数组
			System.out.println("page:"+page);
			session.setAttribute("page", page);
			session.setAttribute("btnmsg", "addnow");
			//获取产品信息
			Integer productId = Integer.parseInt(request.getParameter("productId"));
			System.out.println("productId:"+productId);
			String productName = request.getParameter("productName");
			Integer productPrice = Integer.parseInt(request.getParameter("productPrice"));
			String productProvider = request.getParameter("productProvider");
			Integer num = Integer.parseInt(request.getParameter("num"));
			Integer total = Integer.parseInt(request.getParameter("total"));
			String product_path = request.getParameter("product_path");
			String product_type = request.getParameter("product_type");
			
			//将用户所选的商品信息暂存在session中
			session.setAttribute("templist", pdl.saveTempCart(productId,productName,productPrice,productProvider,num,total,product_path,product_type)) ;
			response.sendRedirect("JspCartPage/login.jsp");
			return;
		}

	}

}
