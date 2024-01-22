package com.example.user.domain;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class AddressVO {
	private int addressid;
	private String userid;
	private int selected;
	private String recipient;
	private String recipient_phone;
	private String address1;
	private String address2;
	private String address3;
	private Date regdate;
	private int start;
	private int page;
	private int size;

}
