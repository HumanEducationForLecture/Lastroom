package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import user.PostDTO;
import utils.DBConnection;

public class PostDao implements TDao<PostDTO>{

	@Override
	public int insert(PostDTO dto) throws SQLException {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null ;
		Connection conn = null;
		int writeNo = 0 ;
		try {
			String query = "insert into post (indexNum,email,nickname,content) values(mvc_board_seq.nextval,?,?,?)";
			conn = DBConnection.getInstance().getConn();
			pstmt=conn.prepareStatement(query);
			pstmt.setString(1, dto.getEmail());
			pstmt.setString(2, dto.getNickName());
			pstmt.setString(3, dto.getContent());
			
			conn.commit();
			return writeNo;
			
		} catch(Exception ex) {
			try {
				conn.rollback();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			ex.printStackTrace();
		} finally {
			try {
				pstmt.close();
				
			} catch(Exception ex ){
				ex.printStackTrace();
			}
		}
		return 0;	
	}

	@Override
	public int update(PostDTO dto) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null ;
		Connection conn = null;
		int updateNo = 0 ;
		try {
			String query = "update post set nickName=?,content=? where email?";
			conn = DBConnection.getInstance().getConn();
			pstmt=conn.prepareStatement(query);
			pstmt.setString(1, dto.getNickName());
			pstmt.setString(2, dto.getContent());
			pstmt.setString(3, dto.getEmail());
			
			conn.commit();
			return updateNo;
			
		} catch(Exception ex) {
			try {
				conn.rollback();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			ex.printStackTrace();
		} finally {
			try {
				pstmt.close();
				
			} catch(Exception ex ){
				ex.printStackTrace();
			}
		}
		return 0;
	}

	@Override
	public int delete(PostDTO dto) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null ;
		Connection conn = null;
		int deleteNo = 0 ;
		try {
			String query = "delete post where email=?";
			conn = DBConnection.getInstance().getConn();
			pstmt=conn.prepareStatement(query);
			pstmt.setString(1, dto.getEmail());
			
			conn.commit();
			return deleteNo;
			
		} catch(Exception ex) {
			try {
				conn.rollback();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			ex.printStackTrace();
		} finally {
			try {
				pstmt.close();
				
			} catch(Exception ex ){
				ex.printStackTrace();
			}
		}
		return 0;	
	}
	
}
