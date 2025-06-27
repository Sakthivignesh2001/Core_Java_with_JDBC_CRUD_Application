package com.example.update;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.example.util.JDBCUtil;

public class UpdationApp {

	{
		System.out.println("---------------------------------------");
		System.out.println("You have selected Update operation..!");
		System.out.println("---------------------------------------");
	}

	public String updationOperationById(int id) {

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		String getDetailById = "select name, price, catagory, quantity from products where id = ?";
		String sqlUpdateQuery = "UPDATE products SET name = ?, price = ? , catagory = ?, quantity = ? WHERE id = ?;";

		String pName = null;
		Integer pPrice = null;
		String pCatagory = null;
		Integer pQuantity = null;
		boolean isProductAvailable = false;

		PreparedStatement preparedStatement2 = null;

		try {
			connection = JDBCUtil.getJdbcConnection();

			if (connection != null) {

				preparedStatement = connection.prepareStatement(getDetailById);
				preparedStatement.setInt(1, id);

				resultSet = preparedStatement.executeQuery();
			}

			if (resultSet != null) {

				if (resultSet.next()) {
					pName = resultSet.getString(1);
					pPrice = resultSet.getInt(2);
					pCatagory = resultSet.getString(3);
					pQuantity = resultSet.getInt(4);
					isProductAvailable = true;
				} else {
					return "Product not Available";
				}

			}

			if (isProductAvailable) {

				preparedStatement2 = connection.prepareStatement(sqlUpdateQuery);

				if (preparedStatement2 != null) {

					Scanner scanner = new Scanner(System.in);

					System.out.print("Enter the updating Product name:: ");
					String updatedName = scanner.next();

					System.out.print("Enter the updating Product Price:: ");
					int updatedPrice = scanner.nextInt();

					System.out.print("Enter the updating Product Catagory:: ");
					String updatedCatagory = scanner.next();

					System.out.print("Enter the updating Product Quantity:: ");
					int updatedQuantity = scanner.nextInt();

					if (updatedName != null) {
						preparedStatement2.setString(1, updatedName);
					} else {
						preparedStatement2.setString(1, pName);
					}

					if (updatedPrice != 0) {
						preparedStatement2.setInt(2, updatedPrice);
					} else {
						preparedStatement2.setInt(2, pPrice);
					}

					if (updatedCatagory != null) {
						preparedStatement2.setString(3, updatedCatagory);
					} else {
						preparedStatement2.setString(3, pCatagory);
					}

					if (updatedQuantity != 0) {
						preparedStatement2.setInt(4, updatedQuantity);
					} else {
						preparedStatement2.setInt(4, pQuantity);
					}

					preparedStatement2.setInt(5, id);

					int rowAffected = preparedStatement2.executeUpdate();

					if (rowAffected == 1) {
						return "success";
					} else {
						return "failed";
					}

				}
			}

		} catch (IOException | SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				JDBCUtil.closingResourse(connection, preparedStatement, resultSet);
				JDBCUtil.closingResourse(null, preparedStatement2, null);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return "failed";

	}

}
