package com.example.user.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.user.domain.UserShopVO;

@Repository
public class UserShopDAOImpl implements UserShopDAO {
	@Autowired
	SqlSession session;
	
	String namespace="com.example.mapper.UserShopMapper";

	@Override
	public List<HashMap<String, Object>> listPurchase(UserShopVO vo) {
		vo.setStart((vo.getPage() - 1) * vo.getSize());
		return session.selectList(namespace + ".list_purchase", vo);
	}

	@Override
	public int total(String userid) {
		return session.selectOne(namespace + ".total_purchase", userid);
	}

	@Override
	public List<HashMap<String, Object>> listDetail(UserShopVO vo) {
		vo.setStart((vo.getPage() - 1) * vo.getSize());
		return session.selectList(namespace + ".list_detail", vo);
	}

}
