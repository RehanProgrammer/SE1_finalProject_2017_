<%-- 
    Document   : restock
    Created on : Nov 29, 2017, 6:59:29 PM
    Author     : Lauren
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Restock Item</h1>
        <p>Scan item to be restocked: </p>
      
        <form action="InventoryServlet" method="post">
           Item Id: <input type="text" name="itemId"> </input><br>
            Quantity: <input type="text" name="restockQuantity"></input><br>
        <input type="submit" value="scan" name="scanRestock">
        </form>
        
        <a href="index.jsp">Cancel</a> <br>
    </body>
</html>
