<%-- 
    Document   : moreOrder
    Created on : Nov 26, 2017, 10:43:24 PM
    Author     : 123re
--%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cart</title>
</head>
<body>
	<h4>Your orders<br> 
	<%@ page import = "java.sql.*" %>
	<% 
	try{
	Class.forName("com.mysql.jdbc.Driver");
	Connection myConn = DriverManager.getConnection
			("jdbc:mysql://localhost:3306/finalprojectdatabase?useSSL=false","root","12345");
	PreparedStatement ps=myConn.prepareStatement(  
			"select * from storeOrders");
	ResultSet rs = ps.executeQuery();
	ResultSetMetaData rsmd = rs.getMetaData();
	int columnsNumber = rsmd.getColumnCount();
	while (rs.next()) {
		
	    for(int i =2; i <= columnsNumber; i++){
	        out.println(rs.getString(i)  );
	        
	    }
	    out.println("<br>");
	}
	
}

catch(Exception e){
	e.printStackTrace();
}
	
	%>  </h4>
	<form action="scanner.jsp" method="post">
		order: <input type="text" name="order" required><br>
        quantity<input type="number" name="quantity" min="1" required><br>
		<input	type="submit" value="submit"> 
	</form>
	<a href = "payHere.jsp"> payment page</a>
</body>
</html>
