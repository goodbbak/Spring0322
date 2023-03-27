package com.yedam.spring.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

public class BoardServiceImpl implements BoardService {
	@Autowired
	BoardService boardService;
	
	//전체조회
	@Override
	public List<BoardVO> getBoardList() {
		return boardService.getBoardList();
	}
	
	//단건조회
	@Override
	public BoardVO getBoardInfo(BoardVO boardVO) {
		return boardService.getBoardInfo(boardVO);
	}
	
	//등록하고자 하는 글 번호
	@Override
	public BoardVO getBoardNo() {
		return boardService.getBoardNo();
	}
	
	//등록 - 등록된 글 번호 반환 실패시 -1 반환
	@Override
	public int insertBoardInfo(BoardVO boardVO) {
		int result = boardService.insertBoardInfo(boardVO);
		if(result > 0) {
			return Integer.valueOf(boardVO.getBno());
		}else {
			return -1;
		}
	}
	
	//수정 - 수정된 글 번호 반환 실패시 -1 반환
	@Override
	public int updateBoardInfo(BoardVO boardVO) {
		int result = boardService.updateBoardInfo(boardVO);
		if(result > 0) {
			return Integer.valueOf(boardVO.getBno());
		}else {
			return -1;
		}
	}
	
	//삭제 - 삭제된 글 번호 반환 실패시 -1 반환
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
