package com.example.community_admin.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.community_admin.dao.AdminDAO;
import com.example.community_admin.domain.ProductVO;

@Service
public class AdminServiceImpl implements AdminService{

	@Autowired
	AdminDAO dao;
	
	@Transactional
	@Override
	public void insertProduct(ProductVO vo) {
		dao.insertProduct(vo);
		//System.out.println(".........." + vo);
		dao.insertImage(vo);
	}

	@Override
	public void updateProduct(ProductVO vo) {
		dao.updateProduct(vo);
		
	}

	@Transactional
	@Override
	public void deleteProduct(int productid) {
		dao.deleteImage(productid);
		dao.deleteProduct(productid);
	}

}
