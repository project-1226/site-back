package com.example.community_admin.domain;

import java.util.Date;

public class PostVO {
	private int postid;
	private int categoryid;
	private String userid;
	private String title;
	private String content;
	private Date regdate;
	
	public int getPostid() {
		return postid;
	}
	public void setPostid(int postid) {
		this.postid = postid;
	}
	public int getCategoryid() {
		return categoryid;
	}
	public void setCategoryid(int categoryid) {
		this.categoryid = categoryid;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	
	@Override
	public String toString() {
		return "PostVO [postid=" + postid + ", categoryid=" + categoryid + ", userid=" + userid + ", title=" + title
				+ ", content=" + content + ", regdate=" + regdate + "]";
	}
	
}
