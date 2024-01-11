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
	public List<HashMap<String, Object>> list(UserShopVO vo) {
		return session.selectList(namespace + ".list_purchase", vo);
	}

}
