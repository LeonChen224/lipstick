package com.cn;

public class Product {
	public Product() {
		
	}
	
	public Product(String pname,int price,String provider,String product_path,String product_type){		
		this.pname = pname;
		this.price = price;
		this.provider = provider;
		this.product_path = product_path;
		this.product_type = product_type;
	}
	
	public Product(int pid,String pname,int price,String provider,String product_path,String product_type){		
		this.pid = pid;
		this.pname = pname;
		this.price = price;
		this.provider = provider;
		this.product_path = product_path;
		this.product_type = product_type;
	}
	
	public Product(int pid,String pname,int price,String provider,String product_path){		
		this.pid = pid;
		this.pname = pname;
		this.price = price;
		this.provider = provider;
		this.product_path = product_path;
	}

  private int pid;
   
   public int getPid() {
	return pid;
}
   public void setPid(int pid) {
	this.pid = pid;
}
private String pname;

   public String getPname() {
	return pname;
}
public void setPname(String pname) {
	this.pname = pname;
}

private int price;//不建议用浮点数，不精确

   public int getPrice() {
	return price;
}
public void setPrice(int price) {
	this.price = price;
}


private String provider;

public String getProvider() {
	return provider;
}
public void setProvider(String provider) {
	this.provider = provider;
}

private String product_path;

public String getProduct_path() {
	return product_path;
}
public void setProduct_path(String product_path) {
	this.product_path = product_path;
}

private String product_type;

public String getProduct_type() {
	return product_type;
}

public void setProduct_type(String product_type) {
	this.product_type = product_type;
}


}

