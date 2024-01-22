package com.example.user.dao;

import java.util.HashMap;
import java.util.List;

import com.example.user.domain.UserFavoriteFoodVO;
import com.example.user.domain.UserFavoriteVO;

public interface UserFavoriteDAO {
	public List<HashMap<String, Object>> listImage(UserFavoriteVO vo);
	
	public List<HashMap<String, Object>> listProduct(UserFavoriteVO vo);	
	public int totalProduct(String userid);
	
	public List<UserFavoriteFoodVO> listFood(String userId,int page,int size);
	public int totalFood(String userid);
	
	public void delete(int favoriteid);
	
	
	
}
