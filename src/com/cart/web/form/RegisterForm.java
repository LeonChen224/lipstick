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

	// �����������֤
	public boolean validate() {
		boolean isOK = true;
		// �ж������ǿգ�������3-6λ��ĸ
		if (this.username == null || this.username.trim().equals("")) {
			isOK = false;
			errors.put("username", "�ף��û�������Ϊ��");
		} else {
			if (!this.username.matches("[A-Za-z]{2,8}")) {
				isOK = false;
				errors.put("username", "*�û�������Ϊ2��8����ĸ");
			}
		}
		// �ж�����ǿգ�������Ϊ3-6λ����
		if (this.password == null || this.password.trim().equals("")) {
			isOK = false;
			errors.put("password", "*�ף����벻��Ϊ��");
		} else {
			if (!this.password.matches("^(?=.*\\d)(?=.*[A-Za-z]).{3,6}$")) {
				isOK = false;
				errors.put("password", "*�������Ϊ3-6λ�����ֺ���ĸ���");
			}
		}
		// ��������ǿ���һ��
		if (this.password2 == null || this.password2.trim().equals("")) {
			isOK = false;
			errors.put("password2", "���벻��Ϊ��");
		} else {
			if (!this.password2.equals(this.password)) {
				isOK = false;
				errors.put("password2", "�ף���������Ҫһ��");
			}
		}
		
		//��֤�����ʽ
		if(this.mail==null || this.mail.equals("")){
			isOK=false;
			errors.put("mail", "�ף����䲻��Ϊ�գ�����");
		}else {
			if(!this.mail.matches("\\w+@\\w+(\\.\\w+)+")){
				isOK=false;
				errors.put("mail", "�ף������ʽ���ԣ�����");
			}
		}
		
		//��֤�ֻ���
		if(this.phone==null || this.phone.equals("")){
			isOK=false;
			errors.put("phone", "�ף��ֻ��Ų���Ϊ�գ�����");
		}else {
			if(!this.phone.matches("^(13[0-9]|14[5|7]|15[0|1|2|3|5|6|7|8|9]|18[0|1|2|3|5|6|7|8|9])\\d{8}$")){
				isOK=false;
				errors.put("phone", "�ף��ֻ���Ϊ11λ���֣�����");
			}
		}
		return isOK;

	}
}