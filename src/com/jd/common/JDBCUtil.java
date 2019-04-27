package com.jd.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCUtil {

	public static Connection getConnection() {
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/jd?useSSL=false&serverTimezone=UTC&characterEncoding=utf-8";
			String user = "root";
			String password = "mx123123";
			con = DriverManager.getConnection(url, user, password);

		} catch (ClassNotFoundException e) {
			System.out.println("’“≤ªµΩclass");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
	
	public static void clear(Connection con,PreparedStatement ps,ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (ps != null) {
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		if (con != null) {
			try {
				con.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
	}
	
	
	public static void main(String[] args) {
		
	}

}
