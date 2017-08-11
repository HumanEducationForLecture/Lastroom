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
public class UserDao implements Dao<UserDTO>{
	
	
	
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
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(UserDTO dto) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
}
