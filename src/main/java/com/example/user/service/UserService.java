package com.example.user.service;

import com.example.survey.SurvetInsertDTO;
import com.example.user.domain.UserVO;

public interface UserService {
	
	public void insert(SurvetInsertDTO requestData); //회원가입+설문결과저장
	public void changeUserSurvey(UserVO vo);
}
