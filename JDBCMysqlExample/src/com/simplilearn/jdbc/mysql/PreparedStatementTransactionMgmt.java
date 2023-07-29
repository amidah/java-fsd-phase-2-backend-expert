package com.simplilearn.jdbc.mysql;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PreparedStatementTransactionMgmt {
	
	public static void main(String[] args) {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "root", "admin123");
			con.setAutoCommit(false);
			
			PreparedStatement ps = con.prepareStatement("insert into emp values(?,?,?)");
			
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			while(true) {
				System.out.println("Enter ID:");
				String s1 = br.readLine();
				int id = Integer.parseInt(s1);
				
				System.out.println("Enter Name:");
				String name = br.readLine();
				
				System.out.println("Enter Age:");
				String s2 = br.readLine();
				int age = Integer.parseInt(s2);
				
				ps.setInt(1,  id);
				ps.setString(2, name);
				ps.setInt(3, age);
				
				ps.executeUpdate();
				
				
				System.out.println("commit/rollback");
				String answer = br.readLine();
				
				if(answer.equals("commit")) {
					con.commit();
				}
				
				if(answer.equals("rollback")) {
					con.rollback();
				}
				
				System.out.println("Want to add more records y/n");
				String ans = br.readLine();
				
				if(ans.equals("n")) {
					break;
				}
				
				
			}
			
			con.commit();
			System.out.println("Records saved successfully");
			con.close();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}

}
