<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Payment</title>
</head>
<body>
	<% String msg1=(String)request.getAttribute("uname");  
    int price=(Integer)session.getAttribute("price");
    int amountAvail=(Integer)request.getAttribute("amount");
    if(price >= amountAvail){%>
	<h1>Your Account balace is low</h1>
	<%}else{
    %>
	<h1>
		Welcome
		<%=msg1 %></h1>
	<form action="PayCnt.html" method="post">
		<table>
			<tr>
				<td>Amount to be paid:
				<td><input type="text" name="amount" value="<%=price%>"
					disabled>
			<tr>
				<td><input type="submit" value="pay">
		</table>
	</form>
	<%} %>
</body>
</html>