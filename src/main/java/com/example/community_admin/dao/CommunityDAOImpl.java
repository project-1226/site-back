package com.example.community_admin.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.community_admin.domain.CommentVO;
import com.example.community_admin.domain.PostReviewVO;
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
	public HashMap<String, Object> read_review(int postid, int categoryid) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("postid", postid);
		map.put("categoryid", categoryid);
		return session.selectOne(namespace + ".read_review", map);
	}
	
	@Override
	public void insert(HashMap<String, Object> map) {
		session.insert(namespace + ".insert", map);
	}
	
	@Override
	public void insert_review(PostReviewVO vo) {
		session.insert(namespace + ".insert_review", vo);
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
	public void insert_comment(PostVO vo) {
		session.insert(namespace + ".insert_comment", vo);
	}
	
	@Override
	public List<HashMap<String, Object>> read_comment(String userid, int postid) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("userid", userid);
		map.put("postid", postid);
		return session.selectList(namespace + ".read_comment", map);
	}

	@Override
	public void update_comment(HashMap<String, Object> map) {
		session.update(namespace + ".update_comment", map);
	}
	
	@Override
	public void delete_comment(int commentid) {
		session.delete(namespace + ".delete_comment", commentid);
	}

	@Override
	public int total_comment(int postid) {
		return session.selectOne(namespace + ".total_comment", postid);
	}

	@Override
	public List<HashMap<String, Object>> list_review() {
		return session.selectList(namespace + ".list_review");
	}

	@Override
	public void update_post_cnt(int postid) {
		session.update(namespace + ".update_post_cnt", postid);
	}

	@Override
	public void insertFavorite(String userid, int commentid) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("userid", userid);
		map.put("commentid", commentid);
		session.insert(namespace + ".insert_favorite", map);
	}

	@Override
	public void deleteFavorite(String userid, int commentid) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("userid", userid);
		map.put("commentid", commentid);
		session.delete(namespace + ".delete_favorite", map);
	}

	@Override
	public void updateFavorite(int commentid, int amount) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("commentid", commentid);
		map.put("amount", amount);
		session.update(namespace + ".update_favorite", map);
	}

	@Override
	public List<HashMap<String, Object>> image_list(int postid) {
		return session.selectList(namespace + ".image_list", postid);
	}

	@Override
	public void delete_all_comment(int postid) {
		session.delete(namespace + ".delete_all_comment", postid);
	}

	@Override
	public void delete_image(int postid) {
		session.delete(namespace + ".delete_image", postid);
	}

}
