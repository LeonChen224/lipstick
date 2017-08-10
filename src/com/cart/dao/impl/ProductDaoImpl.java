package com.cart.dao.impl;

 import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.cart.dao.ProductDao;
import com.cart.factory.DBHelp;
import com.cn.Cart;
import com.cn.Product;
import com.cn.TempCart;
import com.cn.User;

public class ProductDaoImpl implements ProductDao {

	private DBHelp db = new DBHelp();
	
	//�жϼ��빺�ﳵ�Ƿ�ɹ�
	public boolean insertCart(String user_id,int productId,String productName,int productPrice,String productProvider,int num,int total,String product_path,String product_type)  {
		Connection conn = null;
		PreparedStatement pstmt = null;
		Statement stmt = null;
		ResultSet rs = null;
		boolean flag = false;
	
		int oldnum = 0;
		int newnum = 0;
		int oldtotal = 0;
		int newtotal = 0;
		
		System.out.println("����insert����");
	
		//long cid = System.currentTimeMillis()+System.nanoTime();
		//UserTransaction transaction = sessionContext.getUserTransaction();
		//����ͬһ�û����ظ���ͬһ��Ʒ�������Ѿ���ȡ��Ҫ���������num
		//�Ȳ�ѯ���ݿ��и��û��Ƿ��Ѽ��˸���Ʒ
		//���ƥ�䵽����pid�����ѯ���ݿ��и��û�����Ʒ��������ɾ��ԭ�е�һ����¼���ټ����ּӵ���Ʒ�������´������ݿ⣨����
		String sql = "insert into cart(user_id,pid,pname,price,provider,num,total,product_path,product_type) values(?,?,?,?,?,?,?,?,?)";
		String sql1 = "select user_id,pid,pname,price,provider,num,total,product_path,product_type from cart where user_id = '"+user_id+"'";
		String sql2 = "update cart set num = ? ,total = ? where user_id = ? and pid = ?";
		System.out.println("�û�����"+user_id);
		try {
			conn = db.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql1);
			System.out.println(sql1);
			while(rs.next()){ //�ҵ����û�		
				System.out.println("productId:"+productId);
				System.out.println("rs.getInt(2)��"+rs.getInt(2));
				System.out.println("rs.getString(1)��"+rs.getString(1));	 
				if(productId == rs.getInt(2)){
					flag = true;
					oldnum = rs.getInt(6);
					oldtotal = rs.getInt(7);
					System.out.println("oldnum:"+oldnum+"\n"+"oldtotal:"+oldtotal);
				}
			}
			System.out.println(flag);
			//����Ʒƥ��
			if(flag == true){
				  System.out.println("ִ��true");
            	  newnum = oldnum + num;
            	  newtotal = oldtotal+total;
            	  System.out.println("newnum:"+newnum+"\n"+"newtotal:"+newtotal);
            	  pstmt = conn.prepareStatement(sql2);
            	  pstmt.setInt(1, newnum);
            	  pstmt.setInt(2, newtotal);
            	  pstmt.setString(3, user_id);
            	  pstmt.setInt(4, productId);
            	  int c = pstmt.executeUpdate();
            	  	if(c > 0){
            	  		System.out.println("���������ɹ�");
            	  		return true;
            	  	}else{
            	  		System.out.println("��������ʧ��");
            	  		return false;
            	  	}
			}
			//û����Ʒ�����
			if(flag == false){
			    System.out.println("ִ��false");
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, user_id);
			 	pstmt.setInt(2, productId);
			 	pstmt.setString(3, productName);
			 	pstmt.setInt(4, productPrice);
			 	pstmt.setString(5, productProvider);
			 	pstmt.setInt(6, num);
			 	pstmt.setInt(7, total);
			 	pstmt.setString(8, product_path);
			 	pstmt.setString(9, product_type);
			 	int c = pstmt.executeUpdate();
			 		if(c > 0){
			 			System.out.println("û��ƥ����Ʒ������ɹ�");
			 			return true;
			 		}else{
			 			System.out.println("û��ƥ����Ʒ��������ʧ��");
			 			return false;
			 		}
				}
				
			} catch (SQLException e) {
				e.printStackTrace();					
			 	}
			db.release(conn, pstmt, rs);
			return false;
		}
	
		
	
	//���ڻ�ȡ��¼�û��Ĺ��ﳵ��Ʒ
	public ArrayList<Cart> selectCart(String user_id){
		Connection conn = null;
		PreparedStatement pstmt = null;
		Statement stmt = null;
		ResultSet rs = null;

		ArrayList<Cart> listcart = new ArrayList<Cart>();
		
		try {
			conn = db.getConnection();
			stmt = conn.createStatement();
			String sql = "select user_id,pid,pname,price,provider,num,total,product_path,product_type from Cart where user_id = '"+user_id+"'";
			rs = stmt.executeQuery(sql);
				
			while(rs.next()){
				listcart.add(new Cart(rs.getString(1),rs.getInt(2),rs.getString(3),rs.getInt(4),rs.getString(5),rs.getInt(6),rs.getInt(7),rs.getString(8),rs.getString(9)));				
			}

			System.out.println("listcart:"+listcart);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		db.release(conn, pstmt, rs);
		return listcart;
	}	
	
	    //������Ʒ�ܼۣ������ܺ�
		public int calcSum(String user_id){
			Connection conn = null;
			PreparedStatement pstmt = null;
			Statement stmt = null;
			ResultSet rs = null;
			Integer sum = 0;

	        ArrayList listToal = new ArrayList();
			
			try {
				conn = db.getConnection();
				stmt = conn.createStatement();
				String sql = "select total from Cart where user_id = '"+user_id+"'";
				rs = stmt.executeQuery(sql);
					
				while(rs.next()){				
				    listToal.add(rs.getInt(1));
				}
				//����������Ʒ���ܼۣ����ܺ�
				for(int i = 0;i < listToal.size();i++){
					Integer total = (Integer)listToal.get(i);
				    sum += total;
					//System.out.println("�ܼۣ�"+listToal.get(i));
				}				
				System.out.println("sum:"+sum);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			db.release(conn, pstmt, rs);
			return sum;
			
	    }
	    
		//ɾ��ָ�����ﳵ��Ʒ
		public boolean deleteCart(String user_id,int pid){
			Connection conn = null;
			PreparedStatement pstmt = null;
			Statement stmt = null;
			ResultSet rs = null;
			
			try {
				conn = db.getConnection();
				stmt = conn.createStatement();
				String sql = "delete from cart where user_id = '"+user_id+"'and pid = '"+pid+"'";
	            System.out.println(sql);
				int c = stmt.executeUpdate(sql);
	            if(c > 0){
	            	System.out.println("ɾ�����ﳵָ����Ʒ�ɹ�");
	            	return true;	            	
	            }else{
	            	System.out.println("ɾ�����ﳵָ����Ʒʧ��");
	            	return false;
	            }
			} catch (SQLException e) {
				e.printStackTrace();
			}
			db.release(conn, pstmt, rs);
			return false;
			
		}
		
		//�������ݿ��и��û�ָ����Ʒ������
		public void changeCartNum(String user_id, Integer num, Integer pid, Integer newtotal) {
			Connection conn = null;
			PreparedStatement pstmt = null;
			Statement stmt = null;
			ResultSet rs = null;
			
			String sql = "update cart set num = ? , total = ? where user_id = ? and pid = ?";
			try {
				conn = db.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, num);
				pstmt.setInt(2, newtotal);
				pstmt.setString(3, user_id);
				pstmt.setInt(4, pid);
				int c = pstmt.executeUpdate();
				if(c > 0){
					System.out.println("�޸������ɹ�");
				}else{
					System.out.println("�޸�����ʧ��");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			db.release(conn, pstmt, rs);
			
		}
		
		//��չ��ﳵ����
		public void clearAllCart(String user_id){
			Connection conn = null;
			PreparedStatement pstmt = null;
			Statement stmt = null;
			ResultSet rs = null;
			
			String sql = "delete from cart where user_id = ?";
			try {
				conn = db.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, user_id);
				int c = pstmt.executeUpdate();
				if(c > 0){
					System.out.println("��չ��ﳵ�ɹ�");
				}else{
					System.out.println("��չ��ﳵʧ��");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			db.release(conn, pstmt, rs);
		}

		//�û���¼ǰ������ʱ��Ʒ��Ϣ
		public ArrayList<TempCart> saveTempCart(Integer productId, String productName,
				Integer productPrice, String productProvider, Integer num,
				Integer total, String product_path,String product_type) {
			System.out.println(productId+",,,"+productName);
			ArrayList<TempCart> templist = new ArrayList<TempCart>();
			templist.add(new TempCart(productId,productName,productPrice,productProvider,num,total,product_path,product_type));
			return templist;			
		}


		//�ӹ��ﳵѡ�����µ�
		String str[];
		String pid = "";
		public ArrayList<Cart> findCart(String user_id, String[] pids, ArrayList<Cart> cart) {
			ArrayList<Cart> result = new ArrayList<Cart>();
			for(String pidss:pids){
				System.out.println("pppid:"+pidss);//�۸���Ʒ��
				str = pidss.split(",");
				pid = str[1];
				for(Cart c:cart){
					if(pid.equals(String.valueOf(c.getPid()))){
						result.add(c);
					}
				}
			}
			return result;
		}

		//�����û�id�ҵ��û��ջ���Ϣ
		public ArrayList<User> findDeliveryInfo(String user_id) {
			Connection conn = null;
			PreparedStatement pstmt = null;
			Statement stmt = null;
			ResultSet rs = null;
			
			ArrayList<User> deliverylist = new ArrayList<User>();
			String sql = "select username,address,phone from userlogin where user_id = ?";
			try {
				conn = db.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, user_id);
				rs = pstmt.executeQuery();
				if(rs.next()){
					//System.out.println("rs.getString(1):"+rs.getString(1));
					System.out.println("rs.getString(2):"+rs.getString(2));
					deliverylist.add(new User(rs.getString(1),rs.getString(2),rs.getString(3)));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return deliverylist;
			
		}


		//��������ͨ��pidѡ����Ʒ
		public ArrayList<Product> buyCartNow(Integer pid) {
			Connection conn = null;
			PreparedStatement pstmt = null;
			Statement stmt = null;
			ResultSet rs = null;
			ArrayList<Product> buyProlist = new ArrayList<Product>();
			try {
				conn = db.getConnection();
				String sql = "select pid,pname,price,provider,product_path,product_type from products where pid = ?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, pid);
				rs  = pstmt.executeQuery();				
				while(rs.next()){
					buyProlist.add(new Product(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getString(4),rs.getString(5),rs.getString(6)));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return buyProlist;
			
			
		}


		//�û�û�е�¼���Ƚ���ѡ��Ʒ���ڼ�����
		public ArrayList<TempCart> saveTempBuy(Integer pid, String pname, Integer price,
				Integer num, int total, Integer nums, Integer sum,
				String provider, String product_path, String product_type) {
			ArrayList<TempCart> tempbuylist = new ArrayList<TempCart>();
			tempbuylist.add(new TempCart(pid,pname,price,num,total,nums,sum,provider,product_path,product_type));
			return tempbuylist;
			
		}


		//����Ա�����Ʒ
		public void addProduct(String pname, Integer price, String provider,
				String savePath, String ptype) {
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			try {
				conn = db.getConnection();
				String sql = "insert into products(pname,price,provider,product_path,product_type) values(?,?,?,?,?)";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, pname);
				pstmt.setInt(2, price);
				pstmt.setString(3, provider);
				pstmt.setString(4, savePath);
				pstmt.setString(5, ptype);
				int c = pstmt.executeUpdate();
				if(c > 0){
					System.out.println("����Ա�����Ʒ�ɹ�");
				}else{
					System.out.println("����Ա�����Ʒʧ��");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
	
}
