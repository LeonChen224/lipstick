package com.cn;

public class Cart {

	public Cart(){}
	
	public Cart(String user_id,int pid,String pname,int price,String provider,int num,int total,String product_path,String product_type){
		this.user_id = user_id;
		this.pid = pid;
		this.pname = pname;
		this.price = price;
		this.provider = provider;
		this.num = num;
		this.total = total;
		this.product_path = product_path;
		this.product_type = product_type;
	}
	
	private String user_id;
	private int pid;
	private String pname;
	private int price;
	private String provider;
	private int num;
	private int total;
	private String product_path;
	private String product_type;
	
	public String getUser_id() {
		return user_id;
	}

	public int getPid() {
		return pid;
	}

	public String getPname() {
		return pname;
	}

	public int getPrice() {
		return price;
	}

	public String getProvider() {
		return provider;
	}

	public int getNum() {
		return num;
	}	

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public void setProvider(String provider) {
		this.provider = provider;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getProduct_path() {
		return product_path;
	}

	public void setProduct_path(String product_path) {
		this.product_path = product_path;
	}

	public String getProduct_type() {
		return product_type;
	}

	public void setProduct_type(String product_type) {
		this.product_type = product_type;
	}
	
	
	
}
