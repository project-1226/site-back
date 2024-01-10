package com.example.food.dao;

import java.util.List;
import java.util.Map;

import com.example.food.domain.FoodVO;

public interface FoodDAO {
	
	//health,desease등 으로 분기되는카테고리 리스트
//	public List<String> categoryList(String type);
	public List<Map<String,Object>> categoryList(String type);
	
	//카테고리별 음식리스트 랜덤 ?개
	public List<FoodVO> foodListOfCateg(String categoryid); 

}
