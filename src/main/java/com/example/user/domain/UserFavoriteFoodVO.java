package com.example.user.domain;

import com.example.food.domain.MyFoodVO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserFavoriteFoodVO extends MyFoodVO{
	private int favoriteid;
	private String fmtdate;
}
