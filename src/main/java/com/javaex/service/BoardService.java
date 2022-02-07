package com.javaex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.BoardDao;
import com.javaex.vo.BoardVo;

@Service
public class BoardService {
	
	@Autowired
	private BoardDao bd;
	
	public List<BoardVo> list() {
		return bd.getList();
	}
	
	public BoardVo read(int no) {
		bd.getPost(no); // 특정글 선택
		bd.read(no); // 조회수 +1
		return bd.getPost(no);
	}
	
	public BoardVo post(int no) {
		return bd.getPost(no);
	}
	
	public void modify(BoardVo vo) {
		bd.modify(vo);
	}
	
	public void delete(int no) {
		bd.delete(no);
	}
	
	public void write(BoardVo vo) {
		
		/*
		// 페이징 데이터 추가
		for(int i= 1; i<=123; i++) {
			vo.setTitle(i+"번째 글제목입니다.");
			vo.setContent(i+"번째 글내용입니다.");
			
			bd.write(vo);
		}
		*/
		
		bd.write(vo);
	}
}
