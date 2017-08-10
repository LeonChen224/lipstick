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
        System.out.println("����insertCartServlet");
		
		//��ȡ�û�
		User user = (User) session.getAttribute("user");
		//��ȡҳ��
		String page1 = (String) session.getAttribute("page");
		String file = (String)session.getAttribute("file");
		
		ProductDaoImpl pdl = new ProductDaoImpl();
				
		if(user != null && page1 == null){
			System.out.println("�û��ѵ�¼��"+user);		   
			String user_id = request.getParameter("user_id");
			//��ȡ��Ʒ��Ϣ
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
		    	//request.setAttribute("message", "��~�ѳɹ����빺�ﳵ");
		    }
		    if(!b){
		    	System.out.println("fail");
		    	//request.setAttribute("message", "�Բ��𣬼��빺�ﳵʧ�ܣ�");
		    }
			//System.out.println(request.getAttribute("message"));
			request.getRequestDispatcher("JspCartPage/successAdd.jsp").forward(request, response); 
			return;
		}
		
		//�û���½�� ȡsession ��ֵ
		if(user != null && page1.equals("InsertCartServlet") && file.equals("JspCartPage/login.jsp")){
			System.out.println("��¼�����sessionȡֵ����");
			
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
		    System.out.println("��¼��������"+b);
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
			//û�е�¼
			System.out.println("�û�û�е�¼");
			String uri = request.getRequestURI();
			System.out.println("uri:"+uri);
			String ss[] = uri.split("/");
			String page = ss[ss.length-1];//ȡ���һ������
			System.out.println("page:"+page);
			session.setAttribute("page", page);
			session.setAttribute("btnmsg", "addnow");
			//��ȡ��Ʒ��Ϣ
			Integer productId = Integer.parseInt(request.getParameter("productId"));
			System.out.println("productId:"+productId);
			String productName = request.getParameter("productName");
			Integer productPrice = Integer.parseInt(request.getParameter("productPrice"));
			String productProvider = request.getParameter("productProvider");
			Integer num = Integer.parseInt(request.getParameter("num"));
			Integer total = Integer.parseInt(request.getParameter("total"));
			String product_path = request.getParameter("product_path");
			String product_type = request.getParameter("product_type");
			
			//���û���ѡ����Ʒ��Ϣ�ݴ���session��
			session.setAttribute("templist", pdl.saveTempCart(productId,productName,productPrice,productProvider,num,total,product_path,product_type)) ;
			response.sendRedirect("JspCartPage/login.jsp");
			return;
		}

	}

}
