package com.example.purchase.dao;

import java.util.HashMap;
import java.util.List;

import com.example.purchase.domain.OrderVO;
import com.example.user.domain.CartVO;
import com.example.user.domain.UserVO;

public interface OrderDAO {
	public List<HashMap<String,Object>> listPurchase(UserVO vo);
	public void insert(OrderVO vo);
	public int getLastAddress(String userid);
	public void purchaseinsert(OrderVO vo);
	public int getPurchaseId(String userid);
	public void purchasedetailiinsert(OrderVO vo);
	 public void deleteCartByUserId(String userid);
}
