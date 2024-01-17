package com.example.community_admin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.community_admin.dao.CommunityDAO;

@Service
public class CommunityServiceImpl implements CommunityService{

	@Autowired
	CommunityDAO dao;

	@Transactional
	@Override
	public void insertFavorite(String userid, int commentid) {
		dao.insertFavorite(userid, commentid);
		dao.updateFavorite(commentid, 1);
	}

	@Transactional
	@Override
	public void deleteFavorite(String userid, int commentid) {
		dao.deleteFavorite(userid, commentid);
		dao.updateFavorite(commentid, -1);
	}

	@Transactional
	@Override
	public void delete(int postid) {
		dao.delete_image(postid);
		dao.delete_all_comment(postid);
		dao.delete(postid);
	}
	
	
}
