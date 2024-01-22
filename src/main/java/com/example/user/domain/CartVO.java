package com.example.user.domain;

import java.util.Date;

public class CartVO {
	private int cartid;
	private int productid;
	private String userid;
	private int count;
	private Date regdate;
	
	public int getCartid() {
		return cartid;
	}
	public void setCartid(int cartid) {
		this.cartid = cartid;
	}
	public int getProductid() {
		return productid;
	}
	public void setProductid(int productid) {
		this.productid = productid;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	@Override
	public String toString() {
		return "CartVO [cartid=" + cartid + ", productid=" + productid + ", userid=" + userid + ", count=" + count
				+ ", regdate=" + regdate + "]";
	}
	
	
}
