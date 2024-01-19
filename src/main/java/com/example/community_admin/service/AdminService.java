package com.example.community_admin.service;

import com.example.community_admin.domain.ProductVO;


public interface AdminService {
	public void insertProduct(ProductVO vo);
	public void updateProduct(ProductVO vo);
	public void deleteProduct(int productid);
	
}
