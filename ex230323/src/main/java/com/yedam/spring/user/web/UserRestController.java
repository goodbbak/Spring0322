package com.yedam.spring.user.web;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.yedam.spring.user.service.UserVO;

@CrossOrigin
//�����͸� ��ȯ�ϴ� ��Ʈ�ѷ�
@RestController
public class UserRestController {
	
	@RequestMapping(value="/insertUser", method=RequestMethod.POST)
	public UserVO insertUser(UserVO userVO) {
		System.out.println("name : " + userVO.getName());
		System.out.println("age : " + userVO.getAge());
		
		return userVO;
	}
}
