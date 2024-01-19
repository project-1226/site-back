package com.example.food.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.food.dao.FoodDAO;
import com.example.food.domain.FoodVO;
import com.example.food.domain.MyFoodVO;

@RestController
@RequestMapping("/food")
public class FoodRestController {
	@Autowired
	FoodDAO dao;
	
	//카테고리 리스트
	//type(health.disease -> 수정?)
	@GetMapping("/categories/{type}")
	public  List<Map<String,Object>> categoryList(@PathVariable("type") String type) {	
		return dao.categoryList(type);
	}
	
	//카테고리 리스트
	//api수정해야함 health말고
	@GetMapping("/list")
	public  List<FoodVO> foodList(@RequestParam("categoryid") String categoryid) {	
		return	dao.foodListOfCateg(categoryid);
	}
	
	@GetMapping("/my_food_list")
	public List<MyFoodVO> myFoodList(@RequestParam("userid")String userid){
		return dao.myFoodList(userid);
	}
	
    @GetMapping("/random-my-food")
    public List<MyFoodVO> randomMyFood(@RequestParam("categoryid") String categoryid, @RequestParam("foodid") String foodid ) {
    	
        return dao.randomMyFood(categoryid,foodid);
    }
    
    
    //마이페이지 - 플랜 출력
	@GetMapping("/mypage/plandate")
	public List<HashMap<String, Object>> myFoodPlanDate(@RequestParam("userid") String userid) {
		return dao.myFoodPlanDate(userid);
	}

	@GetMapping("/mypage/plan")
	public List<HashMap<String, Object>> myFoodPlanListOfDate(@ModelAttribute("vo") MyFoodVO vo) {
		return dao.myFoodPlanListOfDate(vo);
	}
}
