package com.example.community_admin.service;

public interface CommunityService {
	public void delete(int postid);
	public void insertFavorite(String userid, int commentid);
	public void deleteFavorite(String userid, int commentid);
}
