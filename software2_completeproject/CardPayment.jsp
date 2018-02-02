<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>card payment</title>
</head>
<body>
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