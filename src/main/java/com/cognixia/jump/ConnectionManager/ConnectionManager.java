package com.cognixia.jump.ConnectionManager;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.util.Properties;

public class ConnectionManager {
	private static Connection connection = null;

	private ConnectionManager() {

	};

	private static void makeConnection() {

		Properties props = new Properties();

		try {
			props.load(new FileInputStream("resources/config.properties"));

		} catch (Exception e) {
			e.printStackTrace();
		}

		String url = props.getProperty("url");
		String driver = props.getProperty("driver");
		String username = props.getProperty("username");
		String password = props.getProperty("password");

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			//DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			connection = DriverManager.getConnection(url, username, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnection() {

		if (connection == null) {
			makeConnection();
		}

		return connection;
	}

}
