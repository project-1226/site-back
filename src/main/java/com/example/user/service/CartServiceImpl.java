package com.example.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.user.dao.CartDAO;
import com.example.user.domain.CartVO;

@Service
public class CartServiceImpl  implements CartService{

	@Autowired
	CartDAO dao;

	@Transactional
	@Override
	public void insert(CartVO vo) {
		int check=dao.check(vo);
		if(check==0) {
			dao.insert(vo);
		}else {
			vo.setCount(1);
			dao.update(vo);
		}
	}

	
}
