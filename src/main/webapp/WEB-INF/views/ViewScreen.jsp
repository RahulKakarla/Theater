<%@page import="com.rk.entity.Screen"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Screens</title>
</head>
<body>
	<form action="SeatShow.html" method="post">

		<%
			ArrayList<Screen> Lists = (ArrayList<Screen>) request.getAttribute("Screens");
			if (Lists != null) {
		%>
		Wlecome to
		<%=session.getAttribute("Theater")%>
		<table>
			<tr>
				<td>Screen Number
				<td>Available Seats
				<td>Select Screen
				<td>Num of Tickets <%
					for (Screen sc : Lists) {
				%>
			<tr>
				<td><%=sc.getScreenNum()%>
				<td><%=sc.getNumofseats()%> <input type="hidden"
					name="theater" value="<%=sc.getTheaterName()%>">
				<td><input type="radio" name="screen"
					value="<%=sc.getScreenNum()%>">
				<td><input type="number" max="<%=sc.getNumofseats()%>"
					name="<%=sc.getScreenNum()%>"> <%
 	}
 %>
			<tr>
				<td>
				<td><input type="submit" value="submit">
		</table>
		<%
			} else {
		%>
		<h1>Nothing to Display</h1>
		<%} %>

	</form>
</body>
</html>