package com.example.user.domain;

import java.util.Date;

public class ProductReviewVO {
	private int product_reviewid;
	private String userid;
	private int productid;
	private int score;
	private String contentString;
	private Date regDate;
	private String image_urls;

	public int getProduct_reviewid() {
		return product_reviewid;
	}

	public void setProduct_reviewid(int product_reviewid) {
		this.product_reviewid = product_reviewid;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public int getProductid() {
		return productid;
	}

	public void setProductid(int productid) {
		this.productid = productid;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public String getContentString() {
		return contentString;
	}

	public void setContentString(String contentString) {
		this.contentString = contentString;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public String getImage_urls() {
		return image_urls;
	}

	public void setImage_urls(String image_urls) {
		this.image_urls = image_urls;
	}

	@Override
	public String toString() {
		return "ProductReviewVO [product_reviewid=" + product_reviewid + ", userid=" + userid + ", productid="
				+ productid + ", score=" + score + ", contentString=" + contentString + ", regDate=" + regDate
				+ ", image_urls=" + image_urls + "]";
	}

}
