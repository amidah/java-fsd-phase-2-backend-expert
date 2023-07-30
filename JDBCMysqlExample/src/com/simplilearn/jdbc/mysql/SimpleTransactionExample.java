package com.simplilearn.jdbc.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class SimpleTransactionExample {

	public void simpleTxMgmt() {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "root", "admin123");
			con.setAutoCommit(false);
			
			Statement stmt = con.createStatement();
			
			stmt.executeUpdate("insert into emp(id, name, age) values(6, 'Jaz', 28)");
			stmt.executeUpdate("insert into emp(id, name, age) values(7, 'Naz', 38)");
			
			con.commit();
			con.close();
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
