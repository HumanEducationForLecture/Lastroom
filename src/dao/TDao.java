package dao;

import java.sql.SQLException;

public interface TDao<T> {
	int insert(T dto) throws SQLException;
	int update(T dto);
	int delete(T dto);

}
