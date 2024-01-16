package com.example.user.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.user.dao.UserDAO;
import com.example.user.domain.UserVO;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserDAO dao;

	@Transactional
	@Override
	public void insert(UserVO vo) {
		HashMap<String, Object> user = dao.read(vo);
		if(user == null) {
			dao.insert(vo);
		} else {
	        throw new RuntimeException("User with this email already exists");
	    }
	}

	@Transactional
	@Override
	public void changeUserSurvey(UserVO vo) {
		List<HashMap<String, Object>> surveyList = dao.getUserSurvey(vo);
		
		HashMap<String, Object> survey = surveyList.isEmpty() ? new HashMap<>() : surveyList.get(0);
		
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
