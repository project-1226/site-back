package com.example.user.dao;

import java.util.HashMap;
import java.util.List;

import com.example.user.domain.UserShopVO;

public interface UserShopDAO {
	public List<HashMap<String, Object>> list(UserShopVO vo);
}
