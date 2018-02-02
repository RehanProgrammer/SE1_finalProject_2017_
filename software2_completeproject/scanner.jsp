<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Scanner page</title>
</head>
<body>
 <form action="customerInterface" method="post">
		Scanner code<input type="number" name="scanner" min="1" required><br>
		<input type="submit" name= "Scanner" value="submit">
	</form>
	<form action="customerInterface" method="post">
            <input type="submit" name="cancel" value="Cancel">
        </form>
	


	
	

</body>
</html>
