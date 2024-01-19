package com.example.purchase.service;

import java.util.HashMap;
import java.util.List;

import com.example.purchase.domain.PurchaseVO;
import com.example.user.domain.UserVO;

public interface PurchaseService {
	public List<HashMap<String,Object>> listPurchase(PurchaseVO vo);
}
