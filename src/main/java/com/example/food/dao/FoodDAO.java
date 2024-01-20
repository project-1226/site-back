package com.example.food.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestParam;

import com.example.food.domain.FoodVO;
import com.example.food.domain.MyFoodVO;

public interface FoodDAO {
	
	//1. food
	//카테고리별 음식, 랜덤 6개(랜덤으로select -> limit 6)
	public List<FoodVO> foodListOfCateg(String categoryid);
	//health,desease(page type)으로 건강식단,질환식단의 경우로 나눠 카테고리 리스트 가져오기
	public List<Map<String,Object>> categoryList(String type);	
	 
	//2. my_food_plan
	//최신 추천식단 가져오기(추후 수정예정 -> 서비스단에서 날짜체크이후 사용)
	public List<MyFoodVO> myFoodList(String userid);
	//추천식단 등록하기 
//	public List<MyFoodVO> insertmyFoodList(List<MyFoodVO>??)
	
	public List<MyFoodVO> randomMyFood(String categoryid, String foodid); 
	public int updateMyFood( String foodplanid,  String foodid);
	public int readFavorite(String userid,  String foodid);
	public int insetFavorite(String userid,  String foodid);
	public int deleteFavorite(String userid,  String foodid);
	
	//마이페이지 - 푸드플랜
	public List<HashMap<String, Object>> myFoodPlanDate(String userid);
	public List<HashMap<String, Object>> myFoodPlanListOfDate(MyFoodVO vo);

}
