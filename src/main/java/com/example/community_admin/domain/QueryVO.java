package com.example.community_admin.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class QueryVO {
	private String query;
	private int size;
	private int page;
	private int start;
	private String key;
}
