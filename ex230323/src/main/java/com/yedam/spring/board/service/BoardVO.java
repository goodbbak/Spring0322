package com.yedam.spring.board.service;

import java.util.Date; // yyyy//MM//dd

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class BoardVO {
	private int bno;
	private String title;
	private String contents;
	private String writer;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date regdate;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date updatedate;
	private String image;
}
