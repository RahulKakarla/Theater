<%@page import="com.rk.entity.Seat"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
#disab {
	outline: 1px solid red;
	background: red;
}
</style>
<script>
	function handleClick(selected) {

		/* document.getElementById("chk").innerHTML=document.getElementById("chk").innerHTML+" "+selected.value; */
		x = document.getElementById('numsc').value;
		if (document.getElementById('chk').innerHTML.length / 3 < x) {
			if (document.getElementById('chk').innerHTML
					.includes(selected.value)) {

				if (document.getElementById('chk').innerHTML.replace(
						selected.value + " ", '') === document
						.getElementById('chk').innerHTML)
					document.getElementById('chk').innerHTML = document
							.getElementById('chk').innerHTML.replace(" "
							+ selected.value, '');

				else
					document.getElementById('chk').innerHTML = document
							.getElementById('chk').innerHTML.replace(
							selected.value + " ", '');

			} else {
				document.getElementById("chk").innerHTML = document
						.getElementById("chk").innerHTML
						+ " " + selected.value;

			}
			document.getElementById("chk1").innerHTML = document
					.getElementById('chk').innerHTML.length / 3;
			document.getElementById("chk2").innerHTML = (document
					.getElementById('chk').innerHTML.length / 3)
					* (document.getElementById('price').value);
		} else {
			alert("Requested tickets reached");
			selected.checked = false;
		}
	}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Seat</title>
</head>
<body>
	<form action="SelectSeat.html" method="post">

		<%
			ArrayList<Seat> Lists = (ArrayList<Seat>) request.getAttribute("Seats");
			Integer x = (Integer) request.getAttribute("num");
			if (Lists != null) {
		%>
		Wlecome to
		<%=session.getAttribute("Theater")%>
		<input type="hidden" id="numsc" name="screens" value="<%=x%>">
		<input type="hidden" id="price" name="price" value="10">
		<table>
			<tr>
				<%
					int row2 = 1;
						for (Seat se : Lists) {
							int row1 = se.getRownum();
							if (row1 != row2) {
				%>
			
			<tr>
				<td><%=se.getSeatID()%> <%
 	if (se.isAvialable()) {
 %>
				<td><input type="checkbox" onchange='handleClick(this);'
					id="chkproperty" name="select" value=<%=se.getSeatID()%>> <%
 	} else {
 %>
				<td><input type="checkbox" disabled id='disab'> <%
 	}
 %> <%
 	row2 = row1;
 			} else {
 %>
				<td><%=se.getSeatID()%></td>
				<%
					if (se.isAvialable()) {
				%>
				<td><input type="checkbox" onchange='handleClick(this);'
					id="chkproperty" name="select" value=<%=se.getSeatID()%>> <%
 	} else {
 %>
				<td><input type="checkbox" disabled id='disab'> <%
 	}
 %> <%
 	row2 = row1;
 			}

 		}
 %>
			<tr>
				<td>
				<td><input type="submit" value="submit">
		</table>
		Selected Seats:<span id="chk"></span><br> No of seats:<span
			id="chk1"></span><br> Total Price:<span id="chk2"></span>
		<%
			} else {
		%>
		<h1>Nothing to Display</h1>
		<%
			}
		%>

	</form>
</body>
</html>