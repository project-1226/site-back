package com.example.user.dao;

import java.util.HashMap;
import java.util.List;

import com.example.user.domain.UserFavoriteVO;

public interface UserFavoriteDAO {
	public List<HashMap<String, Object>> listImage(UserFavoriteVO vo);
	
	public List<HashMap<String, Object>> listProduct(UserFavoriteVO vo);
	public int totalProduct(String userid);
	public void delete(int favoriteid);
	
	
	
}
