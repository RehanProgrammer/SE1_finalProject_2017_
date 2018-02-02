<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Start page</title>
</head>
<body>

 <h1>Auto scout system</h1>
  
  <form action="customerInterface" method="post">
         <input type="submit" name="start" value="Start Check Out">
     </form>
     <form action="employees.jsp" method="post">
         <input type="submit" name="start" value="for employees only">
     </form>
 
</body>
</html>
<%/*
substract the quantity from inventory, and add contents to transaction table
<form action="scanner.jsp" method="post">
order: <input type="text" name="order" required><br>
quantity<input type="number" name="quantity" min="1" required><br>
<input	type="submit" value="submit">
</form>
*/
%>