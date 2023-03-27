package com.yedam.spring.board.service;

import java.util.List;

public interface BoardService {
		//��ü��ȸ	
		public List<BoardVO> getBoardList();
		
		//�ܰ���ȸ
		public BoardVO getBoardInfo(BoardVO boardVO);
		
		//����ϰ��� �ϴ� �� ��ȣ
		public BoardVO getBoardNo();
		
		//��� - ��ϵ� �� ��ȣ ��ȯ ���н� -1 ��ȯ
		public int insertBoardInfo(BoardVO boardVO);
		
		//���� - ������ �� ��ȣ ��ȯ ���н� -1 ��ȯ
		public int updateBoardInfo(BoardVO boardVO);
		
		//���� - ������ �� ��ȣ ��ȯ ���н� -1 ��ȯ
		public int deleteBoardInfo(int BoardNo);
}
