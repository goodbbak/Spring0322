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

//데이터를 반환하는 컨트롤러
@CrossOrigin
@RestController //@Controller + @ResponseBody => 해당 클래스 내의 모든 컨트롤러는 객체를 반환
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
	public UserVO getUserData(@RequestParam("id") String name, //("id")이거 지정하면 ?id=value 로 값 찾음 ("id")없으면 ?name=value 로 값 찾음 
							  @RequestParam(required = false) Integer age) { //(required = false)이거하면 필수 입력 안 해도 됨
		UserVO userVO = new UserVO();										 
		userVO.setName(name);
		userVO.setAge(age == null ? 0 : age); //삼항연산자 null일경우 0 아니면 age값 넣음 or @RequiredParam에 (defaultValue = 0)추가
		
		return userVO;
	}
	
	@GetMapping("/getDataList")
	public String getDataList(@RequestParam(required = false) Map<String, Object> map) {
		String message = null;
		if(map.isEmpty()) {
			message = "데이터가 존재하지 않습니다.";
		}else {
			message = "데이터가 생성되었습니다.";
			
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
	public UserVO getEmpInfo(@PathVariable String employeeName) {// @PathVariable 경로에 데이터를 넣어서 보냄 데이터인지 경로인지 구분 못하고 어디에 들어갈 값인지 몰라서 보안에 유리
		UserVO userVO = new UserVO();
		userVO.setName(employeeName);
		
		return userVO;
	}
	
	@RequestMapping("/getInfo")
	public UserVO getInfo(@RequestBody UserVO userVO) { //@RequestBody json 형태로 받을 때
		return userVO;
	}
	
	@PostMapping("/upload")
	public String uploadFile(@RequestPart MultipartFile[] pic) {
		//System.out.println("name : " + userVO.getName());
		//System.out.println("file : " + userVO.getPic().getOriginalFilename());
		
		System.out.println(pic[0].getOriginalFilename());
		
		return "업로드 완료.";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
