package dao;

import java.sql.SQLException;

public interface Dao<T> {
	int insert(T dto) throws SQLException;
	int update(T dto);
	int delete(T dto);

}
