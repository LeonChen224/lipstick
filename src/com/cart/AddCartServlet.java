package com.cart;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cart.factory.DBHelp;

public class AddCartServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		DBHelp db = new DBHelp();
		HttpSession session = request.getSession();
		response.setContentType("text/html;charset=utf-8");
		//PrintWriter out = response.getWriter();
		
		String pname = request.getParameter("name");
		//System.out.println("前台接收到的商品名："+pname);
		
		//连接数据库
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "select pid,pname,price,provider,product_path,product_type from products where pname = '"+pname+"'";
		try {
			conn = db.getConnection();
			stmt = conn.createStatement();
			rs= stmt.executeQuery(sql);
			while(rs.next()){
				session.setAttribute("productId", rs.getInt(1));
				session.setAttribute("productName", rs.getString(2));
				session.setAttribute("productPrice", rs.getInt(3));
				session.setAttribute("productProvider", rs.getString(4));
				session.setAttribute("productPath", rs.getString(5));
				session.setAttribute("productType", rs.getString(6));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		db.release(conn, stmt, rs);
		System.out.println("========"+session.getAttribute("productName"));
		request.getRequestDispatcher("JspCartPage/addCart.jsp").forward(request, response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
	}
	

}
