package com.cart.CartSeviceUtils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import sun.misc.BASE64Encoder;

public class serviceUtils {

	//运用加密函数对密码进行加密
	public static String md5(String password){
		try {
		    // 拿到一个MD5转换器（如果想要SHA1参数换成”SHA1”）,静态方法获取的
			MessageDigest md=MessageDigest.getInstance("md5");
			
			// 转换并返回结果，也是字节数组，包含16个元素
			byte md5[]=md.digest(password.getBytes());
			
			//.misc.BASE64Encoder，转成明文
			BASE64Encoder encoder=new BASE64Encoder();
			
			// 字符数组转换成字符串返回
			String ch=encoder.encode(md5);
			return ch.substring(10, 20);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException();
		}		
	}
}
