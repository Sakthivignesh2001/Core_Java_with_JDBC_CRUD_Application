package com.example.delete;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.example.util.JDBCUtil;

public class DeletionApp {

	{
		System.out.println("---------------------------------------");
		System.out.println("You have selected Delete operation..!");
		System.out.println("---------------------------------------");
	}

	public String deleteByIdOperation(int id) {

		Connection connection = null;

		PreparedStatement preparedStatement = null;

		try {
			connection = JDBCUtil.getJdbcConnection();

			String sqlDeleteQuery = "delete from products where id = ?;";

			if (connection != null) {
				preparedStatement = connection.prepareStatement(sqlDeleteQuery);

				preparedStatement.setInt(1, id);

				int rowAffected = preparedStatement.executeUpdate();

				if (rowAffected == 1) {
					return "success";
				} else {
					return "failure";
				}
			}

		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}

		return "failure";
	}

}
