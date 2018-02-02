<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Credit card payment</title>
</head>
<body>
	<h1>Credit Payment </h1>
        <form action = "customerInterface" method="post">
            Card Number <input type="text" name="cardNo"><br/>
            Expiration Date <input type="text" name="expDate"><br/>
            Security Number <input type="text" name="cvv"><br/>
            <input type="submit" name="cardTypeCredit" value="submit"><br/>
        </form>
        <form action="payHere.jsp" >
            <input type="submit" value="Change Payment Method">
        </form>
</body>
</html>