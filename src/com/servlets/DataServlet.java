package com.servlets;

import com.project.code.*;

import java.io.IOException;
import java.io.PrintWriter;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DataServlet")
public class DataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DataServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("tbname");
		String num = request.getParameter("tbnum");
		String mail = request.getParameter("tbmail");
		String pass = request.getParameter("tbpass1");
		String pass1 = request.getParameter("tbpass2");
		if(pass.equals(pass1)) {
			Connect.conn(name, num, mail, pass);
			response.sendRedirect("main.html");
		}else {
			PrintWriter out = response.getWriter();
			 out.append("<html><head><title>Alert Example</title></head><body>");
             out.append("<script type=\"text/javascript\">");
             out.append("alert('This is an alert message from the servlet!');");
             out.append("</script>");
             out.append("<a href=\"register.html\"><button>Register</button></a>");
             out.append("</body></html>");
		}
	}

}
