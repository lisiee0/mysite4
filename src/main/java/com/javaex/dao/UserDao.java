package com.javaex.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.UserVo;

@Repository
public class UserDao {
	
	@Autowired
	private SqlSession sqlSession;
	

	// 특정유저 정보 가져오기
	public UserVo getUser(UserVo vo) {
		System.out.println("UserDao.getUser()");
		
		return sqlSession.selectOne("user.selectOne", vo);	
	}
	
	
	
	/*
	// 회원가입
	public void userInsert(UserVo vo) {

		getConnection();

		try {
			String query= "";
			query += " insert into users ";
			query += " values(seq_users_no.nextval, ?, ?, ?, ?) ";

			pstmt= conn.prepareStatement(query);

			pstmt.setString(1, vo.getId()); // id
			pstmt.setString(2, vo.getPassword()); // password
			pstmt.setString(3, vo.getName()); // name
			pstmt.setString(4, vo.getGender()); // gender


			int count= pstmt.executeUpdate();	    

			System.out.println("["+count+"건 등록되었습니다.]");

		} catch (SQLException e) {
			System.out.println("error:" + e);
		} 
		close();
	}

	public UserVo getUser(String uid, String pw) {
		UserVo vo= null;

		getConnection();

		try {
			String query= "";
			query += " select   no, "; 
			query += "          id, ";
			query += "          password, ";
			query += "          name, ";
			query += "          gender ";
			query += " from     users ";
			query += " where    id= ? ";
			query += " and      password= ? ";

			pstmt= conn.prepareStatement(query);

			pstmt.setString(1, uid);
			pstmt.setString(2, pw);

			rs= pstmt.executeQuery();

			while(rs.next()) {           
				int no= rs.getInt("no"); 
				String id= rs.getString("id");
				String password= rs.getString("password");
				String name= rs.getString("name");
				String gender= rs.getString("gender");

				vo= new UserVo(no, id, password, name, gender);
			}

		} catch (SQLException e) {
			System.out.println("error:" + e);
		}	
		close();

		return vo;
	}

	// 회원정보수정
	public void userUpdate(UserVo vo) {

		getConnection();

		try {
			String query= "";
			query += " update	users ";
			query += " set		password= ?, ";
			query += " 			name= ?, ";
			query += " 			gender= ? ";
			query += " where	no= ? ";

			pstmt= conn.prepareStatement(query);

			pstmt.setString(1, vo.getPassword());
			pstmt.setString(2, vo.getName());
			pstmt.setString(3, vo.getGender());
			pstmt.setInt(4, vo.getNo());

			int count= pstmt.executeUpdate();

			System.out.println("["+count+"건 수정되었습니다.]");

		} catch (SQLException e) {
			System.out.println("error:" + e);
		} 
		close();
	}
	*/
}
