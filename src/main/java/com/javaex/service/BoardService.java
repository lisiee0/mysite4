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
	
	public void read(int no) {
		bd.read(no);
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
		bd.write(vo);
	}

}
