package com.example.purchase.dao;

import java.util.HashMap;
import java.util.List;

import com.example.purchase.domain.OrderVO;
import com.example.purchase.domain.PurchaseVO;
import com.example.user.domain.UserVO;

public interface PurchaseDAO {
	public List<HashMap<String,Object>> listPurchase(PurchaseVO vo);
	public int getPurchaseIdfordetail(String userid);
	public List<HashMap<String,Object>> listpurchasefromorder(OrderVO vo);
}
