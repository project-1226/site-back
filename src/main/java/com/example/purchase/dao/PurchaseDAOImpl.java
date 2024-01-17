package com.example.purchase.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.purchase.domain.OrderVO;
import com.example.purchase.domain.PurchaseVO;

@Repository
public class PurchaseDAOImpl implements PurchaseDAO{
	@Autowired
	SqlSession session; // SqlSession 주입
	 
	String namespace="com.example.mapper.OrderMapper";
	@Override
	public List<HashMap<String, Object>> listPurchase(PurchaseVO vo) {
		// TODO Auto-generated method stub
		return session.selectList(namespace + ".purchasedetaillist", vo);
	}
	@Override
	public int getPurchaseIdfordetail(String userid) {
		// TODO Auto-generated method stub
		return session.selectOne(namespace+".getpurchaseidfordetail",userid);
	}
	@Override
	public List<HashMap<String, Object>> listpurchasefromorder(OrderVO vo) {
		// TODO Auto-generated method stub
		return session.selectList(namespace + ".orderlist", vo);
	}

}
