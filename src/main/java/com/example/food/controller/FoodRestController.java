package com.example.food.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
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
		
	//카테고리별 식단 리스트
	@GetMapping("/list")
	public  List<FoodVO> foodList(@RequestParam("categoryid") String categoryid) {	
		return	dao.foodListOfCateg(categoryid);
	}
	
	//페이지 type별 카테고리 리스트
	@GetMapping("/categories/{type}")
	public  List<Map<String,Object>> categoryList(@PathVariable("type") String type) {	
		return dao.categoryList(type);
	}
		
	@GetMapping("/myfood/list")
	public List<MyFoodVO> myFoodList(@RequestParam("userid")String userid){
		return dao.myFoodList(userid);
	}
		
    @GetMapping("/myfood/otherlist")
    public List<MyFoodVO> randomMyFood(@RequestParam("categoryid") String categoryid, @RequestParam("foodid") String foodid ) {  	
        return dao.randomMyFood(categoryid,foodid);
    }
    @GetMapping("/myfood/update")
    public int updateMyFood(@RequestParam("foodplanid") String foodplanid, @RequestParam("foodid") String foodid) {	
    	return dao.updateMyFood(foodplanid, foodid);
    }

    @GetMapping("/read/favorite")
    public int isFavorite(@RequestParam("userid") String userid, @RequestParam("foodid") String foodid) {	
    	return dao.readFavorite(userid, foodid);
    }
    
    @GetMapping("/insert/favorite")
    public int insetFavorite(@RequestParam("userid") String userid, @RequestParam("foodid") String foodid) {	
    	return dao.insetFavorite(userid, foodid);
    }
    
    @DeleteMapping("/delete/favorite")
    public int deleteFavorite(@RequestParam("userid") String userid, @RequestParam("foodid") String foodid) {	
    	return dao.deleteFavorite(userid, foodid);
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
