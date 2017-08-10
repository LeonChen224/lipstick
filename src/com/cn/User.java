package com.cn;

public class User {
	private String user_id;
	private String username;
	private String password;
	private String phone;
	private String address;
	private String mail;

	public User() {
		super();
	}

	public User(String username,String address, String phone) {
		super();		
		this.username = username;
		this.address = address;
		this.phone = phone;
	}

	public User(String user_id, String username, String password, String phone,
			String address, String mail) {
		super();
		this.user_id = user_id;
		this.username = username;
		this.password = password;
		this.phone = phone;
		this.address = address;
		this.mail = mail;
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

	public String getUser_id() {
		return user_id;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}