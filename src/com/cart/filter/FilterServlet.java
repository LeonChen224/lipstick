package com.cart.filter;

import java.io.IOException;
import java.util.Random;

import javax.faces.validator.LengthValidator;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cart.dao.UserDao;
import com.cart.dao.impl.UserDaoImpl;
import com.cn.User;

public class FilterServlet implements Filter{
	 protected FilterConfig filterConfig = null; //��ʼ������  
	 protected String encoding = null;           //�����ַ�����  
	 protected boolean ignore = true;            //�Ƿ���Դ�Сд  

	public void destroy() {
		this.encoding = null;  
        this.filterConfig = null;
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse resp = (HttpServletResponse)response;
		HttpSession session = req.getSession();
		//����ַ�����
		 if (ignore || (req.getCharacterEncoding() == null)) {  
	            String encoding = selectEncoding(req);  //���Ϊ���ȴ�web.xml�еõ�  
	           // System.out.println("xml�еģ�"+encoding);
	            if (encoding != null){  
	            	req.setCharacterEncoding(encoding); //�����ַ�������  
	            }  
	        }  
		
		
		//�жϷǵ�¼���������
		String uri = req.getRequestURI();
		 //String uri = req.getHeader("Referer");
		System.out.println("filter uri:"+uri);
		String ss[] = uri.split("/");
		String file = ss[ss.length-2]+"/"+ss[ss.length-1];//ȡ�����������
         
		//��ȡxml�е�ҳ������
		String home = filterConfig.getInitParameter("home");
		String login = filterConfig.getInitParameter("login");
		String main = filterConfig.getInitParameter("main");
		String addCart = filterConfig.getInitParameter("addCart");
		String register = filterConfig.getInitParameter("register");
		String listCart = filterConfig.getInitParameter("listCart");

		if (file.equals(login) || file.equals(listCart)) {
			session.setAttribute("file", file);
			//session.setAttribute("codeMsg", "��֤�룺");
			System.out.println("file======"+session.getAttribute("file"));
			req.getRequestDispatcher("../JspCartPage/login.jsp").forward(req, resp);
		}
	
		//����ҳ���������	
		if(file.equals(home) || file.equals(register) || file.equals(main) || file.equals(login) || file.equals("CodeImageServlet") || file.equals("LoginServlet") || file.equals("UserRegisterServlet")){
			chain.doFilter(request, response);
			return;
		}
		
		//�����ȡ�����û�������¼ҳ��
		if(session.getAttribute("user") == null){			
				session.setAttribute("file", file);
				//session.setAttribute("codeMsg", "��֤�룺");
				System.out.println("file======"+session.getAttribute("file"));
				req.getRequestDispatcher("../JspCartPage/login.jsp").forward(req, resp);
		}				
		chain.doFilter(request, response);
		
		}

	public void init(FilterConfig filterConfig) throws ServletException {		
		this.filterConfig=filterConfig;
		this.encoding = filterConfig.getInitParameter("encoding");  //��web.xml�ļ��ж�ȡencoding��ֵ  
        String value = filterConfig.getInitParameter("ignore");     //��web.xml�ļ��ж�ȡignore��ֵ  
        //�������������Ϊ���Դ�Сд  
        if (value == null)  
            this.ignore = true;  
        else if (value.equalsIgnoreCase("true"))  
            this.ignore = true;  
        else if (value.equalsIgnoreCase("yes"))  
            this.ignore = true;  
        else  
            this.ignore = false;  
    } 
	
	
	protected String selectEncoding(ServletRequest request) {  
        return (this.encoding);  
    }  

}
