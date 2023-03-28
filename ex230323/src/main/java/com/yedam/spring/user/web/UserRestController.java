package com.yedam.spring.user.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.yedam.spring.user.service.UserListVO;
import com.yedam.spring.user.service.UserVO;

//�����͸� ��ȯ�ϴ� ��Ʈ�ѷ�
@CrossOrigin
@RestController //@Controller + @ResponseBody => �ش� Ŭ���� ���� ��� ��Ʈ�ѷ��� ��ü�� ��ȯ
public class UserRestController {
	
	@RequestMapping(value="/insertUser", method=RequestMethod.POST)
	public UserVO insertUser(UserVO userVO) {
		System.out.println("name : " + userVO.getName());
		System.out.println("age : " + userVO.getAge());
		
		return userVO;
	}
	
	@RequestMapping("/insertUsers")
	public List<UserVO> insertUserList(UserListVO userListVO){
		for(UserVO user : userListVO.getList()) {
			System.out.println(user);
		}
		
		return userListVO.getList();
	}
	
	@RequestMapping("/getUserData")
	public UserVO getUserData(@RequestParam("id") String name, //("id")�̰� �����ϸ� ?id=value �� �� ã�� ("id")������ ?name=value �� �� ã�� 
							  @RequestParam(required = false) Integer age) { //(required = false)�̰��ϸ� �ʼ� �Է� �� �ص� ��
		UserVO userVO = new UserVO();										 
		userVO.setName(name);
		userVO.setAge(age == null ? 0 : age); //���׿����� null�ϰ�� 0 �ƴϸ� age�� ���� or @RequiredParam�� (defaultValue = 0)�߰�
		
		return userVO;
	}
	
	@GetMapping("/getDataList")
	public String getDataList(@RequestParam(required = false) Map<String, Object> map) {
		String message = null;
		if(map.isEmpty()) {
			message = "�����Ͱ� �������� �ʽ��ϴ�.";
		}else {
			message = "�����Ͱ� �����Ǿ����ϴ�.";
			
			Set<Map.Entry<String,Object>> entryList = map.entrySet();
			for(Map.Entry<String,Object> entry : entryList) {
				System.out.print("Key : " + entry.getKey() );
				System.out.println(", Value : " + entry.getValue() );
			}
		}
		
		return message;
	}
	
	@RequestMapping("/getNames")
	public Map<String, Object> getNames(@RequestParam List<String> name){
		Map<String, Object> map = new HashMap<>();
		map.put("result", "success");
		map.put("data", name);
		
		return map;
	}
	
	@RequestMapping("/getEmpInfo/{employeeName}")
	public UserVO getEmpInfo(@PathVariable String employeeName) {// @PathVariable ��ο� �����͸� �־ ���� ���������� ������� ���� ���ϰ� ��� �� ������ ���� ���ȿ� ����
		UserVO userVO = new UserVO();
		userVO.setName(employeeName);
		
		return userVO;
	}
	
	@RequestMapping("/getInfo")
	public UserVO getInfo(@RequestBody UserVO userVO) { //@RequestBody json ���·� ���� ��
		return userVO;
	}
	
	@PostMapping("/upload")
	public String uploadFile(@RequestPart MultipartFile[] pic) {
		//System.out.println("name : " + userVO.getName());
		//System.out.println("file : " + userVO.getPic().getOriginalFilename());
		
		System.out.println(pic[0].getOriginalFilename());
		
		return "���ε� �Ϸ�.";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
