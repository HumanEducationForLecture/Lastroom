package dao;

public interface UserDao<T> extends Dao{
	
	T findUserByEmail(String email);
	T findUserByEmailAndPassword(String email , String password);

	// JPA
}
