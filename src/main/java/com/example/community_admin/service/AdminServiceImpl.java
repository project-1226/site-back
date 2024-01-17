package com.example.community_admin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.community_admin.dao.AdminDAO;
import com.example.community_admin.domain.ProductVO;

@Service
public class AdminServiceImpl implements AdminService{

	@Autowired
	AdminDAO dao;
	
	@Override
	public void insertProduct(ProductVO vo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateProduct(ProductVO vo) {
		dao.updateProduct(vo);
		
		
	}

}
