package com.cn;

public class TempCart {

	public TempCart(){}
	
	public TempCart(int pid,String pname,int price,String provider,int num,int total,String product_path,String product_type){
		this.pid = pid;
		this.pname = pname;
		this.price = price;
		this.provider = provider;
		this.num = num;
		this.total = total;
		this.product_path = product_path;
		this.product_type = product_type;
	}
	
	public TempCart(int pid,String pname,int price,int num,int total,int nums,int sum,String provider,String product_path,String product_type){
		this.pid = pid;
		this.pname = pname;
		this.price = price;
		this.num = num;
		this.total = total;
		this.nums = nums;
		this.sum = sum;
		this.provider = provider;
		this.product_path = product_path;
		this.product_type = product_type;
	}
	
	private int pid;
	private String pname;
	private int price;
	private String provider;
	private int num;
	private int total;
	private String product_path;
	private String product_type;
	private int nums;
	private int sum;
	
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

	public int getNums() {
		return nums;
	}

	public int getSum() {
		return sum;
	}

	public void setNums(int nums) {
		this.nums = nums;
	}

	public void setSum(int sum) {
		this.sum = sum;
	}
	
	
}
