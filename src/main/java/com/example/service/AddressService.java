package com.example.service;

import java.util.HashMap;
import java.util.List;

import com.example.domain.AddressVO;

public interface AddressService {
	public HashMap<String, Object> list(AddressVO vo);
	public void insert(AddressVO vo);
	public void update(AddressVO vo);
}
