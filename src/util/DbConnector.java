package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnector {
	
	private static DbConnector single = null;

	private DbConnector() {
	}

	public static DbConnector getInstance() {
		if (single == null) {
			single = new DbConnector();
		}
		return single;
	}
	
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			//Class.forName("com.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Connection getConnection() {
		Connection conn = null;
		
		String url = "jdbc:mysql://localhost:3307/hr";
		//String url = "jdbc:oracle:thin@localhost:1521:xe;
		String user = "root";
		String pwd = "root";
		
		try {
			conn = DriverManager.getConnection(url,user,pwd);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return conn;
		
	}
}
