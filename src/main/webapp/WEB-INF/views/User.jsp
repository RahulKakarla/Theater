<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@page import="com.rk.entity.Theater"  %>   
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome</title>
</head>
<body>
<form action="ScreenCnt.html" method="post">
<table>
<% ArrayList<Theater> Lists =(ArrayList<Theater>)request.getAttribute("Lists");
if(Lists!=null){%>
<tr><th>Theater Name<th>Address
<%for(Theater th:Lists){
	%>
	<tr><td><a href=""><%=th.getTheaterName()%></a>
	<td><%=th.getAddress() %>
	<td> <input type="radio" name="theater" value="<%=th.getTheaterName()%>" required>
<%}%> 
<tr><td><td><input type="submit" value="submit">
<%}else{%>
<h1>Nothing to Display</h1>
<%} %>
</table>
</form>
<%-- <table>
<c:forEach items="${Lists}" var="Th">
<tr>
<td><c:out value="${Th.name }"/>
 </tr>
 </c:forEach>
</table> --%>

</body>
</html>