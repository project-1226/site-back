package com.example.purchase.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.purchase.domain.OrderVO;
import com.example.user.domain.UserVO;
@Repository
public class OrderDAOImpl implements OrderDAO {
	@Autowired 
	SqlSession session;
	String namespace="com.example.mapper.OrderMapper";
	@Override
	public List<HashMap<String, Object>> listPurchase(UserVO vo) {
		// TODO Auto-generated method stub
		return session.selectList(namespace + ".list", vo);
	}
	@Override
	public void insert(OrderVO vo) {
		// TODO Auto-generated method stubZ
		session.insert(namespace + ".insert", vo);
	}
	@Override
	public int getLastAddress(String userid) {
		// TODO Auto-generated method stub
		return session.selectOne(namespace+".getaddressid",userid);
	}
	@Override
	public void purchaseinsert(OrderVO vo) {
		// TODO Auto-generated method stub
		session.insert(namespace + ".insert", vo);
		
	}
	@Override
	public int getPurchaseId(String userid) {
		// TODO Auto-generated method stub
		return session.selectOne(namespace+".getpurchaseid",userid);
	}
	@Override
	public void purchasedetailiinsert(OrderVO vo) {
		// TODO Auto-generated method stub
		session.insert(namespace + ".purchasedetailinsert", vo);
	}
	@Override
    public void deleteCartByUserId(String userid) {
        session.delete(namespace + ".deleteCartByUserId", userid);
    }
	

}
