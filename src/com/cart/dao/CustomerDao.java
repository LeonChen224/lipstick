package com.cart.dao;

public interface CustomerDao {

	//�µ������û���Ϣ����Ʒ��Ϣ������
	public abstract boolean insertInfo(String user_id, String cname,
			Integer pid, String pname, Integer price, Integer num,
			Integer nums, Integer total, Integer sum, String provider,
			String product_type, String phone, String address,
			String ordertime, String orderno);

	//����Ψһ������
	public abstract String createOrderno();

	//�����µ�ʱ��
	public abstract String ordertime();

}