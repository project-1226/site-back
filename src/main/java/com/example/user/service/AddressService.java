package com.example.user.service;

import java.util.HashMap;

import com.example.user.domain.AddressVO;

public interface AddressService {
	public HashMap<String, Object> list(AddressVO vo);
	public void insert(AddressVO vo);
	public void update(AddressVO vo);
}
