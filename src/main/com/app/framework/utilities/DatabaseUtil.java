package com.app.framework.utilities;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseUtil {

	private static Connection connection;

	public static Connection openConnection(String url) {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").getDeclaredConstructor().newInstance();
			connection = DriverManager.getConnection(url);
			return connection;
		} catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException |
				 ClassNotFoundException | SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public static void closeConnection() {
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
	}

	public static void executeQuery(String query, Connection connection) {
		PreparedStatement statement;
		try {
			statement = connection.prepareStatement(query);
			ResultSet resultSet = statement.executeQuery();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
