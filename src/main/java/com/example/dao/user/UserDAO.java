package com.example.dao.user;

import java.util.HashMap;

import com.example.domain.user.UserVO;

public interface UserDAO {
	public HashMap<String, Object> read(String email);
	public void insert(UserVO vo);
}
