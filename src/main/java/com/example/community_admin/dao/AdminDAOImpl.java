package com.example.community_admin.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.community_admin.domain.PostVO;
import com.example.community_admin.domain.ProductVO;

@Repository
public class AdminDAOImpl implements AdminDAO{

	@Autowired
	SqlSession session;
	
	String namespace="com.example.mapper.AdminMapper";
	
	@Override
	public void insert(PostVO vo) {
		session.insert(namespace + ".insert", vo);
	}

	@Override
	public List<HashMap<String, Object>> list(int categoryid) {
		return session.selectList(namespace + ".list", categoryid);
	}

	@Override
	public void update(PostVO vo) {
		session.update(namespace + ".update", vo);
	}

	@Override
	public List<HashMap<String, Object>> userList() {
		return session.selectList(namespace + ".userList");
	}

	@Override
	public void insertProduct(ProductVO vo) {
		session.insert(namespace + ".insertProduct", vo);
	}

	@Override
	public void insertProR(HashMap<String, Object> map) {
		session.insert(namespace + ".insertProR", map);
	}

	@Override
	public void updateProduct(ProductVO vo) {
		session.update(namespace + ".updateProduct", vo);
	}

}
