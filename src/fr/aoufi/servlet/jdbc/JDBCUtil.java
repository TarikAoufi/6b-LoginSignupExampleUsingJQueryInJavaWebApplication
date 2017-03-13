package fr.aoufi.servlet.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class JDBCUtil {
	
private static Connection connection = null;

public static Connection getConnection() {
	if (connection != null)
		return connection;
	else {
		// database URL
		String dbUrl = "jdbc:mysql://localhost/jquerryjavaweb";
		try 
		{
		Class.forName("com.mysql.jdbc.Driver");
		
		// set the url, username and password for the database
		connection = DriverManager.getConnection(dbUrl, "user1", "pswd");
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return connection;
	}
	}
}