package com.example.user.dao;

import java.util.HashMap;
import java.util.List;

import com.example.user.domain.ShoppingQnaVO;

public interface ShoppingQnaDAO {
	public List<HashMap<String, Object>> listFaq(int categoryid);
	
	public void insertQna(ShoppingQnaVO vo);
	public List<HashMap<String, Object>> listQna(ShoppingQnaVO vo);
	public int totalQna(ShoppingQnaVO vo);
	public void deleteQna(ShoppingQnaVO vo);
	
	public List<HashMap<String, Object>> listAll(String commentOption);
}
