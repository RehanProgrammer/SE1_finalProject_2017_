<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>cash payment</title>
</head>
<body>
<h4>your total is</h4>
	<%out.print(hw4.finals.order.getTotal()); %>
<form action="customerInterface" method="post">
            Enter Cash to pay: <input type ="text" name="cashGiven"><br/>
            <input type="submit" name="CashPayment" value="submit"><br/>
            </form>
        <form action="payHere.jsp" >
            <input type="submit" value="Change Payment Method">
        </form>
</body>
</html>