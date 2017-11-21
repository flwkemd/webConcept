package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcTest {
	public static void main(String[] args) throws SQLException {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			//Class.forName("com.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String url = "jdbc:mysql://localhost:3307/hr";
		//String url = "jdbc:oracle:thin@localhost:1521:xe;
		String user = "root";
		String pwd = "root";
		
		Connection conn = DriverManager.getConnection(url,user,pwd);
		if(conn != null) {
			System.out.println("연결 성공");
		}else {
			System.out.println("연결 실패");
		}
		
		Statement stmt = conn.createStatement();
		
		String sql = "select * from employees";
		
		ResultSet rs = stmt.executeQuery(sql);
		
		while(rs.next()) {
			int employee_id = rs.getInt("employee_id");
			String first_name = rs.getString("first_name");
			int salary = rs.getInt("salary");
			
			System.out.println(employee_id+" "+first_name+" "+salary);
		}
		
		rs.close();
		stmt.close();
		conn.close();
		
	}
}
