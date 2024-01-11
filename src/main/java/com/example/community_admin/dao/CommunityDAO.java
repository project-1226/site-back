package com.example.community_admin.dao;

import java.util.HashMap;
import java.util.List;

import com.example.community_admin.domain.PostVO;

public interface CommunityDAO {
	public List<HashMap<String, Object>> list(int categoryid);
	public void insert_post(PostVO vo);
	public HashMap<String, Object> read(int postid);
	public void update_post(PostVO vo);
	public void delete(int postid);
	
	public List<HashMap<String, Object>> list_comment();
	public void insert_comment(String content);
	public List<HashMap<String, Object>> read_comment(int postid);
	public void update_comment(int commentid, String content, int postid);
}
