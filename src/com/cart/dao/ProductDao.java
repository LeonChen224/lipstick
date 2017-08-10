package com.cart.dao;

import java.util.ArrayList;

import com.cn.Cart;
import com.cn.Product;
import com.cn.TempCart;
import com.cn.User;

public interface ProductDao {

	//�жϼ��빺�ﳵ�Ƿ�ɹ�
	public abstract boolean insertCart(String user_id, int productId,
			String productName, int productPrice, String productProvider,
			int num, int total,String product_path,String product_type);

	//���ڻ�ȡ��¼�û��Ĺ��ﳵ��Ʒ
	public abstract ArrayList<Cart> selectCart(String user_id);

	//ɾ��ָ�����ﳵ��Ʒ
	public abstract boolean deleteCart(String user_id, int pid);

	//�������ݿ��и��û�ָ����Ʒ������
	public abstract void changeCartNum(String user_id, Integer num,
			Integer pid, Integer newtotal);

	//��չ��ﳵ����
	public abstract void clearAllCart(String user_id);

	//������Ʒ�ܼۣ������ܺ�
	public abstract int calcSum(String user_id);

	//�û���¼ǰ������ʱ��Ʒ��Ϣ
	public abstract ArrayList<TempCart> saveTempCart(Integer productId, String productName,
			Integer productPrice, String productProvider, Integer num,
			Integer total, String product_path,String product_type);
	
	//�ӹ��ﳵѡ�����µ�
	public abstract ArrayList<Cart> findCart(String user_id, String[] pids,
			ArrayList<Cart> cart);
	
	//�����û�id�ҵ��û��ջ���Ϣ
	public abstract ArrayList<User> findDeliveryInfo(String user_id);
	
	//��������ͨ��pidѡ����Ʒ
	public abstract ArrayList<Product> buyCartNow(Integer pid);
	
	//�û�û�е�¼���Ƚ���ѡ��Ʒ���ڼ�����
	public abstract ArrayList<TempCart> saveTempBuy(Integer pid, String pname, Integer price,
			Integer num, int total, Integer nums, Integer sum,
			String provider, String product_path, String product_type);
	
	//����Ա�����Ʒ
	public abstract void addProduct(String pname, Integer price, String provider,
			String savePath, String ptype);
}