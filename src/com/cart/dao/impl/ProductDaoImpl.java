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
	
	//判断加入购物车是否成功
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
		
		System.out.println("调用insert方法");
	
		//long cid = System.currentTimeMillis()+System.nanoTime();
		//UserTransaction transaction = sessionContext.getUserTransaction();
		//处理同一用户加重复加同一商品，上面已经获取到要加入的数量num
		//先查询数据库中该用户是否已加了该商品
		//如果匹配到已有pid，则查询数据库中该用户该商品的数量，删除原有的一条记录后；再加上又加的商品数，重新存入数据库（事务）
		String sql = "insert into cart(user_id,pid,pname,price,provider,num,total,product_path,product_type) values(?,?,?,?,?,?,?,?,?)";
		String sql1 = "select user_id,pid,pname,price,provider,num,total,product_path,product_type from cart where user_id = '"+user_id+"'";
		String sql2 = "update cart set num = ? ,total = ? where user_id = ? and pid = ?";
		System.out.println("用户名："+user_id);
		try {
			conn = db.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql1);
			System.out.println(sql1);
			while(rs.next()){ //找到该用户		
				System.out.println("productId:"+productId);
				System.out.println("rs.getInt(2)："+rs.getInt(2));
				System.out.println("rs.getString(1)："+rs.getString(1));	 
				if(productId == rs.getInt(2)){
					flag = true;
					oldnum = rs.getInt(6);
					oldtotal = rs.getInt(7);
					System.out.println("oldnum:"+oldnum+"\n"+"oldtotal:"+oldtotal);
				}
			}
			System.out.println(flag);
			//有商品匹配
			if(flag == true){
				  System.out.println("执行true");
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
            	  		System.out.println("更新数量成功");
            	  		return true;
            	  	}else{
            	  		System.out.println("更新数量失败");
            	  		return false;
            	  	}
			}
			//没有商品则插入
			if(flag == false){
			    System.out.println("执行false");
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
			 			System.out.println("没有匹配商品，插入成功");
			 			return true;
			 		}else{
			 			System.out.println("没有匹配商品，但插入失败");
			 			return false;
			 		}
				}
				
			} catch (SQLException e) {
				e.printStackTrace();					
			 	}
			db.release(conn, pstmt, rs);
			return false;
		}
	
		
	
	//用于获取登录用户的购物车商品
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
	
	    //遍历商品总价，计算总和
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
				//遍历所有商品的总价，算总和
				for(int i = 0;i < listToal.size();i++){
					Integer total = (Integer)listToal.get(i);
				    sum += total;
					//System.out.println("总价："+listToal.get(i));
				}				
				System.out.println("sum:"+sum);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			db.release(conn, pstmt, rs);
			return sum;
			
	    }
	    
		//删除指定购物车商品
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
	            	System.out.println("删除购物车指定商品成功");
	            	return true;	            	
	            }else{
	            	System.out.println("删除购物车指定商品失败");
	            	return false;
	            }
			} catch (SQLException e) {
				e.printStackTrace();
			}
			db.release(conn, pstmt, rs);
			return false;
			
		}
		
		//更改数据库中该用户指定商品的数量
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
					System.out.println("修改数量成功");
				}else{
					System.out.println("修改数量失败");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			db.release(conn, pstmt, rs);
			
		}
		
		//清空购物车方法
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
					System.out.println("清空购物车成功");
				}else{
					System.out.println("清空购物车失败");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			db.release(conn, pstmt, rs);
		}

		//用户登录前保存临时商品信息
		public ArrayList<TempCart> saveTempCart(Integer productId, String productName,
				Integer productPrice, String productProvider, Integer num,
				Integer total, String product_path,String product_type) {
			System.out.println(productId+",,,"+productName);
			ArrayList<TempCart> templist = new ArrayList<TempCart>();
			templist.add(new TempCart(productId,productName,productPrice,productProvider,num,total,product_path,product_type));
			return templist;			
		}


		//从购物车选出来下单
		String str[];
		String pid = "";
		public ArrayList<Cart> findCart(String user_id, String[] pids, ArrayList<Cart> cart) {
			ArrayList<Cart> result = new ArrayList<Cart>();
			for(String pidss:pids){
				System.out.println("pppid:"+pidss);//价格，商品号
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

		//根据用户id找到用户收货信息
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


		//立即购买，通过pid选出商品
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


		//用户没有登录，先将所选商品存在集合中
		public ArrayList<TempCart> saveTempBuy(Integer pid, String pname, Integer price,
				Integer num, int total, Integer nums, Integer sum,
				String provider, String product_path, String product_type) {
			ArrayList<TempCart> tempbuylist = new ArrayList<TempCart>();
			tempbuylist.add(new TempCart(pid,pname,price,num,total,nums,sum,provider,product_path,product_type));
			return tempbuylist;
			
		}


		//管理员添加商品
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
					System.out.println("管理员添加商品成功");
				}else{
					System.out.println("管理员添加商品失败");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
	
}
