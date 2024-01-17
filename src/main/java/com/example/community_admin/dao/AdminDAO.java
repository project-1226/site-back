package com.example.community_admin.dao;

import java.util.HashMap;
import java.util.List;

import com.example.community_admin.domain.PostVO;
import com.example.community_admin.domain.ProductVO;

public interface AdminDAO {
	public void insert(PostVO vo);
	public List<HashMap<String, Object>> list(int categoryid);
	public void update(PostVO vo);
	
	public List<HashMap<String, Object>> userList();
	public void insertProduct(ProductVO vo);
	public void insertProR(HashMap<String, Object> map);
	public void updateProduct(ProductVO vo);
}
