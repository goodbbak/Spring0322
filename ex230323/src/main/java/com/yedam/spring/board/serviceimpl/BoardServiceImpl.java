package com.yedam.spring.board.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.spring.board.mapper.BoardMapper;
import com.yedam.spring.board.service.BoardService;
import com.yedam.spring.board.service.BoardVO;

@Service
public class BoardServiceImpl implements BoardService {
	@Autowired
	BoardMapper boardMapper;
	
	//��ü��ȸ
	@Override
	public List<BoardVO> getBoardList() {
		return boardMapper.selectBoardList();
	}
	
	//�ܰ���ȸ
	@Override
	public BoardVO getBoardInfo(BoardVO boardVO) {
		return boardMapper.selectBoardInfo(boardVO);
	}
	
	//����ϰ��� �ϴ� �� ��ȣ
	@Override
	public BoardVO getBoardNo() {
		return boardMapper.getBoardNo();
	}
	
	//��� - ��ϵ� �� ��ȣ ��ȯ ���н� -1 ��ȯ
	@Override
	public int insertBoardInfo(BoardVO boardVO) {
		int result = boardMapper.insertBoard(boardVO);
		if(result == 1) {
			return Integer.valueOf(boardVO.getBno());
		}else {
			return -1;
		}
	}
	
	//���� - ������ �� ��ȣ ��ȯ ���н� -1 ��ȯ
	@Override
	public int updateBoardInfo(BoardVO boardVO) {
		int result = boardMapper.updateBoard(boardVO);
		if(result == 1) {
			return Integer.valueOf(boardVO.getBno());
		}else {
			return -1;
		}
	}
	
	//���� - ������ �� ��ȣ ��ȯ ���н� -1 ��ȯ
	@Override
	public int deleteBoardInfo(int boardNo) {
		int result = boardMapper.deleteBoard(boardNo);
		if(result == 1) {
			return boardNo;
		}else {
			return -1;
		}
	}

}
