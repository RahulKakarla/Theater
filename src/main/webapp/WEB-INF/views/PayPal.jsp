<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<title>W3.CSS</title>
<meta name="viewport" content="width=device-width, initial-scale=1">

<body>

<%String msg=(String)request.getAttribute("msg"); 
if(msg!=null){%>
	<p><%=msg %></p>
<%}
%>

<div >
  <button  onclick="openTab('Login')">Login</button>
  <button  onclick="openTab('Register')">Register</button>
 
</div>

<div id="Login" style="display:none" class="tab">
<table>
<form method="post" action="LoginCnt.html">
<tr>
<td>User Name<td><input type="text" name="uname" required><br>
</tr>
<tr>
<td>Password<td><input type="password" name="pass" required>
</tr>
<tr><td><td><input type="Submit" value="Submit" id="buttonId" onClick="sub(); "></tr>
</form>
</table> 
</div>

<div id="Register"  style="display:none" class="tab">
<table>
<form method="post" action="RegisterCnt.html" >
<tr>
<td>Name:<td><input type="text" name="name" required><br><br>
<tr><td>Mobile:<td><input type="tel" name="phone" required pattern="[1-9]{1}[0-9]{9}"><br><br>
<tr><td>Account:<td><input type="text" name="acnt" required><br><br>
<tr><td>Amount:<td><input type="number" name ="amount"><br><br>
<tr><td>UserName:<td><input type="text" name="uname" required><br><br>
<tr><td>Password:<td><input type="password" name="password" id="password" onblur='check();' required><br><br>
<tr><td>Confirm Password:<td><input type="password" name="password1" id="password1" onblur='check();' required><br><br>
<tr><td><td><input type="submit" value="Submit">
<span id='message'></span><br>
</form>
</table>
</div>



<script>
function openTab(tab) {
    var i;
    var x = document.getElementsByClassName("tab");
    for (i = 0; i < x.length; i++) {
       x[i].style.display = "none";  
    }
    document.getElementById(tab).style.display = "block";  
}
</script>

</body>
</html>
