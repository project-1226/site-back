package com.example.food.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class FoodVO {
	private int categoryid;
	private int foodid;
	private String name;
	private int kcal;
	private String image;
	private String ingredients;
	private String recipe;
	private String regdate;
	private String description;
}
