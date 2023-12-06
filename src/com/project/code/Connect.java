package com.project.code;

//import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
//import java.sql.ResultSet;
import java.sql.SQLException;
//import java.sql.Statement;

public class Connect {

	private static Connection cn = null;
	private static PreparedStatement ps = null;
//	private static Statement stm = null;
//	private static ResultSet res = null;

	public static void conn(String name, String num, String mail, String pass) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/UniDB", "root", "manager");
			String qry = "insert into store values (?,?,?,?)";
			ps = cn.prepareStatement(qry);
			ps.setString(1, name);
			ps.setString(2, num);
			ps.setString(3, mail);
			ps.setString(4, pass);
			ps.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();

		}
	}
}
