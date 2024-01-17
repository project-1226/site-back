package com.example.community_admin.domain;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CommentVO {
	private int commentid;
	private int postid;
	private String userid;
	private String content;
	private Date regdate;
	private int fcnt;
}
