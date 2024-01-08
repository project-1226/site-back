package com.example.community.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.community.domain.PostVO;

@Repository
public class CommunityDAOImpl implements CommunityDAO{

	@Autowired
	SqlSession session;
	
	String namespace="com.example.mapper.CommunityMapper";

	@Override
	public List<HashMap<String, Object>> list(int categoryid) {
		return session.selectList(namespace + ".list", categoryid);
	}

	@Override
	public List<HashMap<String, Object>> read(int postid) {
		return session.selectList(namespace + ".read", postid);
	}

	@Override
	public void insert_post(PostVO vo) {
		session.selectOne(namespace + ".insert_post", vo);
	}

	@Override
	public void update_post(PostVO vo) {
		session.selectOne(namespace + ".update_post", vo);
	}

	@Override
	public List<HashMap<String, Object>> list_comment() {
		return session.selectList(namespace + ".list_comment");
	}
	


}
