package com.example.user.dao;

import java.util.HashMap;
import java.util.List;

import com.example.user.domain.UserVO;

public interface UserDAO {
	public HashMap<String, Object> read(UserVO vo);
	public int isUser(UserVO vo);
	public String insert(UserVO vo);
	public void update(UserVO vo);
	
	public List<HashMap<String, Object>> readUserSurvey(String userid);
	public List<HashMap<String, Object>> getUserSurvey(UserVO vo);
	public int isDuplicate(UserVO vo);
	public List<HashMap<String, Object>> listAllergy();
	public void updateUserSurvey(UserVO vo);
	public void insertUserSurvey(UserVO vo);
}
