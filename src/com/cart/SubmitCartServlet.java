package com.cart;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cart.dao.impl.CustomerDaoImpl;
import com.cart.dao.impl.ProductDaoImpl;
import com.cart.factory.DBHelp;
import com.cn.Cart;
import com.cn.Product;
public class SubmitCartServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("����submitCartServlet");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setHeader("Content-Type", "text/html;character=utf-8");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		
		CustomerDaoImpl cdl = new CustomerDaoImpl();
		
		//��ȡ�û��ջ���ַ��Ϣ,���е�
		String user_id = (String) session.getAttribute("user_id");
		String cname = request.getParameter("customer");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		Integer num = Integer.parseInt(request.getParameter("num"));
		System.out.println(session.getAttribute("nums"));
		
		String sums = request.getParameter("sum");
		String sumsstr[] = sums.split("��");
		Integer sum = Integer.parseInt(sumsstr[1]);
		System.out.println("ת����sum:"+sum);

		
		//�����ӹ��ﳵ��ѡ��������Ʒ���붩�������ݿ�
		boolean b = true;
		request.setAttribute("ordertime",cdl.ordertime());
		request.setAttribute("orderno", cdl.createOrderno());
		String ordertime = (String) request.getAttribute("ordertime");
		String orderno = (String) request.getAttribute("orderno");			
		System.out.println("ordertime:"+ordertime+"\n"+"orderno:"+orderno);
		
		ArrayList<Cart> buycartlist = (ArrayList<Cart>) session.getAttribute("buycart");
		//������ϲ�Ϊ�գ�˵���ӹ��ﳵѡ����ת���������
		if(buycartlist != null){
			//��ȡ���������ܼ�Ǯ								
			Integer nums = (Integer) session.getAttribute("nums");		
			//Integer buysum = (Integer) session.getAttribute("buysum");	
			
			Integer pid = 0;
			String pname = "";		
			Integer price = 0;
			Integer total = 0;		
			String provider = "";
			String product_type = "";
			
			for(Cart buycart:buycartlist){
				pid = buycart.getPid();
				pname = buycart.getPname();
				price = buycart.getPrice();
				provider = buycart.getProvider();
				num = buycart.getNum();
				total = buycart.getTotal();
				product_type = buycart.getProduct_type();
				b = cdl.insertInfo(user_id,cname,pid,pname,price,num,nums,total,sum,provider,product_type,phone,address,ordertime,orderno);
			}
		}else{
			//�������Ϊ�գ�˵��������ҳ��ֱ�ӹ����
			Integer pid = Integer.parseInt(request.getParameter("pid"));
			String pname = request.getParameter("pname");
			String prices = request.getParameter("price");
			String pricestr[] = prices.split("��");			
			Integer price = Integer.parseInt(pricestr[1]);
			Integer nums = num; 
			String totals = request.getParameter("total");
			String totalstr[] = totals.split("��");
			Integer total = Integer.parseInt(totalstr[1]);
			String provider = request.getParameter("provider");
			String product_type = request.getParameter("product_type");
			b = cdl.insertInfo(user_id,cname,pid,pname,price,num,nums,total,sum,provider,product_type,phone,address,ordertime,orderno);
		}
	
		//�����ɹ������ɶ�����		
		if(b){
			System.out.println("��������ɹ�");			
			request.getRequestDispatcher("JspCartPage/order.jsp").forward(request, response);
			return;
		}
		if(!b){
			System.out.println("�������ʧ��");
			response.sendRedirect("JspCartPage/orderfail.jsp");
		}
	
	 

	}

}
