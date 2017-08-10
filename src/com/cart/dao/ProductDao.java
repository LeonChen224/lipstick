package com.cart.dao;

import java.util.ArrayList;

import com.cn.Cart;
import com.cn.Product;
import com.cn.TempCart;
import com.cn.User;

public interface ProductDao {

	//判断加入购物车是否成功
	public abstract boolean insertCart(String user_id, int productId,
			String productName, int productPrice, String productProvider,
			int num, int total,String product_path,String product_type);

	//用于获取登录用户的购物车商品
	public abstract ArrayList<Cart> selectCart(String user_id);

	//删除指定购物车商品
	public abstract boolean deleteCart(String user_id, int pid);

	//更改数据库中该用户指定商品的数量
	public abstract void changeCartNum(String user_id, Integer num,
			Integer pid, Integer newtotal);

	//清空购物车方法
	public abstract void clearAllCart(String user_id);

	//遍历商品总价，计算总和
	public abstract int calcSum(String user_id);

	//用户登录前保存临时商品信息
	public abstract ArrayList<TempCart> saveTempCart(Integer productId, String productName,
			Integer productPrice, String productProvider, Integer num,
			Integer total, String product_path,String product_type);
	
	//从购物车选出来下单
	public abstract ArrayList<Cart> findCart(String user_id, String[] pids,
			ArrayList<Cart> cart);
	
	//根据用户id找到用户收货信息
	public abstract ArrayList<User> findDeliveryInfo(String user_id);
	
	//立即购买，通过pid选出商品
	public abstract ArrayList<Product> buyCartNow(Integer pid);
	
	//用户没有登录，先将所选商品存在集合中
	public abstract ArrayList<TempCart> saveTempBuy(Integer pid, String pname, Integer price,
			Integer num, int total, Integer nums, Integer sum,
			String provider, String product_path, String product_type);
	
	//管理员添加商品
	public abstract void addProduct(String pname, Integer price, String provider,
			String savePath, String ptype);
}