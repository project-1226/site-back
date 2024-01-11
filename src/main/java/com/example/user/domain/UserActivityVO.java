package com.example.user.domain;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserActivityVO {
//	공통
	private int postid;
	private String userid;
	private String content;
	private Date regdate;
	
	private int page;
	private int size;
	private int start;
	private String query;
	
//	post
	private int categoryid;
	private String title;
	
//	comment 관련
	private int commentid;
}
