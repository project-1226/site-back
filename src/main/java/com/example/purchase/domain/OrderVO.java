package com.example.purchase.domain;

import java.util.Date;

public class OrderVO {
	private int purchaseid;
	private String orderid;
	private int addressid;
	private String recipient;
	private String recipient_phone;
	private String address1;
	private String address2;
	private String address3;
	private String userid;
	private int totalprice;
	private String card;
	private int status;
	
	private String request;
	
	private int selected;
	private Date regdate;
	public int getPurchaseid() {
		return purchaseid;
	}
	public void setPurchaseid(int purchaseid) {
		this.purchaseid = purchaseid;
	}
	public String getOrderid() {
		return orderid;
	}
	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}
	public int getAddressid() {
		return addressid;
	}
	public void setAddressid(int addressid) {
		this.addressid = addressid;
	}
	public String getRecipient() {
		return recipient;
	}
	public void setRecipient(String recipient) {
		this.recipient = recipient;
	}
	public String getRecipient_phone() {
		return recipient_phone;
	}
	public void setRecipient_phone(String recipient_phone) {
		this.recipient_phone = recipient_phone;
	}
	public String getAddress1() {
		return address1;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	public String getAddress3() {
		return address3;
	}
	public void setAddress3(String address3) {
		this.address3 = address3;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public int getTotalprice() {
		return totalprice;
	}
	public void setTotalprice(int totalprice) {
		this.totalprice = totalprice;
	}
	public String getCard() {
		return card;
	}
	public void setCard(String card) {
		this.card = card;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getRequest() {
		return request;
	}
	public void setRequest(String request) {
		this.request = request;
	}
	public int getSelected() {
		return selected;
	}
	public void setSelected(int selected) {
		this.selected = selected;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	@Override
	public String toString() {
		return "OrderVO [purchaseid=" + purchaseid + ", orderid=" + orderid + ", addressid=" + addressid
				+ ", recipient=" + recipient + ", recipient_phone=" + recipient_phone + ", address1=" + address1
				+ ", address2=" + address2 + ", address3=" + address3 + ", userid=" + userid + ", totalprice="
				+ totalprice + ", card=" + card + ", status=" + status + ", request=" + request + ", selected="
				+ selected + ", regdate=" + regdate + "]";
	}
	
	
	
	
	
	
	
}
