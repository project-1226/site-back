package com.example.user.dao;


import java.util.HashMap;

import com.example.user.domain.CartVO;
import com.example.user.domain.UserVO;

import java.util.*;


public interface  CartDAO {
	public List<HashMap<String,Object>> list(UserVO vo);
	public int total(String uid);
	public void insert(CartVO vo);
	public void delete(int cartid);
	public int check(CartVO vo);
	public void update(CartVO vo);
	public void updateQnt(CartVO vo);
	public String sum(String uid);
}
