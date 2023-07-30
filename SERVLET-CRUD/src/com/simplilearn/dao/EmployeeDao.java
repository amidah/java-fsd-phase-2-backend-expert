package com.simplilearn.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import com.mysql.cj.protocol.Resultset;
import com.simplilearn.model.Employee;

public class EmployeeDao {

	public static Connection getConnection() {
		Connection con = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "root", "admin123");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return con;

	}

	public static int save(Employee e) {
		int status = 0;

		try {
			Connection con = EmployeeDao.getConnection();
			PreparedStatement ps = con.prepareStatement("insert into Employee values(?,?,?,?,?)");

			ps.setInt(1, new Random().nextInt(50));
			ps.setString(2, e.getName());
			ps.setString(3, e.getPassword());
			ps.setString(4, e.getEmail());
			ps.setString(5, e.getCountry());

			status = ps.executeUpdate();

			con.close();

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return status;
	}

	public static List<Employee> getAllEmployees() {
		List<Employee> empList = new ArrayList<>();

		try {
			Connection con = EmployeeDao.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from Employee");

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Employee e = new Employee();
				e.setName(rs.getString(2));
				e.setPassword(rs.getString(3));
				e.setEmail(rs.getString(4));
				e.setCountry(rs.getString(5));

				empList.add(e);
			}
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return empList;
	}

}
