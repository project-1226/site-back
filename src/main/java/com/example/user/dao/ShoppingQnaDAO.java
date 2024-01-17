package com.example.user.dao;

import java.util.HashMap;
import java.util.List;

import com.example.user.domain.ShoppingQnaVO;

public interface ShoppingQnaDAO {
	public List<HashMap<String, Object>> listFaq(int categoryid);
	
	public void insertQna(ShoppingQnaVO vo);
	public List<HashMap<String, Object>> listQna(String userid);
	public int totalQna(String userid);
	public void deleteQna(ShoppingQnaVO vo);
}
