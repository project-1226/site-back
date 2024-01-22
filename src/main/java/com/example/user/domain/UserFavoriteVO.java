package com.example.user.domain;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserFavoriteVO {
	
	//	공통
	private int favoriteid;
	private String userid;
	private Date regdate;

	//	product (찜한 상품)
	private int productid;
	private String name;
	private int price;
	private String content;
	
	// food(찜 식단)
	private int foodid;
	//	post (스크랩)
	private int postid;

	//	image
	private int imageid;
	private String image_name;
	private String image_url;
	
	//	pagination
	private int page;
	private int size;
	private int start;
}
