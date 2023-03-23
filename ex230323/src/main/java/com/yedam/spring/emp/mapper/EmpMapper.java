package com.yedam.spring.emp.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yedam.spring.emp.service.EmpVO;

public interface EmpMapper {
	//전체 조회
	public List<EmpVO> selectEmpAllList(); 
	
	//단건 조회
	public EmpVO selectEmpInfo(EmpVO empVO);
	
	//등록
	public int insertEmpInfo(EmpVO empVO);
	
	//수정 - 급여를 정해진 비율로 인상 //매개변수가 2개 이상일 때 Mapper.xml SQL문#{}안에 쓰일 변수명을 지정 해 줄 수 있음
	public int updateEmpSal(
			@Param("empId")int employeeId, 
			@Param("raise")int raise);
	
	//수정 = 사원 정보 수정
	public int updateEmpInfo(EmpVO empVO);
	
	//삭제
	public int deleteEmpInfo(int employeeId);
}
