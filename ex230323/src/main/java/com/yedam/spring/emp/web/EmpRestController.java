package com.yedam.spring.emp.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.yedam.spring.emp.service.EmpService;
import com.yedam.spring.emp.service.EmpVO;

@CrossOrigin
@RestController //@Controller + @ResponseBody => �ش� Ŭ���� ���� ��� ��Ʈ�ѷ��� ��ü�� ��ȯ
public class EmpRestController {
	
	@Autowired
	EmpService empService;
	
	//��ü��ȸ
	@GetMapping("/emps")
	public List<EmpVO> getEmpList(Model model){
		return empService.getEmpAll();
	}
	
	//�ܰ���ȸ
	@GetMapping("/emps/{employeeId}")
	public EmpVO getEmpInfo(@PathVariable int employeeId) {
		EmpVO empVO = new EmpVO();
		empVO.setEmployeeId(employeeId);
		return empService.getEmp(empVO);
	}
	
	//���
	@PostMapping("/emps")
	public EmpVO insertEmpInfo(@RequestBody EmpVO empVO) {// @RequestBody json������ ���� �� ���
		empService.insertEmp(empVO);
		return empVO;
	}
	
	//����
	@PutMapping("/emps/{employeeId}")
	public EmpVO updateEmpInfo(@PathVariable int employeeId, @RequestBody EmpVO empVO) {//���ڵ��� ��û�κ� ex) ajax ���� �޾ƿ��� ����
		empVO.setEmployeeId(employeeId);
		empService.updateEmp(empVO);
		return empVO;
	}
	
	//����
	@DeleteMapping("/emps/{employeeId}") //put�̶� �Ȱ��� ������µ� RequestBody�� ���°ɷ� ����
	public EmpVO deleteEmpInfo(@PathVariable int employeeId) {
		EmpVO empVO = new EmpVO();
		empVO.setEmployeeId(employeeId);
		empService.deleteEmp(employeeId);
		return empVO; 
	}
	
}
