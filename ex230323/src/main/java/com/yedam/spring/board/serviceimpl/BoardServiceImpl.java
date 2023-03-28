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
	
	//전체조회
	@Override
	public List<BoardVO> getBoardList() {
		return boardMapper.selectBoardList();
	}
	
	//단건조회
	@Override
	public BoardVO getBoardInfo(BoardVO boardVO) {
		return boardMapper.selectBoardInfo(boardVO);
	}
	
	//등록하고자 하는 글 번호
	@Override
	public BoardVO getBoardNo() {
		return boardMapper.getBoardNo();
	}
	
	//등록 - 등록된 글 번호 반환 실패시 -1 반환
	@Override
	public int insertBoardInfo(BoardVO boardVO) {
		int result = boardMapper.insertBoard(boardVO);
		if(result == 1) {
			return Integer.valueOf(boardVO.getBno());
		}else {
			return -1;
		}
	}
	
	//수정 - 수정된 글 번호 반환 실패시 -1 반환
	@Override
	public int updateBoardInfo(BoardVO boardVO) {
		int result = boardMapper.updateBoard(boardVO);
		if(result == 1) {
			return Integer.valueOf(boardVO.getBno());
		}else {
			return -1;
		}
	}
	
	//삭제 - 삭제된 글 번호 반환 실패시 -1 반환
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
