package com.example.insert;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.example.util.JDBCUtil;

public class InsertionApp {

	{
		System.out.println("-----------------------------------------");
		System.out.println("You have selected Insertion Operation..!");
		System.out.println("-----------------------------------------");
	}

	public String insetionOperation(String productName, int productPrice, String productCatagory, int productQuantity) {

		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String sqlInsertQuery = "insert into products(name, price, catagory, quantity) values(?, ?, ?, ?);";

		try {

			connection = JDBCUtil.getJdbcConnection();

			if (connection != null) {
				preparedStatement = connection.prepareStatement(sqlInsertQuery);
			}

			if (preparedStatement != null) {

				preparedStatement.setString(1, productName);
				preparedStatement.setInt(2, productPrice);
				preparedStatement.setString(3, productCatagory);
				preparedStatement.setInt(4, productQuantity);

				int rowAffected = preparedStatement.executeUpdate();

				if (rowAffected == 1) {
					return "Success";
				}

			}

		} catch (IOException | SQLException e) {
			e.getMessage();
		} catch (Exception e) {
			e.getStackTrace();
		} finally {
			try {
				JDBCUtil.closingResourse(connection, preparedStatement, null);
			} catch (SQLException e) {
				e.getMessage();
			}
		}

		return "Failed";
	}

}
