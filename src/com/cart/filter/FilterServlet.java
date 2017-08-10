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
	 protected FilterConfig filterConfig = null; //初始化配置  
	 protected String encoding = null;           //接收字符编码  
	 protected boolean ignore = true;            //是否忽略大小写  

	public void destroy() {
		this.encoding = null;  
        this.filterConfig = null;
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse resp = (HttpServletResponse)response;
		HttpSession session = req.getSession();
		//解决字符编码
		 if (ignore || (req.getCharacterEncoding() == null)) {  
	            String encoding = selectEncoding(req);  //如果为空先从web.xml中得到  
	           // System.out.println("xml中的："+encoding);
	            if (encoding != null){  
	            	req.setCharacterEncoding(encoding); //设置字符集编码  
	            }  
	        }  
		
		
		//判断非登录不允许访问
		String uri = req.getRequestURI();
		 //String uri = req.getHeader("Referer");
		System.out.println("filter uri:"+uri);
		String ss[] = uri.split("/");
		String file = ss[ss.length-2]+"/"+ss[ss.length-1];//取最后两个数组
         
		//获取xml中的页面名字
		String home = filterConfig.getInitParameter("home");
		String login = filterConfig.getInitParameter("login");
		String main = filterConfig.getInitParameter("main");
		String addCart = filterConfig.getInitParameter("addCart");
		String register = filterConfig.getInitParameter("register");
		String listCart = filterConfig.getInitParameter("listCart");

		if (file.equals(login) || file.equals(listCart)) {
			session.setAttribute("file", file);
			//session.setAttribute("codeMsg", "验证码：");
			System.out.println("file======"+session.getAttribute("file"));
			req.getRequestDispatcher("../JspCartPage/login.jsp").forward(req, resp);
		}
	
		//以下页面无需过滤	
		if(file.equals(home) || file.equals(register) || file.equals(main) || file.equals(login) || file.equals("CodeImageServlet") || file.equals("LoginServlet") || file.equals("UserRegisterServlet")){
			chain.doFilter(request, response);
			return;
		}
		
		//如果获取不到用户则进入登录页面
		if(session.getAttribute("user") == null){			
				session.setAttribute("file", file);
				//session.setAttribute("codeMsg", "验证码：");
				System.out.println("file======"+session.getAttribute("file"));
				req.getRequestDispatcher("../JspCartPage/login.jsp").forward(req, resp);
		}				
		chain.doFilter(request, response);
		
		}

	public void init(FilterConfig filterConfig) throws ServletException {		
		this.filterConfig=filterConfig;
		this.encoding = filterConfig.getInitParameter("encoding");  //从web.xml文件中读取encoding的值  
        String value = filterConfig.getInitParameter("ignore");     //从web.xml文件中读取ignore的值  
        //以下三种情况均为忽略大小写  
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
