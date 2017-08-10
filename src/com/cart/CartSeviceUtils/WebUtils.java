package com.cart.CartSeviceUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.Enumeration;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import com.sun.org.apache.commons.beanutils.BeanUtils;

public class WebUtils {
	public static <T> T request2Bean(HttpServletRequest request,
			Class<T> beanClass) {
		try {
			//����Ҫ��װ��bean
			T bean = beanClass.newInstance();
			//��request�е����ݷ�װ��bean��
			Enumeration e = request.getParameterNames();
			while (e.hasMoreElements()) {
				String name = (String) e.nextElement();
				String value = request.getParameter(name);
				BeanUtils.setProperty(bean, name, value);
			}
			return bean;
		} catch (Exception e) {
			throw new RuntimeException();
		}
	}
	
	/*public static void copyBean(Object src,Object dest){
		try {
			BeanUtils.copyProperties(src, dest);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	*/
	//����һ��ȫ��Ψһ��ID
	public  static String generateID(){
		return UUID.randomUUID().toString();
	}
}
