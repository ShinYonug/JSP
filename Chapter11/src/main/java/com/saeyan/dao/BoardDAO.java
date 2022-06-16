
package com.saeyan.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.saeyan.dto.BoardVO;

import Util.DBManager;

public class BoardDAO {
	private static BoardDAO instance = new BoardDAO();
	private BoardDAO() {}

	public static BoardDAO getInstance() {	return instance;	}

	public List<BoardVO> selectAllBoards(){
		String sql = "select * from board order by num desc";
		
		List<BoardVO> list = new ArrayList<BoardVO>();
		Connection conn  = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				BoardVO bVo = new BoardVO();
				bVo.setNum(rs.getInt("num"));
				bVo.setName(rs.getString("name"));
				bVo.setEmail(rs.getString("email"));
				bVo.setPass(rs.getString("pass"));
				bVo.setTitle(rs.getString("title"));
				bVo.setContent(rs.getString("content"));
				bVo.setReadcount(rs.getInt("readcount"));
				bVo.setWritedate(rs.getTimestamp("writedate"));
				
				list.add(bVo);
			}
		}catch(SQLException e	) {
			e.printStackTrace();
		}finally {
			DBManager.closeConnection(conn, stmt,rs);
		}
		return list;
	}

	
	public void insertBoard(BoardVO bVo) {
		String sql = "insert into board(num, name, email, pass, title, content) " 
				+ " values(board_seq.nextval, ?,?,?,?,?)";
		int justone = 0;
	Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, bVo.getName());
			pstmt.setString(2, bVo.getEmail());
			pstmt.setString(3, bVo.getPass());
			pstmt.setString(4, bVo.getTitle());
			pstmt.setString(5, bVo.getContent());
			pstmt.executeUpdate();
		}catch(SQLException e ) {
			e.printStackTrace();
			
		}finally {
			DBManager.closeConnection(conn, pstmt);
		}
	
	}

	public int updateReadCount(String num) {
		String sql = "update board set readcount = readcount +1 where num=?";
		int result=-1;
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,Integer.parseInt(num));
			result = 1;
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.closeConnection(conn, pstmt);
		}
		return result;
	}

	public BoardVO SelectOneBoardByNum(String num) {
		
		BoardVO vo = new BoardVO();
		
		int result = -1;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from board where num = ?";
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(num));
			rs = pstmt.executeQuery();
			if(rs.next()) {
				vo.setNum(rs.getInt("num"));
				vo.setName(rs.getString("name"));
				vo.setEmail(rs.getString("email"));
				vo.setPass(rs.getString("pass"));
				vo.setTitle(rs.getString("title"));
				vo.setContent(rs.getString("content"));
				vo.setReadcount(rs.getInt("readcount"));
				vo.setWritedate(rs.getTimestamp("writedate"));
			}
		}catch(Exception e) {
			e.printStackTrace();
			
		}finally {
			DBManager.closeConnection(conn, pstmt);
		}
				
		return vo;
	}







}


