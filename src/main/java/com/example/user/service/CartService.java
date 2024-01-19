package com.example.user.service;

import java.util.List;

import com.example.user.domain.CartVO;

public interface  CartService {
	public void insert(CartVO vo);
	public int insertList(List<String> ingreList);
}
