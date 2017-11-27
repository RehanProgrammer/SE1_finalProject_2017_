<%-- 
    Document   : scanner
    Created on : Nov 20, 2017, 1:46:26 PM
    Author     : 123re
--%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Scanner page</title>
</head>
<body>
  <%
        String order = request.getParameter("order");
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        session.setAttribute("order", order);
        session.setAttribute("quantity", quantity);
        %>
        <form action="customerInterface" method="post">
        Scanner code<input type="number" name="scanner" min="1" required><br>
		<input	type="submit" value="submit">
	</form>
        
</body>
</html>
