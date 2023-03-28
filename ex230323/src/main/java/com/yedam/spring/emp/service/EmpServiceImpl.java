package com.yedam.spring.emp.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.spring.emp.mapper.EmpMapper;
import com.yedam.spring.emp.service.EmpService;
import com.yedam.spring.emp.service.EmpVO;

@Service
public class EmpServiceImpl implements EmpService {
	
	@Autowired
	EmpMapper empMapper;
	
	
	@Override
	public List<EmpVO> getEmpAll() {
		// TODO Auto-generated method stub
		return empMapper.selectEmpAllList();
	}

	@Override
	public EmpVO getEmp(EmpVO empVO) {
		// TODO Auto-generated method stub
		return empMapper.selectEmpInfo(empVO);
	}

	@Override
	public int insertEmp(EmpVO empVO) {
		// TODO Auto-generated method stub
		int result = empMapper.insertEmpInfo(empVO);
		
		if(result == 1) {
			return empVO.getEmployeeId();
		}else {
			return -1;
		}
	}

	@Override
	public String updateEmpSal(int empId, int raise) {
		String message = null;
		int result = empMapper.updateEmpSal(empId, raise);
		if(result == 1) {
			message = "���������� �޿��� �����Ͽ����ϴ�.";
		}else {
			message = "�۾��� �����߽��ϴ�. �����ȣ�� Ȯ�����ּ���.";
		}
		
		return message;
	}

	@Override
	public Map<String, String> updateEmp(EmpVO empVO) {
		Map<String, String> map = new HashMap<>();
		map.put("�����ȣ", String.valueOf(empVO.getEmployeeId()));
		
		int result = empMapper.updateEmpInfo(empVO);
		
		if(result == 1) {
			map.put("���", "Success");
		}else {
			map.put("���", "Fail");
		}
		
		return map;
	}

	@Override
	public Map<String, String> deleteEmp(int empId) {
		Map<String, String> map = new HashMap<>();
		map.put("�����ȣ", String.valueOf(empId));
		
		int result = empMapper.deleteEmpInfo(empId);
		
		if(result == 1) {
			map.put("���", "Success");
		}else {
			map.put("���", "Fail");
		}
		
		return map;
	}

}
