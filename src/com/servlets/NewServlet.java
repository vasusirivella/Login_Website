package com.servlets;

import com.project.code.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
//import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/NewServlet")
public class NewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public NewServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String mail = request.getParameter("gmailid");
		String pass = request.getParameter("password");
		try {
			ResultSet res = Check.show(mail, pass);
			if (res.next()) {
				response.sendRedirect("page.html");
			}
			else {
				PrintWriter out = response.getWriter();
                out.append("<html><body>");
                out.append("<h2>Incorrect username or password. Please try again.</h2>");
                out.append("</body></html>");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
