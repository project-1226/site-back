package com.example.dao;

import java.util.HashMap;

import com.example.domain.UserVO;

public interface UserDAO {
	public HashMap<String, Object> read(UserVO vo);
	public int isUser(UserVO vo);
	public void insert(UserVO vo);
	public void update(UserVO vo);
}
