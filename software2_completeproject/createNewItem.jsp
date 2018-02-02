<%-- 
    Document   : createNewItem
    Created on : Dec 1, 2017, 5:17:53 AM
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
        <h1>Create New Item</h1>
        The item you scanned was not found. Please add the item to the inventory:
        
         <p>
                <form action="InventoryServlet" method="post">
                    Item Id: <input type="text" name="newId"></input> <br>
                    Item Name: <input type="text" name="newName"></input> <br>
                    Item Price: <input type="text" name="newPrice"></input> <br>
                    Item Quantity: <input type="text" name="newQuantity"></input><br>
                    Item Description: <input type="text" name="newDescription"></input><br>
                    Item Discount: <input type="text" name="newDiscount"></input> <br>
                   
                    <input type="submit" value="create item" name="addButton">
                </form>
                
                </p>
        <a href="index.jsp">Cancel</a> <br>
    </body>
</html>
