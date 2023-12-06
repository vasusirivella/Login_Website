<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<style>
body {
	display: flex;
	justify-content: center;
	align-items: center;
	height: 100vh;
	margin: 0;
}

.form {
	font-style: oblique;
	background-color: bisque;
	border: 5px double black;
	height: 15cm;
	width: 10cm;
	color: black;
}

img {
	padding-top: 1cm;
	height: 3cm;
	width: 3cm;
}

form {
	text-align: center;
}
</style>
<body>
	<h2>User Registration</h2>

    <form action="register" method="post">
        <label for="username">Username:</label>
        <input type="text" id="username" name="username" required><br>

        <label for="password">Password:</label>
        <input type="password" id="password" name="password" required><br>

        <label for="rePassword">Re-enter Password:</label>
        <input type="password" id="rePassword" name="rePassword" required>
        
        <%
            // Retrieve parameters from the request
            String password = request.getParameter("password");
            String rePassword = request.getParameter("rePassword");

            // Check if passwords match
            boolean passwordsMatch = password != null && password.equals(rePassword);

            // If passwords don't match, show an error message
            if (!passwordsMatch) {
        %>
            <div style="color: red;">Password and Re-entered Password do not match!</div>
        <%
            }
        %>

        <br>

        <input type="submit" value="Register">
    </form>
</body>
</html>