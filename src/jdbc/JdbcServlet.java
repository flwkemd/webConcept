package jdbc;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.DbConnector;
import util.DbConnectorJNDI;

@WebServlet("/jdbc.do")
public class JdbcServlet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			//DbConnector connector = DbConnector.getInstance();
			DbConnectorJNDI connector = DbConnectorJNDI.getInstance();
			
			Connection conn = connector.getConnection();
		
			String url = "jdbc:mysql://localhost:3307/hr";
			//String url = "jdbc:oracle:thin@localhost:1521:xe;
			String user = "root";
			String pwd = "root";
		
			conn = DriverManager.getConnection(url,user,pwd);
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
				
			}
			
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
	}

}
