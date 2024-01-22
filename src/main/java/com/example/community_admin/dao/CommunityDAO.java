package com.example.community_admin.dao;

import java.util.HashMap;
import java.util.List;

import com.example.community_admin.domain.CommentVO;
import com.example.community_admin.domain.PostReviewVO;
import com.example.community_admin.domain.PostVO;

public interface CommunityDAO {
	public List<HashMap<String, Object>> list(int categoryid);
	public List<HashMap<String, Object>> list_review();
	public HashMap<String, Object> read_review(int postid, int categoryid);
	public List<HashMap<String, Object>> image_list(int postid);
	
	public void insert(HashMap<String, Object> map);
	public void insert_review(PostReviewVO vo);
	public HashMap<String, Object> read(int postid);
	public void update_post(PostVO vo);
	public void delete(int postid);
	
	public List<HashMap<String, Object>> list_comment();
	public void insert_comment(PostVO vo);
	public List<HashMap<String, Object>> read_comment(String userid, int postid);
	public void update_comment(HashMap<String, Object> map);
	public void delete_comment(int commentid);
	public void delete_all_comment(int postid);
	public int total_comment(int postid);
	
	/**
	 * 게시글 조회수 업데이트
	 * @param postid
	 */
	public void update_post_cnt(int postid);
	
	//댓글 좋아요 추가/삭제
	public void insertFavorite(String userid, int commentid);
	public void deleteFavorite(String userid, int commentid);
	public void updateFavorite(int commentid, int amount);
	
	public void delete_image(int postid);
	
}
