package com.cart.CartSeviceUtils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import sun.misc.BASE64Encoder;

public class serviceUtils {

	//���ü��ܺ�����������м���
	public static String md5(String password){
		try {
		    // �õ�һ��MD5ת�����������ҪSHA1�������ɡ�SHA1����,��̬������ȡ��
			MessageDigest md=MessageDigest.getInstance("md5");
			
			// ת�������ؽ����Ҳ���ֽ����飬����16��Ԫ��
			byte md5[]=md.digest(password.getBytes());
			
			//.misc.BASE64Encoder��ת������
			BASE64Encoder encoder=new BASE64Encoder();
			
			// �ַ�����ת�����ַ�������
			String ch=encoder.encode(md5);
			return ch.substring(10, 20);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException();
		}		
	}
}
