package com.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cart.factory.DBHelp;
import com.cn.Product;

public class AdminAllProductsServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		DBHelp db = new DBHelp();
		Connection conn = null;
		PreparedStatement pstmt = null;
		Statement stmt = null;
		ResultSet rs = null;
		java.sql.CallableStatement cstmt = null;
		
		HttpSession session = request.getSession();
		
		//分页
		int count = 0;//用于获取一共有多少条记录
		int pageCount = 0;//用于获取分几页
		Integer np = 0;
		int p =0;
		
		ArrayList<Product> allProlist = new ArrayList<Product>();
		
		String sql = "select pid,pname,price,provider,product_path,product_type from products";
		try {
			conn = db.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()){
				count++;
			}
			
			if(count % 8 != 0){
				pageCount = count/8 + 1;
			}else{
				pageCount = count/8;
			}
			request.setAttribute("pageCount", pageCount);

			String page = request.getParameter("page");
			
			if(page != null){
			   np = Integer.parseInt(page);
			}
			
			System.out.println(np);
			cstmt = conn.prepareCall("call p(?,?)");
			cstmt.setInt(1, np);
			cstmt.setInt(2, 8);//每页显示8条
			
			if(cstmt.execute()){
		        rs = cstmt.getResultSet();
			    while(rs.next()){
				  allProlist.add(new Product(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getString(4),rs.getString(5),rs.getString(6)));
			    }
			    
			}
			session.setAttribute("products", allProlist);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher("JspAdminPage/AdminProducts.jsp").forward(request, response);
		db.release(conn, cstmt, rs);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
