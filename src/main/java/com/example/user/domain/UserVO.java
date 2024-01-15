package com.example.user.domain;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserVO {
	private String userid;
	private String email;
	private String password;
	private String nickname;
	private String phone;
	private String avatar;
	private int point;
	private Date regdate;
	
	private int questionid;
	private int selectid;
    private String input_text;
}
