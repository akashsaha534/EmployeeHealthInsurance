<%@page import="org.hibernate.Session"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>TPA Login Page</title>
<link rel="stylesheet" href="css/style.css" type="text/css">
<script>
  function preventBack(){window.history.forward();}
  setTimeout("preventBack()", 0);
  window.onunload=function(){null};
</script>
</head>
<body>
<%if(session.getAttribute("set")!=null){ %>
	<%@ include file="header2.jsp"%>
	<div class="wrapper col4">
		<div class="container">
			<div class="content">
				<br><br>
				<% if(request.getAttribute("approved")!=null){ %>
				<h2>Request no. <%=request.getAttribute("approved") %> is approved</h2><br><br><br><br><br><br><br><br><br>
				<% }else if(request.getAttribute("rejected")!=null){ %>
				<h2>Request no. <%=request.getAttribute("rejected") %> is rejected</h2><br><br><br><br><br><br><br><br><br>
				<%}else{%>
				<h1>TPA Values</h1>
				<p>Health insurance specialists carry many different responsibilities,which include reviewing employee details
					using their request number.They examine the details and approve or reject the requests of employee and as well as thier dependent.
					TPA can also give reason for rejection of request(if any). </p>
					<p>Other responsibilities of a TPA is he/she can add any employee.</p>
					<p>They can view pending request as well as rejected request and approved request.</p>
					<p>According to the details of employees and their dependents,TPA will take action.</p>
					<%} %>
				<br><br><br><br><br><br><br><br><br>
			</div>
		</div>
	</div>
	<%}else{response.sendRedirect("Login.jsp");} %>
	
<%@ include file="footer2.jsp"%>
</body>
</html>