package com.example.retrieve;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.example.util.JDBCUtil;

public class RetrieveApp {
	
	{
		System.out.println("---------------------------------------");
		System.out.println("You have selected Reterive Operation..!");
		System.out.println("---------------------------------------");
	}

	Connection connection = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;

	public void getAllDetails() {

		String sqlGetAllDetailsQuery = "select id, name, price, catagory, quantity from products;";

		try {
			connection = JDBCUtil.getJdbcConnection();

			if (connection != null) {
				preparedStatement = connection.prepareStatement(sqlGetAllDetailsQuery);
			}

			if (preparedStatement != null) {
				resultSet = preparedStatement.executeQuery();
			}

			if (resultSet != null) {

				System.out.println("Id\tName\tPrice\tCatagory\tQuantity");

				while (resultSet.next()) {

					int id = resultSet.getInt(1);
					String name = resultSet.getString(2);
					int price = resultSet.getInt(3);
					String catagory = resultSet.getString(4);
					int quantity = resultSet.getInt(5);

					System.out.println(id + "\t" + name + "\t" + price + "\t" + catagory + "\t" + quantity);
				}
			}

		} catch (IOException | SQLException e) {
			e.getMessage();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				JDBCUtil.closingResourse(connection, preparedStatement, resultSet);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	public void getDetailsById(int id) {

		String sqlGetDetailsByIdQuery = "select id, name, price, catagory, quantity from products where id = ?;";

		try {
			connection = JDBCUtil.getJdbcConnection();

			if (connection != null) {
				preparedStatement = connection.prepareStatement(sqlGetDetailsByIdQuery);
			}

			if (preparedStatement != null) {
				preparedStatement.setInt(1, id);
				resultSet = preparedStatement.executeQuery();
			}

			if (resultSet != null) {

				if (resultSet.next()) {
					System.out.println("Id\tName\tPrice\tCatagory\tQuantity");
					System.out.println(resultSet.getInt(1) + "\t" + resultSet.getString(2) + "\t" + resultSet.getInt(3)
							+ "\t" + resultSet.getString(4) + "\t" + resultSet.getInt(5));
				} else {
					System.out.println("Product Id is not available :: " + id);
				}

			}

		} catch (IOException | SQLException e) {
			e.getMessage();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				JDBCUtil.closingResourse(connection, preparedStatement, resultSet);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

}
