
package com.saeyan.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.saeyan.dto.MovieVO;
import com.sun.net.httpserver.Authenticator.Result;

import Util.DBManager;

public class MovieDAO {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	

	private MovieDAO() {}
	
	private static MovieDAO instance= new MovieDAO();
	public static MovieDAO getInstance() {
		return instance;
	}
	public List<MovieVO> SellectAllMovies() {
		List<MovieVO> list = new ArrayList<MovieVO>();
		String sql = "select * from movie order by code desc";
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
			
				MovieVO vo = new MovieVO();
				vo.setCode(rs.getInt(1));
				vo.setTitle(rs.getString(2));
				vo.setPrice(rs.getInt(3));
				vo.setDirector(rs.getString(4));
				vo.setActor(rs.getString(5));
				vo.setPoster(rs.getString(6));
				vo.setSynopsis(rs.getString(7));
				list.add(vo);
			
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.closeConnection(conn, pstmt, rs);
		}
		
		
		return list;
		
	}
	public int inserMovie(MovieVO vo) {
		int result= -1;
		String sql = "insert into movie values(movie_seq.nextval ,?,?,?,?,?,?)";
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getTitle());
			pstmt.setInt(2, vo.getPrice());
			pstmt.setString(3, vo.getDirector());
			pstmt.setString(4, vo.getActor());
			pstmt.setString(5, vo.getPoster());
			pstmt.setString(6, vo.getSynopsis());
			result = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.closeConnection(conn, pstmt);
		}
		return result;
	}
	public MovieVO SelectByCode(String code) {
		MovieVO vo = null;
		String sql = " select * from movie where code = ?";
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, code);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				vo = new MovieVO();
				vo.setCode(rs.getInt(1));
				vo.setTitle(rs.getString(2));
				vo.setPrice(rs.getInt(3));
				vo.setDirector(rs.getString(4));
				vo.setActor(rs.getString(5));
				vo.setPoster(rs.getString(6));
				vo.setSynopsis(rs.getString(7));
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.closeConnection(conn, pstmt, rs);
		}
		return vo;
	}
	public int UpdateMovie(MovieVO vo) {
		int result = -1;
	    String sql = "update movie set  title=?, price=?, director=?, actor=?, poster=?, synopsis=? where code=?  ";
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getTitle());
			pstmt.setInt(2, vo.getPrice());
			pstmt.setString(3, vo.getDirector());
			pstmt.setString(4, vo.getActor());
			pstmt.setString(5, vo.getPoster());
			pstmt.setString(6, vo.getSynopsis());
			pstmt.setInt(7, vo.getCode());
			result = pstmt.executeUpdate();             //rs를 쓰는 경우 >> select 돌려서 while 문으로 돌리고 돌려 입력 하는 경우
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.closeConnection(conn, pstmt);
		}
		return result;
	}
	public MovieVO DeleteMovie(String code) {
		String sql = " delete movie where code=?";
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, code);
			pstmt.executeUpdate();
				
		
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.closeConnection(conn, pstmt);
		}
		
		
		return null;
	}

	
}
