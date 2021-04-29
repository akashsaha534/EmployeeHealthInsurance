<%@page import="beans.Employee"%>
<%@page import="beans.Login"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee Health insurance</title>
<link rel="stylesheet" href="css/style.css" type="text/css">
</head>
<% if(session.getAttribute("login")!=null){ Login l=(Login)session.getAttribute("login"); %>
<body id="top">

	<div class="wrapper coll">
		
		
		<div id="head2">
			<% if(session.getAttribute("employee")!=null){ 
			Employee e=(Employee)session.getAttribute("employee");
			%>
			<pre align="right"><h3>Welcome <%=e.getEmpName() %></h3></pre> 
			<%}else{ %>
			<pre align="right"><h3>Welcome <%=l.getEmpId() %></h3></pre>
			<%} %>
			<h1>
				<a href="home.jsp">Employee Health Insurance</a></h1>
				
			
			<p>Close to Home. Close to Your Heart.</p>
			
			<div id="topnav">
				<ul >
				<li><a class="active1" href="home.jsp">Home</a></li>
					<li><a href="RegisterEmployee"> EHI Registration </a></li>
					<li><a href="dependentReg1.jsp">Add Dependent</a></li>
					<li><a href="ViewRequestList">Check your Status</a></li>
					<li><a href="ViewEmployeeDetails">Profile</a></li>
					<li><a href="ChangePassword.jsp">Change Password</a></li>
					<li><a  href="Logout.jsp" >Log Out</a></li>
				</ul>

			</div>
		</div>
	</div>
<%} %>
</body>
</html>