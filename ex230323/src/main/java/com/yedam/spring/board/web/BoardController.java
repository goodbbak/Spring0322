package com.yedam.spring.board.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yedam.spring.board.service.BoardService;
import com.yedam.spring.board.service.BoardVO;

@CrossOrigin
@RestController // @Controller + @ResponseBody => �ش� Ŭ���� ���� ��� ��Ʈ�ѷ��� ��ü�� ��ȯ
public class BoardController {
	@Autowired
	BoardService boardService;
	
	// ��ü��ȸ
	@GetMapping("/board")
	public List<BoardVO> getBoardList(){
		return '';
	}
	// �ܰ���ȸ
	@GetMapping("/board")
	public 
	// ����ϰ��� �ϴ� �� ��ȣ

	// ��� - ��ϵ� �� ��ȣ ��ȯ ���н� -1 ��ȯ

	// ���� - ������ �� ��ȣ ��ȯ ���н� -1 ��ȯ

	// ���� - ������ �� ��ȣ ��ȯ ���н� -1 ��ȯ
}
