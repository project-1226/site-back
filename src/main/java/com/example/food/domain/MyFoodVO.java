package com.example.food.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MyFoodVO extends FoodVO{
	private int foodplanid;
	private String userid;
}
