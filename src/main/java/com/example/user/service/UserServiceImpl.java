package com.example.user.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.survey.AnswerVO;
import com.example.survey.SurvetInsertDTO;
import com.example.survey.SurveyDAO;
import com.example.user.dao.UserDAO;
import com.example.user.domain.UserVO;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserDAO dao;
	
	@Autowired
	SurveyDAO sdao;

	@Transactional
	@Override
	public void insert(SurvetInsertDTO requestData) {
		UserVO user = (UserVO) requestData.getUser();
		List<AnswerVO> answers = (List<AnswerVO>) requestData.getResult();
		System.out.println(user.toString());
		for (AnswerVO answer : answers) {           
            System.out.println("------------"+answer.toString());
        }
		
		
		HashMap<String, Object> read_user = dao.read(user);
		if(read_user == null) {
			String new_userid =  dao.insert(user);
			
			System.out.println("!!!!!!!!!"+new_userid);
			
			for (AnswerVO answer : answers) {
	            answer.setUserid(new_userid);
	            System.out.println("------------"+answer.toString());
	        }
			
			sdao.insertResult(answers);
			
		} else {
	        throw new RuntimeException("User with this email already exists");
	    }
	}

	@Transactional
	@Override
	public void changeUserSurvey(UserVO vo) {
		HashMap<String, Object> survey = dao.getUserSurvey(vo);
		
		Date currentDate = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String currentRegdateStr = dateFormat.format(currentDate);
        String prevRegdateStr = dateFormat.format(survey.get("regdate"));
        
        vo.setRegdate(new Date());

        if (currentRegdateStr.equals(prevRegdateStr)) {
            dao.updateUserSurvey(vo);
        } else {
            dao.insertUserSurvey(vo);
        }
	}
	
}
