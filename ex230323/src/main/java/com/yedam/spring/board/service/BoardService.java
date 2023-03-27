package com.yedam.spring.board.service;

import java.util.List;

public interface BoardService {
		//��ü��ȸ	
		public List<BoardVO> getBoardList();
		
		//�ܰ���ȸ
		public BoardVO getBoardInfo(BoardVO boardVO);
		
		//����ϰ��� �ϴ� �� ��ȣ
		public BoardVO getBoardNo();
		
		//���
		public int insertBoardInfo(BoardVO boardVO);
		
		//����
		public int updateBoardInfo(BoardVO boardVO);
		
		//����
		public int deleteBoardInfo(int BoardNo);
}
