package com.example.user.dao;

import java.util.HashMap;
import java.util.List;

import com.example.user.domain.AddressVO;

public interface AddressDAO {
	public List<HashMap<String, Object>> list(AddressVO vo);
	public int total(AddressVO vo);
	public HashMap<String, Object> read(AddressVO vo);
	
	public int countList(AddressVO vo);
	public int countRead(AddressVO vo);
	
	public void insert(AddressVO vo);
	public void update(AddressVO vo);
	public void update_select(AddressVO vo);
	public void delete(AddressVO vo);
}
