<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>scanner page</title>
</head>
<body>
<form action="customerInterface" method="post">
        Scanner code<input type="number" name="scannercode" min="1" required><br>
		<input	type="submit" name="scanner" value="submit">
        </form>
	
        <form action="payHere.jsp" >
            <input type="submit" value="Total">
        </form>
        
        <form action="customerInterface" method="post">
            <input type="submit" name="cancel" value="Cancel">
        </form>
        
	<h4>Your items<br> 
	<%@ page import = "java.sql.*" %>
	<% 
	try{
	Class.forName("com.mysql.jdbc.Driver");
	Connection myConn = DriverManager.getConnection
			("jdbc:mysql://localhost:3306/finalprojectdatabase?useSSL=false","root","DdaavviidMYSQL1d");
	PreparedStatement ps=myConn.prepareStatement(  
			"select * from cart");//check if the cart table is not null
	ResultSet rs = ps.executeQuery();
	ResultSetMetaData rsmd = rs.getMetaData();
	int columnsNumber = rsmd.getColumnCount();
	while (rs.next()) {
		
	    for(int i =2; i <= columnsNumber; i++){
	        out.println(rs.getString(i)  );
	        
	    }
	    out.println("<br>");
	    
	    
	}
	out.print(SE1_shoppingSystem.order.getTotal());
}
	
catch(Exception e){
	e.printStackTrace();
}
	
	%>  </h4>


	
	
</body>
</html>