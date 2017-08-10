package com.cart.dao;

public interface CustomerDao {

	//下单插入用户信息和商品信息，事务
	public abstract boolean insertInfo(String user_id, String cname,
			Integer pid, String pname, Integer price, Integer num,
			Integer nums, Integer total, Integer sum, String provider,
			String product_type, String phone, String address,
			String ordertime, String orderno);

	//生成唯一订单号
	public abstract String createOrderno();

	//生成下单时间
	public abstract String ordertime();

}