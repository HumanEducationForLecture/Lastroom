package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import user.UserDTO;
import utils.DBConnection;

/**
 * for get Object from db
 * @author MIT-00
 */
public class RUserDao implements UserDao<UserDTO>{
	private static final RUserDao instance;
	public static RUserDao getInstance() {
		return instance;
	}
	static {
		instance = new RUserDao();
	}
	@Override
	public UserDTO findUserByEmail(String email) {
		PreparedStatement pstmt = null;
		Connection conn = null;
		ResultSet rs = null;
		UserDTO userDTO = null;
		try {
			String query = "select * from user where email=?";
			conn = DBConnection.getInstance().getConn();
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, email);
			rs = pstmt.executeQuery();
			
			while(rs.next())
				userDTO = new UserDTO(
						rs.getString(rs.getInt("email")),
						"",
						""
						);
			
			return userDTO;
			
		} catch(Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}
	@Override
	public List getList() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public UserDTO findUserByEmailAndPassword(String email, String password) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		Connection conn = null;
		ResultSet rs = null;
		UserDTO userDTO = null;
		try {
			String query = "select * from user where email=? and password = ?";
			conn = DBConnection.getInstance().getConn();
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, email);
			rs = pstmt.executeQuery();
			
			while(rs.next())
				userDTO = new UserDTO(
						rs.getString(rs.getInt("email")),
						rs.getString(rs.getInt("password")),
						""
						);
			
			return userDTO;
			
		} catch(Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}
	
	
	
	
}
