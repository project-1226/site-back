package com.example.community_admin.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.community_admin.domain.PostVO;

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
	public HashMap<String, Object> read(int postid) {
		return session.selectOne(namespace + ".read", postid);
	}

	@Override
	public void insert_post(PostVO vo) {
		session.insert(namespace + ".insert_post", vo);
	}

	@Override
	public void update_post(PostVO vo) {
		session.update(namespace + ".update_post", vo);
	}
	
	@Override
	public void delete(int postid) {
		session.delete(namespace + ".delete", postid);
	}


	@Override
	public List<HashMap<String, Object>> list_comment() {
		return session.selectList(namespace + ".list_comment");
	}

	@Override
	public void insert_comment(String content) {
		session.insert(namespace + ".insert_comment", content);
	}

	
	public List<HashMap<String, Object>> read_comment(int postid){
		return session.selectList(namespace + ".read_comment", postid);
	}

	@Override
	public void update_comment(int commentid, String content, int postid) {
		// TODO Auto-generated method stub
		
	}

	

}
