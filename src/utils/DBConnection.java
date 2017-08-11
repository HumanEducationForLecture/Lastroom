package utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	static final String DB_URL = "jdbc:mysql://localhost:3306/lastroom";
	

	// UERNAME and PASSWORD value change to ur develoment environment 
	static final String USERNAME = "root";
	static final String PASSWORD = "apmsetup";
	
	
	
	private static DBConnection instance;
	static {
		instance = new DBConnection();
	}
	public static DBConnection getInstance(){
		return instance;
	}
	Connection conn = null;
	public Connection getConn(){
		try {
			conn.setAutoCommit(false);
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		
		return this.conn;
	}
	private DBConnection(){
		try{
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL,USERNAME,PASSWORD);
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
	}
}