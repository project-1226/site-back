package com.example.service;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.dao.UserDAO;
import com.example.domain.UserVO;

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
}
