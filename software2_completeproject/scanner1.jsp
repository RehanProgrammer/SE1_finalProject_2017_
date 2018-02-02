<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>scanner1 page</title>
</head>
<body>
<form action="customerInterface" method="post">
        Scanner code<input type="number" name="scanner" min="1" required><br>
		<input	type="submit" name= "Scanner1" value="submit">
        </form>
        <form action="customerInterface" method="post">
            <input type="submit" name="cancel" value="Cancel">
        </form>
	<a href = "payHere.jsp"> Payment page</a>
	<h4>Your items<br> 
	<%@ page import = "java.sql.*" %>
	<% 
	try{
	Class.forName("com.mysql.jdbc.Driver");
	Connection myConn = DriverManager.getConnection
			("jdbc:mysql://localhost:3306/finalprojectdatabase?useSSL=false","root","12345");
	PreparedStatement ps=myConn.prepareStatement(  
			"select * from cart");//check if the cart table is not null
	ResultSet rs = ps.executeQuery();
	ResultSetMetaData rsmd = rs.getMetaData();
	int columnsNumber = rsmd.getColumnCount();
	while (rs.next()) {
		for(int i =2; i <=columnsNumber ; i++){
	        out.println(rs.getString(i)  );
	       }
	    out.println("<br>");
	   }
	out.print(hw4.finals.order.getTotal());
}
	
catch(Exception e){
	e.printStackTrace();
}
	
	%>  </h4> 
	
	
</body>
</html>