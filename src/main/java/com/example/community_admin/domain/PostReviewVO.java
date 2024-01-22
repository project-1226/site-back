package com.example.community_admin.domain;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PostReviewVO {
	private int postid;
	private int categoryid;
	private String userid;
	private String title;
	private String content;
	private Date regdate;
	private int cnt;
	private int fcnt;
	private String image_names;
	private String image_urls;
}
