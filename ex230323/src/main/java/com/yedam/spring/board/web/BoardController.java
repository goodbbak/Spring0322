package com.yedam.spring.board.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yedam.spring.board.service.BoardService;
import com.yedam.spring.board.service.BoardVO;

@CrossOrigin
@RestController // @Controller + @ResponseBody => 해당 클래스 내의 모든 컨트롤러는 객체를 반환
public class BoardController {
	@Autowired
	BoardService boardService;
	
	// 전체조회
	@GetMapping("/board")
	public List<BoardVO> getBoardList(){
		return '';
	}
	// 단건조회
	@GetMapping("/board")
	public 
	// 등록하고자 하는 글 번호

	// 등록 - 등록된 글 번호 반환 실패시 -1 반환

	// 수정 - 수정된 글 번호 반환 실패시 -1 반환

	// 삭제 - 삭제된 글 번호 반환 실패시 -1 반환
}
