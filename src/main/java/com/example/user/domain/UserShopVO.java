package com.example.user.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserShopVO {
	
	private int page;
	private int size;
	private int start;
	private String query;
}
