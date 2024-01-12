package com.example.user.dao;

import java.util.HashMap;
import java.util.List;

import com.example.user.domain.UserShopVO;

public interface UserShopDAO {
	public List<HashMap<String, Object>> listPurchase(UserShopVO vo);
	public int total(String userid);
	public List<HashMap<String, Object>> listDetail(UserShopVO vo);
}
