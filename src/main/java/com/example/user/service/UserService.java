package com.example.user.service;

import com.example.survey.SurvetInsertDTO;
import com.example.user.domain.UserVO;

public interface UserService {
	public void insert(SurvetInsertDTO requestData);
	public void changeUserSurvey(UserVO vo);
}
