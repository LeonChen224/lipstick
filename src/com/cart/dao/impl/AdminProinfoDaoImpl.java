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
				System.out.println("�޸���Ʒ���Ƴɹ�");
				return true;
			}else{
				System.out.println("�޸���Ʒ����ʧ��");
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
		
	}

	//�޸���Ʒ�۸�
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
				System.out.println("�޸���Ʒ�۸�ɹ�");
				return true;
			}else{
				System.out.println("�޸���Ʒ�۸�ʧ��");
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
		
	}

	//ɾ����Ʒ
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
				System.out.println("ɾ����Ʒ�ɹ�");
				return true;
			}else{
				System.out.println("ɾ����Ʒʧ��");
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

}
