package com.cart.web.form;

import java.util.HashMap;
import java.util.Map;

public class RegisterForm {
	private String username;
	private String password;
	private String password2;
	private String user_id;
	private String phone;
	private String address;
	private String mail;

	public RegisterForm(String username, String password, String password2,
			String user_id, String phone, String address, String mail,
			Map errors) {
		super();
		this.username = username;
		this.password = password;
		this.password2 = password2;
		this.user_id = user_id;
		this.phone = phone;
		this.address = address;
		this.mail = mail;
		this.errors = errors;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	private Map errors = new HashMap();

	public Map getErrors() {
		return errors;
	}

	public void setErrors(Map errors) {
		this.errors = errors;
	}

	public RegisterForm() {
		super();
	}

	public String getPassword2() {
		return password2;
	}

	public void setPassword2(String password2) {
		this.password2 = password2;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	// 表单里的数据验证
	public boolean validate() {
		boolean isOK = true;
		// 判断姓名非空，并且是3-6位字母
		if (this.username == null || this.username.trim().equals("")) {
			isOK = false;
			errors.put("username", "亲，用户名不能为空");
		} else {
			if (!this.username.matches("[A-Za-z]{2,8}")) {
				isOK = false;
				errors.put("username", "*用户名必须为2—8个字母");
			}
		}
		// 判断密码非空，且密码为3-6位数字
		if (this.password == null || this.password.trim().equals("")) {
			isOK = false;
			errors.put("password", "*亲，密码不能为空");
		} else {
			if (!this.password.matches("^(?=.*\\d)(?=.*[A-Za-z]).{3,6}$")) {
				isOK = false;
				errors.put("password", "*密码必须为3-6位的数字和字母组成");
			}
		}
		// 两次密码非空且一致
		if (this.password2 == null || this.password2.trim().equals("")) {
			isOK = false;
			errors.put("password2", "密码不能为空");
		} else {
			if (!this.password2.equals(this.password)) {
				isOK = false;
				errors.put("password2", "亲，两次密码要一致");
			}
		}
		
		//验证邮箱格式
		if(this.mail==null || this.mail.equals("")){
			isOK=false;
			errors.put("mail", "亲，邮箱不能为空！！！");
		}else {
			if(!this.mail.matches("\\w+@\\w+(\\.\\w+)+")){
				isOK=false;
				errors.put("mail", "亲，邮箱格式不对！！！");
			}
		}
		
		//验证手机号
		if(this.phone==null || this.phone.equals("")){
			isOK=false;
			errors.put("phone", "亲，手机号不能为空！！！");
		}else {
			if(!this.phone.matches("^(13[0-9]|14[5|7]|15[0|1|2|3|5|6|7|8|9]|18[0|1|2|3|5|6|7|8|9])\\d{8}$")){
				isOK=false;
				errors.put("phone", "亲，手机号为11位数字！！！");
			}
		}
		return isOK;

	}
}