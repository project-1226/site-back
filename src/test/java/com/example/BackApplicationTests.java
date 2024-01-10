package com.example;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.food.dao.FoodDAO;
import com.example.food.dao.FoodDAOImpl;

@SpringBootTest
class BackApplicationTests {
	
	
	@Autowired
	FoodDAO fooddao = new FoodDAOImpl();

//	@Test
//	void contextLoads() {
//	}
//	
	
//	@Test
//	void findByCategory() {
//		APIQueryVO vo = new APIQueryVO();
//		vo.setName("폐암질환 식단");
//		vo.setRegdate("2024-01-08");
//		repository.category(vo);
//	}
//	@Test
//	void findByFood() {
//		APIQueryVO vo = new APIQueryVO();
//		vo.setName("돼지고기사과구이");
//		vo.setRegdate("2024-01-08");
//		repository.food(vo);
//	}
	
	@Test
	void categoryList() {
		fooddao.categoryList("health");
	}

}
