package com.example.food.domain;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class FoodVO {
//	private List<FoodVO> foods = new ArrayList<>();
	
	private int categoryid;
	private String cname;
	
	private int foodid;
	private String name;
	private int kcal;
	private String image;
	private String ingredients;
	private String recipe;
	private LocalDate regdate;
	private String description;
	private String vidioid;

}
