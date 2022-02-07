package com.javaex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.BoardDao;
import com.javaex.vo.BoardVo;
import com.javaex.vo.UserVo;

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
	
	
	// 리스트 & 페이징
	public List<BoardVo> list2(int crtPage) {
		System.out.println("list2");
		
		// 리스트 가져오기
		
		// 페이지당 글 개수
		int listCnt= 10;
		
		// 시작글 번호
		int startRnum= (crtPage-1)*listCnt +1;
		
		// 끝글 번호
		int endRnum= (startRnum+listCnt) -1;
		
		return bd.getList2(startRnum, endRnum);
	}
}
