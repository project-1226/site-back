package com.example.purchase.domain;

import java.util.Date;

public class PurchaseVO {
	
	private int purchasedetailid;	
	private int purchaseid;	
	private int productid;	
	private int price;	
	private int count;	
	private Date regdate;
	private String userid;
	public int getPurchasedetailid() {
		return purchasedetailid;
	}
	public void setPurchasedetailid(int purchasedetailid) {
		this.purchasedetailid = purchasedetailid;
	}
	public int getPurchaseid() {
		return purchaseid;
	}
	public void setPurchaseid(int purchaseid) {
		this.purchaseid = purchaseid;
	}
	public int getProductid() {
		return productid;
	}
	public void setProductid(int productid) {
		this.productid = productid;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
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
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	@Override
	public String toString() {
		return "PurchaseVO [purchasedetailid=" + purchasedetailid + ", purchaseid=" + purchaseid + ", productid="
				+ productid + ", price=" + price + ", count=" + count + ", regdate=" + regdate + ", userid=" + userid
				+ "]";
	}
	
	

}
