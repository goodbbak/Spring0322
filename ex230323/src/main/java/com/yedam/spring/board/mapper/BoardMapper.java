package com.yedam.spring.board.mapper;

import java.util.List;

import com.yedam.spring.board.service.BoardVO;

public interface BoardMapper {
	
	//��ü��ȸ	
	public List<BoardVO> selectBoardList();
	
	//�ܰ���ȸ
	public BoardVO selctBoardInfo(BoardVO boardVO);
	
	//����ϰ��� �ϴ� �� ��ȣ
	public BoardVO getBoardNo();
	//���
	public int insertBoard(BoardVO boardVO);
	
	//����
	public int updateBoard(BoardVO boardVO);
	
	//����
	public int deleteBoard(int BoardNo);
	
}
