package com.yedam.spring.emp.service;

import java.util.List;
import java.util.Map;

public interface EmpService {
	//��ü��ȸ
	public List<EmpVO> getEmpAll();
	//�ܰ���ȸ
	public EmpVO getEmp(EmpVO empVO);
	//���
	public int insertEmp(EmpVO empVO);
	//���� - �޿� ����
	public String updateEmpSal(int empId, int raise);
	//���� - ��� ����
	public Map<String,String> updateEmp(EmpVO empVO);
	//����
	public Map<String,String> deleteEmp(int empId);
	
}
