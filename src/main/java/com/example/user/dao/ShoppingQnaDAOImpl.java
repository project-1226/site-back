package com.example.user.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ShoppingQnaDAOImpl implements ShoppingQnaDAO {
	@Autowired
	SqlSession session;
	
	String namespace="com.example.mapper.ShoppingQnaMapper";

	@Override
	public List<HashMap<String, Object>> list(int categoryid) {
		return session.selectList(namespace + ".list", categoryid);
	}
	
	
}
