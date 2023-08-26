package com.simplilearn.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.simplilearn.bean.User;

public class UserDao {

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

	public static int save(User u) throws SQLException {
		int status = 0;
		Connection conn = getConnection();
		PreparedStatement ps = conn
				.prepareStatement("insert into user(name, password, email, gender, country) values(?,?,?,?,?)");
		ps.setString(1, u.getName());
		ps.setString(2, u.getPassword());
		ps.setString(3, u.getEmail());
		ps.setString(4, u.getGender());
		ps.setString(5, u.getCountry());
		status = ps.executeUpdate();

		return status;
	}

	public static List<User> getAllUsers() throws SQLException {

		List<User> userList = new ArrayList<>();
		Connection conn = getConnection();
		PreparedStatement ps = conn.prepareStatement("select * from user");
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			User u = new User();
			u.setId(rs.getInt("id"));
			u.setName(rs.getString("name"));
			u.setPassword(rs.getString("password"));
			u.setEmail(rs.getString("email"));
			u.setGender(rs.getString("gender"));
			u.setCountry(rs.getString("country"));
			userList.add(u);
		}

		return userList;

	}

}
