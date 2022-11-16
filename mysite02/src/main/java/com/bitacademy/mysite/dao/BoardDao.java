package com.bitacademy.mysite.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bitacademy.mysite.vo.BoardVo;
import com.bitacademy.mysite.vo.UserVo;

public class BoardDao {
	
	public BoardVo findByNo(Long no) {
		BoardVo result = null;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			
			String sql = " select a.no,"
					+ "   	      a.title,"
					+ "           a.hit,"
					+ "           date_format(a.reg_date, '%Y/%m/%d %H:%i:%s'),"
					+ "	          a.depth,"
					+ "		      a.User_no"
					+ "      from board a, user b"
					+ "     where a.user_no = b.no"
					+ "  order by group_no desc, order_no asc";
			pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1, no);

			rs = pstmt.executeQuery();
			if(rs.next()) {
				String title = rs.getString(1);
				String contents = rs.getString(2);
				Long hit = rs.getLong(3);
				String regDate = rs.getString(4);
				Long groupNo = rs.getLong(5);
				Long orderNo = rs.getLong(6);
				Long depth = rs.getLong(7);
				Long userNo = rs.getLong(8);
				
				result = new BoardVo();
				result.setTitle(title);
				result.setContents(contents);
				result.setHit(hit);
				result.setRegDate(regDate);
				result.setGroupNo(groupNo);
				result.setOrderNo(orderNo);
				result.setDepth(depth);
				result.setUserNo(userNo);
			}
			
		} catch (SQLException e) {
			System.out.println("Error:" + e);
		} finally {
			try {
				if(pstmt != null) {
					pstmt.close();
				}
				
				if(conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}		
		
		return result;
	}
	
	public Boolean insert(BoardVo vo) {
		boolean result = false;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = getConnection();
			
			String sql = "insert into board values (null, ?, ?, ?, now(), ?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getContents());
			pstmt.setLong(3, vo.getHit());
			pstmt.setString(4, vo.getRegDate());
			pstmt.setLong(5, vo.getGroupNo());
			pstmt.setLong(6, vo.getOrderNo());
			pstmt.setLong(7, vo.getDepth());
			pstmt.setLong(8, vo.getUserNo());
			
			int count = pstmt.executeUpdate();
			
			//5. 결과 처리
			result = count == 1;
			
		} catch (SQLException e) {
			System.out.println("Error:" + e);
		} finally {
			try {
				if(pstmt != null) {
					pstmt.close();
				}
				
				if(conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}
	
	private Connection getConnection() throws SQLException {
		Connection conn = null;

		try {
			Class.forName("org.mariadb.jdbc.Driver");

			String url = "jdbc:mysql://127.0.0.1:3306/webdb?charset=utf8";
			conn = DriverManager.getConnection(url, "webdb", "webdb");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패:" + e);
		}

		return conn;
	}
	
//	public boolean update(BoardVo vo) {
//		boolean result = false;
//		
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//		
//		try {
//			conn = getConnection();
//			
//			if("".equals(vo.getPassword())) {
//				String sql = "update user set name=?, gender=? where no=?";
//				pstmt = conn.prepareStatement(sql);
//			
//				pstmt.setString(1, vo.getName());
//				pstmt.setString(2, vo.getGender());
//				pstmt.setLong(3, vo.getNo());
//			} else {
//				String sql = "update user set name=?, password=?, gender=? where no=?";
//				pstmt = conn.prepareStatement(sql);
//			
//				pstmt.setString(1, vo.getName());
//				pstmt.setString(2, vo.getPassword());
//				pstmt.setString(3, vo.getGender());
//				pstmt.setLong(4, vo.getNo());
//			}
//			
//			int count = pstmt.executeUpdate();
//			
//			//5. 결과 처리
//			result = count == 1;
//			
//		} catch (SQLException e) {
//			System.out.println("Error:" + e);
//		} finally {
//			try {
//				if(pstmt != null) {
//					pstmt.close();
//				}
//				
//				if(conn != null) {
//					conn.close();
//				}
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}
//		
//		return result;		
//	}

}
