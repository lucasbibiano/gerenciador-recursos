package dal.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
	private static Connection connection = null;
	
	private ConnectionManager() {}
	
	public static synchronized Connection getConnection() throws ClassNotFoundException,
			SQLException {
		if (connection == null) {	
			// Load the JDBC driver
			String driverName = "com.mysql.jdbc.Driver";
			Class.forName(driverName);
	
			// Create a connection to the database
			String serverName = "localhost";
			String mydatabase = "mydatabase";
			String url = "jdbc:mysql://" + serverName + "/" + mydatabase; 
			
			String username = "username";
			String password = "password";
			connection = DriverManager.getConnection(url, username, password);
		}
		
		return connection;
	}
}
