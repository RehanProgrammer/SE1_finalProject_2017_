<%-- 
    Document   : CardPayment
    Created on : Nov 29, 2017, 4:27:26 PM
    Author     : lucer_000
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Card Payment page.</title>
    </head>
    <body>
        <h1>Card Payment. Credit or Debit?</h1>
        
        <form method="post">
            
            <input type ="submit" name="cardTypeDebit" value="Debit"><br/>
            <input type ="submit" name="cardTypeCredit" value="Credit" ><br/>
            
        </form>
        <form action="payHere.jsp" >
            <input type="submit" value="Change Payment Method">
        </form>
        <%
            
            if(request.getParameter("cardTypeDebit")!=null){
                %>
               
                <jsp:include page="DebitCardPayment.jsp" flush="true"/>
              
                    <%
                        }else if(request.getParameter("cardTypeCredit")!=null){

                        %>
                        <jsp:include page="CreditCardPayment.jsp" flush="true"/>
                        <%
                            }
                            %>
        
       
    </body>
</html>
