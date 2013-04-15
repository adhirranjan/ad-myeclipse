package com.myeclipseide.ws.dalc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbContext {
	public static Connection getConnection() throws ClassNotFoundException,
			SQLException {
		/* for type 4 drivers */

		String user = "root";
		String pass = "root";
		String url = "jdbc:mysql://localhost:3306/test";
		String conn = "com.mysql.jdbc.Driver";
		Class.forName(conn);
		Connection con = DriverManager.getConnection(url, user, pass);

		/* end of connection */

		return con;
	}
}
