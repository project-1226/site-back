package com.example.user.service;

import com.example.user.domain.UserVO;

public interface UserService {
	public void insert(UserVO vo);
	public void changeUserSurvey(UserVO vo);
}
