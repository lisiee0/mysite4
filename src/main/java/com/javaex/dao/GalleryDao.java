package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.GalleryVo;

@Repository
public class GalleryDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	
	// 리스트 불러오기
	public List<GalleryVo> getList() {
		return sqlSession.selectList("gallery.getList");
	}
	
	
	// 업로드
	public void upload(GalleryVo vo) {
		sqlSession.insert("gallery.upload", vo);
	}
}
