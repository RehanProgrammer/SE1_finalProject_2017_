<%-- 
    Document   : CashPayment
    Created on : Nov 29, 2017, 4:26:26 PM
    Author     : lucer_000
--%>
<%@ page import="SE1_shoppingSystem.customerInterface"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CashPayment page</title>
    </head>
    <body>
        <h1>Cash Payment. Enter cash to pay with.</h1>
        Total: 
        <%out.print(SE1_shoppingSystem.order.getTotal()); %>
        
        <form action="customerInterface" method="post">
            Enter Cash to pay: <input type ="text" name="cashGiven"><br/>
            <input type="submit" name="CashPayment" value="submit">
            
        </form>
        <form action="payHere.jsp" >
            <input type="submit" value="Change Payment Method">
        </form>
    </body>
</html>
