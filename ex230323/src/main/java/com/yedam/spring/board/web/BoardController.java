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
	
	// 전체조회
	@GetMapping("/getBoardList")
	public String  getBoardList(Model model) {
		model.addAttribute("boardList", boardService.getBoardList());
		return "board/boardList";
	}
	
	// 단건조회
	@GetMapping("/getBoardInfo")
	public String getBoardInfo(BoardVO boardVO, Model model) {
		model.addAttribute("boardInfo", boardService.getBoardInfo(boardVO));
		return "board/boardInfo";
	}
	
	// 등록 페이지
	@GetMapping("/boardInsert")
	public String boardInsert(Model model) {
		model.addAttribute("boardInfo", boardService.getBoardNo());
		return "board/boardInsert";
	}
	
	// 등록 처리
	@PostMapping("/boardInsert")
	public String boardInsertProcess(BoardVO boardVO) {
		boardService.insertBoardInfo(boardVO);
		return "redirect:getBoardList";
	}
	
	// 수정 페이지
	@GetMapping("/boardUpdate")
	public String boardUpdate(BoardVO boardVO, Model model) {
		model.addAttribute("boardInfo", boardService.getBoardInfo(boardVO));//boardVO 에 bno밖에 안 들어있음
		return "board/boardUpdate";
	}
	
	// 수정 처리
	@PostMapping("/boardUpdate")
	public String boardUpdate(BoardVO boardVO) {
		boardService.updateBoardInfo(boardVO);
		return "redirect:getBoardInfo?bno="+boardVO.getBno();
	}

	// 삭제 
	@GetMapping("/boardDelete")
	public String boardDelete(@RequestParam int bno) {//@RequstParam쓰면 변수명이랑 요청한 key값이랑 같아야 됨
		boardService.deleteBoardInfo(bno);			  //단건일땐 @RequstParam써줘야 파라미터를 자동으로 매핑
		return "redirect:getBoardList";
	}
}
