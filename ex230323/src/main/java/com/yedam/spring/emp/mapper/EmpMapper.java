package com.yedam.spring.emp.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yedam.spring.emp.service.EmpVO;

public interface EmpMapper {
	//��ü ��ȸ
	public List<EmpVO> selectEmpAllList(); 
	
	//�ܰ� ��ȸ
	public EmpVO selectEmpInfo(EmpVO empVO);
	
	//���
	public int insertEmpInfo(EmpVO empVO);
	
	//���� - �޿��� ������ ������ �λ� //�Ű������� 2�� �̻��� �� Mapper.xml SQL��#{}�ȿ� ���� �������� ���� �� �� �� ����
	public int updateEmpSal(
			@Param("empId")int employeeId, 
			@Param("raise")int raise);
	
	//���� = ��� ���� ����
	public int updateEmpInfo(EmpVO empVO);
	
	//����
	public int deleteEmpInfo(int employeeId);
}
