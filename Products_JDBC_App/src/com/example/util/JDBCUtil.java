package com.example.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBCUtil {

	private JDBCUtil() {
	}

	public static Connection getJdbcConnection() throws IOException, SQLException {

		FileInputStream inputStream = new FileInputStream("src\\application.properties");
		Properties properties = new Properties();
		properties.load(inputStream);

		Connection connection = DriverManager.getConnection(properties.getProperty("url"),
				properties.getProperty("userName"), properties.getProperty("password"));

		return connection;
	}

	public static void closingResourse(Connection connection, Statement statement, ResultSet resultSet)
			throws SQLException {

		if (connection != null) {
			connection.close();
		}

		if (statement != null) {
			statement.close();
		}

		if (resultSet != null) {
			resultSet.close();
		}
	}

//		public static Connection getJdbcConnection() throws SQLException {
//
//		String url = "jdbc:mysql:///javafsdcourse";
//		String useName = "root";
//		String password = "root";
//		Connection connection = DriverManager.getConnection(url, useName, password);
//		return connection;
//	}
}
