package com.yedam.spring.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

public class BoardServiceImpl implements BoardService {
	@Autowired
	BoardService boardService;
	
	//��ü��ȸ
	@Override
	public List<BoardVO> getBoardList() {
		return boardService.getBoardList();
	}
	
	//�ܰ���ȸ
	@Override
	public BoardVO getBoardInfo(BoardVO boardVO) {
		return boardService.getBoardInfo(boardVO);
	}
	
	//����ϰ��� �ϴ� �� ��ȣ
	@Override
	public BoardVO getBoardNo() {
		return boardService.getBoardNo();
	}
	
	//��� - ��ϵ� �� ��ȣ ��ȯ ���н� -1 ��ȯ
	@Override
	public int insertBoardInfo(BoardVO boardVO) {
		int result = boardService.insertBoardInfo(boardVO);
		if(result > 0) {
			return Integer.valueOf(boardVO.getBno());
		}else {
			return -1;
		}
	}
	
	//���� - ������ �� ��ȣ ��ȯ ���н� -1 ��ȯ
	@Override
	public int updateBoardInfo(BoardVO boardVO) {
		int result = boardService.updateBoardInfo(boardVO);
		if(result > 0) {
			return Integer.valueOf(boardVO.getBno());
		}else {
			return -1;
		}
	}
	
	//���� - ������ �� ��ȣ ��ȯ ���н� -1 ��ȯ
	@Override
	public int deleteBoardInfo(int BoardNo) {
		int result = boardService.deleteBoardInfo(BoardNo);
		if(result > 0) {
			return BoardNo;
		}else {
			return -1;
		}
	}

}
