package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import user.UserDTO;
import utils.DBConnection;

/**
 * create table user(email varchar(100) primary key , password varchar(100) not null , nickname varchar(100) unique not null);
 * @author kwongiho
 *
 */
public class TUserDao implements TDao<UserDTO>{
	
	@SuppressWarnings("finally")
	@Override
	public int insert(UserDTO dto)  throws SQLException{
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		Connection conn = null;
		int isSuccuess=0;
		try {
			String query = "insert into user(email,password,nickname) values(?,?,?);";
			conn = DBConnection.getInstance().getConn();
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, dto.getEmail());
			pstmt.setString(2, dto.getPassword());
			pstmt.setString(3, dto.getNickName());
			isSuccuess = pstmt.executeUpdate();
		} catch(Exception exception) {
			exception.printStackTrace();
			conn.rollback();
		} finally {
			conn.commit();
			conn.close();
			return isSuccuess;
		}
	}

	@Override
	public int update(UserDTO dto) {
		PreparedStatement pstmt = null ;
		Connection conn = null;
		int updatedNo = 0 ;
		try {
			String query = "update user set nickname=? where email=? and password=?";
			conn = DBConnection.getInstance().getConn();
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, dto.getNickName());
			pstmt.setString(2, dto.getEmail());
			pstmt.setString(3, dto.getPassword());
			updatedNo = pstmt.executeUpdate();
			
			conn.commit();
			return updatedNo;
			
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
	public int delete(UserDTO dto) {
		PreparedStatement pstmt = null ;
		Connection conn = null;
		int deletedNo = 0 ;
		try {
			String query = "delete from user where email=? and password=?";
			conn = DBConnection.getInstance().getConn();
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, dto.getEmail());
			pstmt.setString(2, dto.getPassword());
			deletedNo = pstmt.executeUpdate();
			
			conn.commit();
			return deletedNo;
			
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
