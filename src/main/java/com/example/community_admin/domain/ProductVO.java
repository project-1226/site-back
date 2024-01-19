package com.example.community_admin.domain;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ProductVO {
	private int productid;
	private String name;
	private int price;
	private String content;
	private Date regdate;
	private String image_url;
}
