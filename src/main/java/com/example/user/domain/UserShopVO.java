package com.example.user.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserShopVO {
	private int purchaseid;
	private String orderid;
	private int addressid;
	private String userid;
	private int totalprice;
	private String card;
	private int status; // 0:결제대기중 1:결제완료 2:배송준비중 3:배송중 4:배송완료 5:구매확정
	private String request;
	
	private int purchasedetailid;
	private int productid;
	private int price;
	private int count;
	private String name;
	private String content;
	
	private int imageid;
	private String image_name;
	private String image_url;
	
	private int page;
	private int size;
	private int start;
	private String query;
}
