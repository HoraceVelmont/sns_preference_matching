package com.cafe24.sns;

import org.junit.Test;

import java.sql.*;

import static org.junit.Assert.assertNotNull;

public class DBConnectionTest {
	String jdbcDriver = "com.mysql.jdbc.Driver";
	String dbAddress = "jdbc:mysql://localhost:3306/";
	String dbName = "sns";
	String userName = "root";
	String password = "autoset";

	@Test
	public void testCon(){
		PreparedStatement statement;
		ResultSet result;
		Connection con = null;
		try {
			Class.forName(jdbcDriver);
			con = DriverManager.getConnection(dbAddress + dbName, userName, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		assertNotNull(con);
	}
}
