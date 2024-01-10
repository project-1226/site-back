package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.transaction.annotation.Transactional;

import com.example.food.dao.FoodDAO;
import com.example.user.dao.AddressDAO;
import com.example.user.dao.UserDAO;
import com.example.user.domain.AddressVO;
import com.example.user.domain.UserVO;

@SpringBootTest
class FoodTest {
	@Autowired
	FoodDAO fooddao;

	@Disabled("이 테스트는 필요하지 않습니다.")
	@DisplayName("회원가입시 닉네임, 아바타 자동 설정 테스트")
	@Test
	void categoryList() {
		// given 
		//health또는 disease
		
		//when 
		//health
		
		// then
		//db조회결과 콘솔 확인
		fooddao.categoryList("health");
	}

}
