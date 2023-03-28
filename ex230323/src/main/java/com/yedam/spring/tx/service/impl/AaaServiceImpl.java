package com.yedam.spring.tx.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yedam.spring.tx.mapper.AaaMapper;
import com.yedam.spring.tx.service.AaaService;

@Service
public class AaaServiceImpl implements AaaService {
	
	@Autowired
	AaaMapper aaaMapper;
					// 요거 없으면 101만 들어 갔을거임
	@Transactional //요거하면 가다가 잘못 된 값 만나면 첫 번쨰 값도 안 들어가고 롤백 됨 
	@Override
	public void insert() {
		aaaMapper.insert("101");
		aaaMapper.insert("값");
	}

}
