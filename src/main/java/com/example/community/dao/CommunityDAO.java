package com.example.community.dao;

import java.util.HashMap;
import java.util.List;

import com.example.community.domain.PostVO;

public interface CommunityDAO {
	public List<HashMap<String, Object>> list(int categoryid);
	public void insert_post(PostVO vo);
	public List<HashMap<String, Object>> read(int postid);
	public void update_post(PostVO vo);
	
	public List<HashMap<String, Object>> list_comment();
}
