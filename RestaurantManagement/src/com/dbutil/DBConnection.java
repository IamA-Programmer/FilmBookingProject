package com.dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	private static Connection con;
	
	public DBConnection() {
		
	}
	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/restaurant_management","root","root");
		}
		catch(ClassNotFoundException c) {
			c.printStackTrace();
		}
		catch(SQLException sql) {
			sql.printStackTrace();
		}
		return con;
	}
	
}
