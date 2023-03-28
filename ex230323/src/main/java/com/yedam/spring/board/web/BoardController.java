package com.yedam.spring.board.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.yedam.spring.board.service.BoardService;
import com.yedam.spring.board.service.BoardVO;

@Controller 
public class BoardController {
	@Autowired
	BoardService boardService;
	
	// ��ü��ȸ
	@GetMapping("/getBoardList")
	public String  getBoardList(Model model) {
		model.addAttribute("boardList", boardService.getBoardList());
		return "board/boardList";
	}
	
	// �ܰ���ȸ
	@GetMapping("/getBoardInfo")
	public String getBoardInfo(BoardVO boardVO, Model model) {
		model.addAttribute("boardInfo", boardService.getBoardInfo(boardVO));
		return "board/boardInfo";
	}
	
	// ��� ������
	@GetMapping("/boardInsert")
	public String boardInsert(Model model) {
		model.addAttribute("boardInfo", boardService.getBoardNo());
		return "board/boardInsert";
	}
	
	// ��� ó��
	@PostMapping("/boardInsert")
	public String boardInsertProcess(BoardVO boardVO) {
		boardService.insertBoardInfo(boardVO);
		return "redirect:getBoardList";
	}
	
	// ���� ������
	@GetMapping("/boardUpdate")
	public String boardUpdate(BoardVO boardVO, Model model) {
		model.addAttribute("boardInfo", boardService.getBoardInfo(boardVO));//boardVO �� bno�ۿ� �� �������
		return "board/boardUpdate";
	}
	
	// ���� ó��
	@PostMapping("/boardUpdate")
	public String boardUpdate(BoardVO boardVO) {
		boardService.updateBoardInfo(boardVO);
		return "redirect:getBoardInfo?bno="+boardVO.getBno();
	}

	// ���� 
	@GetMapping("/boardDelete")
	public String boardDelete(@RequestParam int bno) {//@RequstParam���� �������̶� ��û�� key���̶� ���ƾ� ��
		boardService.deleteBoardInfo(bno);			  //�ܰ��϶� @RequstParam����� �Ķ���͸� �ڵ����� ����
		return "redirect:getBoardList";
	}
}
