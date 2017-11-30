<%-- 
    Document   : CreditCardPayment
    Created on : Nov 29, 2017, 7:04:33 PM
    Author     : lucer_000
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Credit Payment</title>
    </head>
    <body>
        <h1>Credit Payment </h1>
        <form action = "customerInterface" method="post">
            Card Number <input type="text" name="cardNo"><br/>
            Expiration Date <input type="text" name="expDate"><br/>
            Security Number <input type="text" name="cvv"><br/>
            <input type="submit" name="cardTypeCredit" value="submit"><br/>
        </form>
    </body>
</html>
