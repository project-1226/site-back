package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.text.SimpleDateFormat;
import java.util.HashMap;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.transaction.annotation.Transactional;

import com.example.user.dao.AddressDAO;
import com.example.user.dao.ProductReviewDAO;
import com.example.user.dao.UserDAO;
import com.example.user.domain.AddressVO;
import com.example.user.domain.ProductReviewVO;
import com.example.user.domain.UserVO;
import com.example.user.service.UserService;

@SpringBootTest
class SeonTests {
	@Autowired
	UserDAO udao;
	
	@Autowired
	UserService uservice;

	@Autowired
	AddressDAO adao;
	
	@Autowired
	ProductReviewDAO pdao;

	@MockBean
	UserVO uvo;

	@MockBean
	AddressVO avo;
	
	@MockBean
	ProductReviewVO pvo;

	@Disabled("이 테스트는 필요하지 않습니다.")
	@DisplayName("회원가입시 닉네임, 아바타 자동 설정")
	@Test
	@Transactional
	void insertUserTest() {
		// given
		UserVO vo = new UserVO();
		vo.setEmail("test@test.com");
		vo.setPassword("test");

		// when
		udao.insert(vo);

		// then
		assertEquals("test", vo.getNickname());
		assertEquals("http://via.placeholder.com/100x100?text=T", vo.getAvatar());
	}

	@Disabled("이 테스트는 필요하지 않습니다.")
	@DisplayName("배송지 삭제")
	@Test
	@Transactional
	void deleteAddressTest() {
		// given
		AddressVO vo = new AddressVO();
		vo.setUserid("e91b8eb6-24af-404a-b");
		vo.setAddressid(14);

		// when
		adao.delete(vo);
		int result;
		result = adao.countRead(vo);

		// then
		assertEquals(0, result);
	}
	
//	@DisplayName("사용자 설문 업데이트 또는 추가를 위한 날짜 일치 여부 확인")
//	@Test
//	@Transactional
//	void changeUserSurveyTest() {
//		//given
//		UserVO vo = new UserVO();
//        vo.setUserid("e91b8eb6-24af-404a-b");
//        vo.setQuestionid(9);
//        vo.setInput_text("58");
//		
//		//when
//        HashMap<String, Object> survey = udao.getUserSurvey(vo);
//		
//		//then
//        assertEquals("58", survey.get("input_text").toString());
//        
//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//        String expectedRegdateStr = "2024-01-15";
//        String actualRegdateStr = dateFormat.format(survey.get("regdate"));
//
//        assertEquals(expectedRegdateStr, actualRegdateStr);
//	}
}
