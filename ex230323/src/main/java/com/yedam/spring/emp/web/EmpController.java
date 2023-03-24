package com.yedam.spring.emp.web;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.yedam.spring.emp.service.EmpService;
import com.yedam.spring.emp.service.EmpVO;

@Controller
public class EmpController {
	@Autowired
	EmpService empService;
	
	//��ȸ(������, �Ϲ�������) -> GET
	//���, ����, ���� -> POST
	
	//��ü��ȸ
	@GetMapping("/empList")
	public String getEmpAllList(Model model) { //���������͸� jsp�� �ѱ� �� model(�����?)���
		model.addAttribute("empList", empService.getEmpAll());
		return "emp/empList";
	}
	
	//�ܰ���ȸ
	@GetMapping("/empInfo")
	public String getEmpInfo(EmpVO empVO, Model model) {
		model.addAttribute("empInfo", empService.getEmp(empVO));
		
		return "emp/empInfo";
	}
	
	//��� - Form
	@GetMapping("/empInsert")
	public String empInsertForm() {
		return "emp/empInsert";
	}
	
	//��� - Process
	@PostMapping("/empInsert")
	public String empInsertProcess(EmpVO empVO, RedirectAttributes rrtt) {//model�� ����ϸ� redirect�� �� controller�� �� �� ��ġ�鼭 model���� ����� 
		int empId = empService.insertEmp(empVO);
		String result = null;
		if(empId == -1) {
			result = "���������� ��ϵ��� �ʾҽ��ϴ�.";
		}else {
			result = "���������� ��ϵǾ����ϴ�."
					+"\n ��ϵ� ����� �����" + empId + " �Դϴ�."	;
		}
		
		rrtt.addFlashAttribute("result", result); //result�� return������ jsp�� ����
		
		return "redirect:empList";
	}
	
	//���� -Process
	// 1) Client -Json -> Server
	// 2) Server -Json -> Client
	@PostMapping("/empUpdate")
	@ResponseBody
	public Map<String, String> empUpdatePorcess(@RequestBody EmpVO empVO) {
		return empService.updateEmp(empVO);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
