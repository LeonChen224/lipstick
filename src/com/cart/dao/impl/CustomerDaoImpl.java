package com.cart.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import com.cart.dao.CustomerDao;
import com.cart.factory.DBHelp;

public class CustomerDaoImpl implements CustomerDao{

	private DBHelp db = new DBHelp();
	
	//�µ������û���Ϣ����Ʒ��Ϣ������
	/* (non-Javadoc)
	 * @see com.cart.dao.impl.CustomerDao#insertInfo(java.lang.String, java.lang.String, java.lang.Integer, java.lang.String, java.lang.Integer, java.lang.Integer, java.lang.Integer, java.lang.Integer, java.lang.Integer, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public boolean insertInfo(String user_id, String cname, Integer pid,
			String pname,Integer price, Integer num, Integer nums, Integer total,		
			Integer sum, String provider,String product_type, String phone, String address,
			String ordertime,String orderno) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = db.getConnection();
			//�ر��ֶ��ύ
			conn.setAutoCommit(false);
			String sql1 = "insert into consumers(user_id,cname,pid,pname,nums,sum,phone,address,ordertime,orderno) values(?,?,?,?,?,?,?,?,?,?)";
			String sql2 = "insert into detail(user_id,pid,pname,price,num,total,provider,product_type,ordertime,orderno) values(?,?,?,?,?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql1);
			pstmt.setString(1, user_id);
			pstmt.setString(2, cname);
			pstmt.setInt(3, pid);
			pstmt.setString(4, pname);
			pstmt.setInt(5, nums);
			pstmt.setInt(6, sum);
			pstmt.setString(7, phone);
			pstmt.setString(8, address);
			pstmt.setString(9, ordertime);
			pstmt.setString(10, orderno);
			int c1 = pstmt.executeUpdate();
			
			pstmt = conn.prepareStatement(sql2);
			pstmt.setString(1, user_id);
			pstmt.setInt(2, pid);
			pstmt.setString(3, pname);
			pstmt.setInt(4, price);
			pstmt.setInt(5, num);
			pstmt.setInt(6, total);
			pstmt.setString(7, provider);
			pstmt.setString(8, product_type);
			pstmt.setString(9, ordertime);
			pstmt.setString(10, orderno);
			int c2 = pstmt.executeUpdate();
			
			if(c1 > 0 && c2 > 0){
				System.out.println("�������Ŷ�����ɹ�");
				conn.commit();
				return true;
			}else{
				System.out.println("�������Ŷ�����ʧ��");
				conn.rollback();
				return false;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	//����Ψһ������
	/* (non-Javadoc)
	 * @see com.cart.dao.impl.CustomerDao#createOrderno()
	 */
	@Override
	public String createOrderno() {
		//��������߰�λ�ĺ�
		Random random = new Random();
        int choice = random.nextInt(2) % 2 == 0 ? 65 : 97;
        char a = (char) (choice + random.nextInt(26));
        // String s = "abcdefghijklmnopqrstuvwxyz";
        // char[] c = s.toCharArray();
        // Random random = new Random();
        // char a=c[random.nextInt(c.length)];
        int b = 0;
        while (true) {
            b = random.nextInt(9999999);
            if (b < 1000000) {
                continue;
            } else
                break;
        }
        String str = "" + a + b;
        
        //��ȡʱ��
        String datetime=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());         
        String[] str1=datetime.split(" ");
        String[] str2=str1[0].split("-");
        String[] str3=str1[1].split(":");
        
        //��������
        String orderno=str+str2[0]+str2[1]+str2[2]+str3[0]+str3[1]+str3[2];
		return orderno;
		
	}

	//�����µ�ʱ��
	/* (non-Javadoc)
	 * @see com.cart.dao.impl.CustomerDao#ordertime()
	 */
	@Override
	public String ordertime() {
		String ordertime=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
		return ordertime;		
	}

}
