package com.example.user.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ShoppingQnaVO {
	private int categoryid;
	private int postid;
	private String userid;
	private String title;
	private String content;
	private String commentOption;
}
