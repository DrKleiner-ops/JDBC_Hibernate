package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {

	private static Connection connection;

	public Util() {
		try {
			connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/test", "Test", "123");
		} catch (SQLException ignored) {
		}
	}

	public static Connection getConnection() {
		return connection;
	}
}
