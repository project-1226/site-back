package com.example.user.dao;

import java.util.HashMap;
import java.util.List;

import com.example.user.domain.UserActivityVO;

public interface UserActivityDAO {
	public List<HashMap<String, Object>> listPost(UserActivityVO vo);
	public int totalPost(UserActivityVO vo);
	
	public List<HashMap<String, Object>> listComment(UserActivityVO vo);
	public int totalComment(UserActivityVO vo);
	public int countComment(UserActivityVO vo);
}
