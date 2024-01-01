package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.transaction.annotation.Transactional;

import com.example.dao.user.UserDAO;
import com.example.domain.user.UserVO;

@SpringBootTest
class UserTests {
	@Autowired
	UserDAO dao;
	
	@MockBean
	UserVO vo;

	@Disabled("이 테스트는 필요하지 않습니다.")
	@DisplayName("회원가입시 닉네임, 아바타 자동 설정 테스트")
	@Test
	@Transactional
	void insertTest() {
		//given
		UserVO vo = new UserVO();
		vo.setEmail("test@test.com");
		vo.setPassword("test");
		
		//when
		dao.insert(vo);
		
		//then
		assertEquals("test", vo.getNickname());
		assertEquals("http://via.placeholder.com/100x100?text=T", vo.getAvatar());
	}

}
