package com.example.food.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.food.dao.FoodDAO;
import com.example.food.domain.FoodVO;

@RestController
@RequestMapping("/food")
public class FoodRestController {
	@Autowired
	FoodDAO dao;
	
	//카테고리 리스트
	@GetMapping("/categories/{type}")
	public  List<Map<String,Object>> categoryList(@PathVariable("type") String type) {	
		return dao.categoryList(type);
	}
	
	//카테고리 리스트
	@GetMapping("/health.list")
	public  List<FoodVO> foodList(@RequestParam("categoryid") String categoryid) {	
		return	dao.foodListOfCateg(categoryid);
	}
}
