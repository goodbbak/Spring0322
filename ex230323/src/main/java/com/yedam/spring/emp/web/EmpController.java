package com.yedam.spring.emp.web;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.yedam.spring.emp.service.EmpService;
import com.yedam.spring.emp.service.EmpVO;

@Controller
public class EmpController {
	@Autowired
	EmpService empService;
	
	//조회(데이터, 일반페이지) -> GET
	//등록, 수정, 삭제 -> POST
	
	//전체조회
	@GetMapping("/empList")
	public String getEmpAllList(Model model) { //받은데이터를 jsp로 넘길 때 model(양방향?)사용
		model.addAttribute("empList", empService.getEmpAll()); //empList.jsp에 ${empList}로 꺼내 쓸 수 있게 넘어감
		return "emp/empList";
	}
	
	//단건조회
	@GetMapping("/empInfo")
	public String getEmpInfo(EmpVO empVO, Model model) {
		model.addAttribute("empInfo", empService.getEmp(empVO));
		
		return "emp/empInfo";
	}
	
	//등록 - Form
	@GetMapping("/empInsert")
	public String empInsertForm() {
		return "emp/empInsert";
	}
	
	//등록 - Process
	@PostMapping("/empInsert")
	public String empInsertProcess(EmpVO empVO, RedirectAttributes rrtt) {//model을 사용하면 redirect할 때 controller한 번 더 거치면서 model값이 사라짐 
		int empId = empService.insertEmp(empVO);
		String result = null;
		if(empId == -1) {
			result = "정상적으로 등록되지 않았습니다.";
		}else {
			result = "정상적으로 등록되었습니다."
					+"\n 등록된 사원의 사번은" + empId + " 입니다."	;
		}
		
		rrtt.addFlashAttribute("result", result); //result를 return보내는 jsp로 보냄
		
		return "redirect:empList";
	}
	
	//수정 -Process
	// 1) Client -Json -> Server
	// 2) Server -Json -> Client
	@PostMapping("/empUpdate")
	@ResponseBody // 메서드의 반환 타입이 View가 아닌 객체인 경우 응답body에 담기위해 사용 
	public Map<String, String> empUpdatePorcess(@RequestBody EmpVO empVO) { //@RequestBody json 문자열 받을 때
		return empService.updateEmp(empVO);
	}
	
	//삭제 
		@PostMapping("/empDelete")
		@ResponseBody // 메서드의 반환 타입이 View가 아닌 객체인 경우 응답body에 담기위해 사용 
		public String empDeleteProcess(@RequestParam int employeeId){ //empList.jsp에서 data : {employeeId : id},로 보냈기에 employeeId여야 됨 
			Map<String, String> map = empService.deleteEmp(employeeId); //RequestParam에 값 꼭 안 받아도 되는 경우 만드려면 required false 추가
			return map.get("결과"); //@RequestParam => 값 하나만 받아야 할 때 사용
		}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
