<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Payment options</title>
</head>
<body>
	<h3>pay here</h3>
	<h4>your total is</h4>
	<%out.print(hw4.finals.order.getTotal()); %>
	<form action="CashPayment.jsp" method="post">
       <input type="submit" value="Cash">
        </form>
        <form >
       <input type="submit" name="cardPayment" value="Card">
        </form>
        <form action="customerInterface" method="post">
            <input type="submit" name="cancel" value="Cancel">
        </form>
        <%
            if(request.getParameter("cardPayment")!=null){
                %>
               <jsp:include page="CardPayment.jsp" flush="true"/>
                      <%
                        }
                        %>
</body>
</html>