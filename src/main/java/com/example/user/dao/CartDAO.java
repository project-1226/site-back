package com.example.user.dao;


import java.util.HashMap;

import com.example.user.domain.CartVO;
import com.example.user.domain.UserVO;

import java.util.*;


public interface  CartDAO {
	public List<HashMap<String,Object>> list(UserVO vo);
	public int total(String uid);
	//단일상품 insert
	public void insert(CartVO vo);
	//여러상품 insert
	public int insertList(List<CartVO> voList);
	public void delete(int cartid);
	public int check(CartVO vo);
	public void update(CartVO vo);
	public void updateQnt(CartVO vo);
	public String sum(String uid);
}
