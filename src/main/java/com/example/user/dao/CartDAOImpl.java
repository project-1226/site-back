package com.example.user.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.user.domain.CartVO;
import com.example.user.domain.UserVO;

@Repository
public class CartDAOImpl implements CartDAO {
	@Autowired 
	SqlSession session;
	String namespace="com.example.mapper.CartMapper";
	
	@Override
	public List<HashMap<String, Object>> list(UserVO vo) {
		// TODO Auto-generated method stub
		return session.selectList(namespace + ".list", vo);
	}

	@Override
	public int total(String uid) {
		// TODO Auto-generated method stub
		return session.selectOne(namespace + ".total", uid);
	}

	@Override
	public void insert(CartVO vo) {
		// TODO Auto-generated method stub
		session.insert(namespace + ".insert", vo);
	}
	
	

	@Override
	public void delete(int cartid) {
		// TODO Auto-generated method stub
		session.delete(namespace + ".delete", cartid);
	}

	@Override 
	public int check(CartVO vo) {
		// TODO Auto-generated method stub
		return session.selectOne(namespace + ".check", vo);
	}

	@Override
	public void update(CartVO vo) {
		// TODO Auto-generated method stub
		session.update(namespace + ".update", vo);
	}

	@Override
	public void updateQnt(CartVO vo) {
		// TODO Auto-generated method stub
		session.update(namespace + ".update_qnt", vo);
	}

	@Override
	public String sum(String uid) {
		// TODO Auto-generated method stub
		return session.selectOne(namespace + ".sum", uid);
	}

	@Override
	public int insertList(List<CartVO> voList) { //여러상품 insert
		for(CartVO vo:voList) {
			session.insert(namespace+".insert",vo);
		}
		
		
		//return session.insert(namespace+".insertList",voList);
		return 1;
		
	}

	
}
