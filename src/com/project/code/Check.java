
package com.project.code;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Check {
	private static Connection cn = null;
	private static PreparedStatement ps = null;

	public static ResultSet show(String name, String pass) throws SQLException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/UniDB", "root", "manager");
			String qry = "select * from store where mail=? and pass=?";
			ps = cn.prepareStatement(qry);
			ps.setString(1, name);
			ps.setString(2, pass);			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return ps.executeQuery();
	}
}
