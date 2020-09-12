package com.connection.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MyClass {

	private Connection con;

	public MyClass() {
		String url = "jdbc:mysql://192.168.1.111:3306/testdb";
		String username = "root";
		String password = "toor";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url, username, password);
			System.out.println("Connected!!!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e);
		} catch (ClassNotFoundException e) {
			System.out.println(e);
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		MyClass mc = new MyClass();
		mc.getData();

	}

	public void getData() {
		try {
			System.out.println("fetch 1");
			String sql = "SELECT firstname, lastname FROM MyGuests;";
			System.out.println("fetch 2");
			Statement st = con.createStatement();
			System.out.println("fetch 3");
			ResultSet rs = st.executeQuery(sql);
			System.out.println("fetch 4");
			while (rs.next()) {
				System.out.println(rs.getString("firstname"));
				System.out.println(rs.getString("lastname"));
			}

		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
