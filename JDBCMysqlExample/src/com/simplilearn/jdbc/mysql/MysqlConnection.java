package com.simplilearn.jdbc.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MysqlConnection {

	public void performJdbcConnectivity() {
		// JDBC Connectivity

		try {
			// 1. Register Driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			// 2. Get Connection
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "root", "admin123");

			// 3. Create Statement
			Statement statement = con.createStatement();

			// 4. Execute Query
			ResultSet rs = statement.executeQuery("select * from emp");
			while (rs.next()) {
				System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getInt(3));
			}

			// 5. Close Connection
			con.close();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) { // TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
