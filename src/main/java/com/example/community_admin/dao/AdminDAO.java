package com.example.community_admin.dao;

import java.util.HashMap;
import java.util.List;

import com.example.community_admin.domain.CommentVO;
import com.example.community_admin.domain.PostVO;
import com.example.community_admin.domain.ProductVO;
import com.example.community_admin.domain.QueryVO;

public interface AdminDAO {
	public void insert(PostVO vo);
	public List<HashMap<String, Object>> list(int categoryid);
	public void update(PostVO vo);
	public void deletePost(int postid);
	
	public List<HashMap<String, Object>> userList();
	public List<HashMap<String, Object>> productList(QueryVO vo);
	public int total(QueryVO vo);
	
	public void insertProduct(ProductVO vo);
	public void insertProR(HashMap<String, Object> map);
	public void updateProduct(ProductVO vo);
	public void deleteProduct(int productid);
	public void deleteImage(int productid);
	
	public List<HashMap<String, Object>> imageList(int productid);
	public void insertImage(ProductVO vo);
	
	public List<HashMap<String, Object>> qnaList(String userid);
	public void insertQnaComment(CommentVO vo);
	public List<HashMap<String, Object>> orderList();
}
