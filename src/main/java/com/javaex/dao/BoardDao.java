package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.BoardVo;

@Repository
public class BoardDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	// 리스트 불러오기
	public List<BoardVo> getList() {
		return sqlSession.selectList("board.getList");
	}
	
	// 특정 게시글 선택
	public BoardVo getPost(int no) {
		return sqlSession.selectOne("board.getPost", no);
	}
	
	// 조회수 +1
	public void read(int no) {
		sqlSession.update("board.read", no);
	}
	
	// 수정
	public void modify(BoardVo vo) {
		sqlSession.update("board.modify", vo);
	}
	
	// 삭제
	public void delete(int no) {
		sqlSession.delete("board.delete", no);
	}
	
	// 글작성
	public void write(BoardVo vo) {
		sqlSession.insert("board.write", vo);
	}
	
	/*
	
	

	
	// 게시글 작성
	public void write(String title, String content, int userNo) {
		
		getConnection();
	
		try {
			String query= "";
			query += " insert into board ";
			query += " values(seq_board_no.nextval, ?, ?, 0, sysdate, ?) ";
		
		    pstmt= conn.prepareStatement(query);
		    
		    pstmt.setString(1, title); // title
		    pstmt.setString(2, content); // content
		    pstmt.setInt(3, userNo); // userNo
	
		    int count= pstmt.executeUpdate();	    
		    		   	    
		    System.out.println("["+count+"건 등록되었습니다.]");
		        	    
		} catch (SQLException e) {
		    System.out.println("error:" + e);
		} 
		close();
	}
	
	
	*/
}

