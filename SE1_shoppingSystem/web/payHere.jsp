<%-- 
    Document   : payHere
    Created on : Nov 26, 2017, 10:44:45 PM
    Author     : 123re
--%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Payment options</title>
</head>
<body>
	<h3>pay here</h3>
	<%@ page import = "java.sql.*" %>
	<%
	Class.forName("com.mysql.jdbc.Driver");
	Connection myConn = DriverManager.getConnection
			("jdbc:mysql://localhost:3306/finalprojectdatabase?useSSL=false","root","12345");
	String delete = "DELETE FROM storeOrders";
	PreparedStatement ps=myConn.prepareStatement(delete);
	ps.executeUpdate();
	%>
	<h4>Choose payment options</h4>
</body>
</html>
