package com.cart;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cart.dao.impl.ProductDaoImpl;
import com.cart.dao.impl.UserDaoImpl;
import com.cn.Product;
import com.cn.TempCart;
import com.cn.User;

public class BuyCartNowServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("����BuyCartNowServlet");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		HttpSession session = request.getSession();
		
		ProductDaoImpl pdl = new ProductDaoImpl();
		UserDaoImpl udl = new UserDaoImpl();
		
		//��ȡ�û�
		User user = (User) session.getAttribute("user");
		//��ȡҳ��
		String page1 = (String) session.getAttribute("page");
		String file = (String)session.getAttribute("file");
		//����û��ѵ�¼ֱ�ӻ�ȡ��Ʒ��Ϣ
		if(user != null && page1 == null){
			//��ȡ�ջ���Ϣ
			String user_id = (String) session.getAttribute("user_id");
			request.setAttribute("userInfo", udl.findUserInfo(user_id));
			
			Integer pid = Integer.parseInt(request.getParameter("productId"));
			System.out.println("pid:"+pid);
			Integer num = Integer.parseInt(request.getParameter("num"));
			System.out.println("num:"+num);
			Integer price = Integer.parseInt(request.getParameter("productPrice"));
			System.out.println("price:"+price);
			int total = 0;
			total = num * price;
			System.out.println("total:"+total);
			request.setAttribute("total", total);
			request.setAttribute("num", num);						
			request.setAttribute("buyProlist",pdl.buyCartNow(pid));
			request.getRequestDispatcher("JspCartPage/buyCartNow.jsp").forward(request, response);
			return;
		}
		
		//�û���½�� ȡsessionֵ
		if(user != null && page1.equals("BuyCartNowServlet") && file.equals("JspCartPage/login.jsp")){
			System.out.println("�û���½�꣬ȡsessionֵ");
			String user_id = (String) session.getAttribute("user_id");
			//����user_id��ȡ�û��ջ���Ϣ,ȥ�µ�ҳ��ѭ������
			request.setAttribute("userInfo", udl.findUserInfo(user_id));
			//ȡ����¼ǰ����session�е���Ʒ��Ϣ,ȥ�µ�ҳ��ѭ������
			ArrayList<TempCart> tempbuylist = (ArrayList<TempCart>) session.getAttribute("tempbuylist");
			int price = 0;
			int num = 0;
			
			request.setAttribute("buyProlist", tempbuylist);
		    for(TempCart tempbuy:tempbuylist){
		    	num = tempbuy.getNum();
		    	price = tempbuy.getPrice();
		    }
		    int total = num * price;
		    request.setAttribute("num", num);
		    request.setAttribute("total", total);
		    request.getRequestDispatcher("JspCartPage/buyCartNow.jsp").forward(request, response);
			return;
		}
		
		//����û�û�е�¼���Ƚ��������Ʒ�����������ض���login
		if(user == null){
			//û�е�¼
			System.out.println("���������û�û�е�¼");
			String uri = request.getRequestURI();
			System.out.println("uri:"+uri);
			String ss[] = uri.split("/");
			String page = ss[ss.length-1];//ȡ���һ������
			System.out.println("page:"+page);
			session.setAttribute("page", page);
			session.setAttribute("btnmsg", "buynow");
			//��ȡ�������Ʒ��Ϣ
			Integer pid = Integer.parseInt(request.getParameter("productId"));
			String pname = request.getParameter("productName");
			Integer price = Integer.parseInt(request.getParameter("productPrice"));
			String provider = request.getParameter("productProvider");
			String product_path = request.getParameter("productPath");
			String product_type = request.getParameter("productType");
			Integer num = Integer.parseInt(request.getParameter("num"));
			Integer nums = num;			
			System.out.println("num:"+num);
			int total = 0;
			total = num * price;
			System.out.println("total:"+total);
			Integer sum = total;
			System.out.println("pname:"+pname);
			session.setAttribute("tempbuylist", pdl.saveTempBuy(pid,pname,price,num,total,nums,sum,provider,product_path,product_type)) ;
			response.sendRedirect("JspCartPage/login.jsp");
			return;
		}
		
	}

}
