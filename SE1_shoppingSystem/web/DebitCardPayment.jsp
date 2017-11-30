<%-- 
    Document   : DebitCardPayment
    Created on : Nov 29, 2017, 7:03:53 PM
    Author     : lucer_000
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Debit Payment</title>
    </head>
    <body>
        <h1>Debit Payment</h1>
        <form action = "customerInterface" method="post">
            Card Number <input type="text" name="cardNo"><br/>
            Expiration Date <input type="text" name="expDate"><br/>
            Security Number <input type="text" name="cvv"><br/>
            Pin <input type="text" name="pin"><br/>
            <input type="submit" name="cardTypeDebit" value="submit"><br/>
        </form>
    </body>
</html>
