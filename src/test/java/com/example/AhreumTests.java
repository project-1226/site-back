package com.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.transaction.annotation.Transactional;

import com.example.food.dao.FoodDAO;
import com.example.survey.AnswerVO;
import com.example.survey.SurveyDAO;
import com.example.user.dao.UserDAO;
import com.example.user.domain.UserVO;
import com.example.user.service.UserService;


@SpringBootTest
class AhreumTests {
	
	@Autowired
	FoodDAO fooddao;
	
	@Autowired
	UserDAO udao;
	
	@Autowired
	UserService uservice;
	
	 @MockBean
    private UserDAO userDao;  // UserDAO Mock

    @MockBean
    private SurveyDAO answerDao;  // SurveyDAO Mock

	@Disabled("이 테스트는 필요하지 않습니다.")
	@DisplayName("type별 카테고리리스트 확인")
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
	
	@Disabled("테스트실패.")
	@DisplayName("회원가입시 insert한 userid 받아오기")
	@Test
	@Transactional
	void insertUserTest() {
		//given
		// 1. user
		UserVO user = new UserVO();
		user.setEmail("test1@test1.com");
		user.setPassword("test1");
		//2.survey result
		List<AnswerVO> answers = new ArrayList<AnswerVO>();
		for (int i = 0; i < 10; i++) {
	        AnswerVO answer = new AnswerVO();
	        answer.setSelectid(i + 1);
	        answer.setQuestionid(i + 1);
	        answer.setInput_text("Input Text " + (i + 1));
	        answers.add(answer);
	    }
			
		//3.user insert 이후 userid가져오기
		String new_userid = userDao.insert(user);
		//4. userid setting
		for (AnswerVO answer : answers) {
            answer.setUserid(new_userid);
            System.out.println(answer.toString());
        }
		
		
		//when
//		//serviece test
//		Map<String, Object> requestData = new HashMap<>();		
//		requestData.put("user", user);
//		requestData.put("result",answers);
//		
//		uservice.insert(requestData);
		//answers insert test
		answerDao.insertResult(answers);
		//then
//		System.out.println("!!!!"+user.getUserid());
	}
	
	@Disabled("테스트실패.")
	@DisplayName("answer list insert")
	@Test
	@Transactional
	void insertUserTest2() {
		//given
		
		//survey result
		List<AnswerVO> answers = new ArrayList<AnswerVO>();
		for (int i = 0; i < 10; i++) {
	        AnswerVO answer = new AnswerVO();
	        answer.setSelectid(i + 1);
	        answer.setQuestionid(i + 1);
	        answer.setInput_text("Input Text " + (i + 1));
	        answer.setUserid("1234");
	        answers.add(answer);
	    }
			
		
		//when

		answerDao.insertResult(answers);
		
	
		//then

	}
}
