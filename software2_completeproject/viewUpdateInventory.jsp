<%-- 
    Document   : viewUpdateInventory
    Created on : Nov 29, 2017, 6:59:45 PM
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
        <h1> View/Update Item</h1>
        <p>Scan item to be viewed/update: </p>
      
        <form action="InventoryServlet" method="post">
            <input type="text" name="itemId"> </input><br>
 
        <input type="submit" value="scan" name="scanViewUpdateInventory">
        </form>
           <%
                Object flag = request.getAttribute("flagg");
                
                Object itemName = request.getAttribute("name");
                Object itemId = request.getAttribute("id");
                Object itemPrice = request.getAttribute("price");
                Object itemDescription = request.getAttribute("description");
                Object itemDiscount = request.getAttribute("discount");
                Object itemQuantity = request.getAttribute("quantity");
                if (flag != null){
                    request.setAttribute("flag", null);
                %>
                <p>
                <form action="InventoryServlet" method="post">
                    Item Id: <input type="text" name="updatedId" value="<%=itemId %>"></input> <br>
                    Item Name: <input type="text" name="updatedName" value="<%=itemName %>"></input> <br>
                    Item Price: <input type="text" name="updatedPrice" value="<%=itemPrice %>"></input> <br>
                    Item Quantity: <input type="text" name="updatedQuantity" value="<%=itemQuantity %>"></input><br>
                    Item Description: <input type="text" name="updatedDescription" value="<%=itemDescription %>"></input><br>
                    Item Discount: <input type="text" name="updatedDiscount" value="<%=itemDiscount %>"></input> <br>
                   
                    <input type="submit" value="save changes" name="updateButton">
                </form>
                
                </p>
               
               <%
               }
               
               %>
               
               <br>
               <a href="index.jsp">Cancel</a> <br>
    </body>
</html>
