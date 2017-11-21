package util;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DbConnectorJNDI {

		DataSource ds;
		
		private static DbConnectorJNDI single = null;

		private DbConnectorJNDI() {
			try {
				InitialContext ic = new InitialContext();
				Context ctx = (Context)ic.lookup("java:comp/env");
				ds = (DataSource)ctx.lookup("jdbc/mysql_hr");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		public static DbConnectorJNDI getInstance() {
			if (single == null) {
				single = new DbConnectorJNDI();
			}
			return single;
		}
		
		public Connection getConnection() {
			Connection conn = null;
			try {
				conn = ds.getConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return conn;
		}
		
}
