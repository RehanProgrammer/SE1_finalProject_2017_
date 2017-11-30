<%-- 
    Document   : CashPayment
    Created on : Nov 29, 2017, 4:26:26 PM
    Author     : lucer_000
--%>

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
        <%out.print(SE1_shoppingSystem.order.total()); %>
        
        <form method="post">
            Enter Cash to pay: <input type ="text" name="cashGiven"><br/>
            <input type="submit" value="submit"><br/>
            
        </form>
            <%
            //this is where i would make an object for payment type and send in
            //the total along with cash given. but shouldnt it first go through 
            //purchase ordermanager???
            //storing cashgiven in variable 

            %>
    </body>
</html>
