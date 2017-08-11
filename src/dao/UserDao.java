package dao;

import java.util.List;

import user.UserDTO;

/**
 * for get Object from db
 * @author MIT-00
 */
public class UserDao implements Dao<UserDTO>{
	private static final UserDao instance;
	public static UserDao getInstance() {
		return instance;
	}
	static {
		instance = new UserDao();
	}
	@Override
	public List<UserDTO> getList() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
