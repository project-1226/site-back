package com.example.user.dao;

import java.util.HashMap;
import java.util.List;

import com.example.user.domain.UserVO;

public interface UserDAO {
	public HashMap<String, Object> read(UserVO vo);
	public int isUser(UserVO vo);
	public void insert(UserVO vo);
	public void update(UserVO vo);
	
	public List<HashMap<String, Object>> listMyExcercise(String userid);
}
