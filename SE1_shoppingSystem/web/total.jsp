<%-- 
    Document   : total
    Created on : Nov 29, 2017, 2:52:25 PM
    Author     : 123re
--%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>total page</title>
</head>
<body>
	<h4>your total is</h4>
	<%out.print(SE1_shoppingSystem.order.total()); %>
	<form action="payHere.jsp" method="post">
        Scanner code<input type="number" name="scanner" min="1" required><br>
		<input	type="submit" value="submit">
        </form>
</body>
</html>
