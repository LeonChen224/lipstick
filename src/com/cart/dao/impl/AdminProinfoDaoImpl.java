package com.cart.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.cart.factory.DBHelp;

public class AdminProinfoDaoImpl {

	private DBHelp db = new DBHelp();
	
	public boolean changePname(String newpname, Integer pid) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = db.getConnection();
			String sql = "update products set pname = ? where pid = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, newpname);
			pstmt.setInt(2, pid);
			int c = pstmt.executeUpdate();
			if(c > 0){
				System.out.println("修改商品名称成功");
				return true;
			}else{
				System.out.println("修改商品名称失败");
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
		
	}

	//修改商品价格
	public boolean changePrice(Integer newprice, Integer pid) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = db.getConnection();
			String sql = "update products set price = ? where pid = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, newprice);
			pstmt.setInt(2, pid);
			int c = pstmt.executeUpdate();
			if(c > 0){
				System.out.println("修改商品价格成功");
				return true;
			}else{
				System.out.println("修改商品价格失败");
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
		
	}

	//删除商品
	public boolean deletePro(Integer pid) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;		
		try {
			conn = db.getConnection();
			String sql = "delete from products where pid = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, pid);
			int c = pstmt.executeUpdate();
			if(c > 0){
				System.out.println("删除商品成功");
				return true;
			}else{
				System.out.println("删除商品失败");
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

}
