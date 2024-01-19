package com.example.food.dao;

import com.example.community_admin.domain.ProductVO;

public interface ProductDAO {
	
	//제료관련 상품검색 하나씩?
	public ProductVO searchIngredient(String ingredient); //재료하나로 상품검색
}
