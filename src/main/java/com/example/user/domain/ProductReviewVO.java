package com.example.user.domain;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ProductReviewVO {
	private int product_reviewid;
	private String userid;
	private int productid;
	private int purchaseid;
	private String orderid;
	private int purchasedetailid;
	private int score;
	private String content;
	private Date regDate;
	
	private String image_names;
	private String image_urls;
	
	private int start;
	private int page;
	private int size;
}
