<%@page import="beans.Request"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>View Request Page</title>
<link rel="stylesheet" href="style.css" type="text/css">
<script>
  function preventBack(){window.history.forward();}
  setTimeout("preventBack()", 0);
  window.onunload=function(){null};
</script>
</head>
<body>
<% if(session.getAttribute("set")!=null){ %>
	<%@ include file="header2.jsp"%>
	<div class="wrapper col4">
		<div class="container">
			<div class="content">
				<br><br><br>
				<%ArrayList<Request> rlist=(ArrayList<Request>)request.getAttribute("RequestList"); %>
				<% if(rlist.size()==0){ %>
						<h2>There is no request</h2>
					<%
					}
					else{
					%>
					<center><table border="1">
					<tr><th>Request Id</th><th>Health Insurance Id</th><th>Employee Id</th>
					<th>Request Submit Date</th>
					<th>Request Approve Date</th>
					<th>SLA Crossed</th>
					<th colspan="2"><center>Action</center></th>
					</tr>
					<% for(Request r:rlist){
						%>
						<tr>
						<td><%=r.getRequest_Id() %></td>
						<td><%=r.getHID() %></td>
						<td><%=r.getEmpId() %></td>
						<td><%=r.getSubmitDate() %></td>
						<% if(r.getApproveDate()!=null){%><td><%=r.getApproveDate() %></td>
					<% }else{%><td>-</td><%} %>
						<td><%=r.getSLA_Crossed()%></td>
						<td><a href="ViewEmployeeDetails?empid=<%=r.getEmpId()%>&reqid=<%=r.getRequest_Id() %>&hid=<%=r.getHID() %>&status=<%=request.getAttribute("status") %>">Get Details</a></td>
						</tr>
					<%} %></table></center>
					<%}%>
				<br><br>
				<br><br>
				<br><br>
			</div>
		</div>
	</div>
	
	<%}else{response.sendRedirect("Login.jsp");} %>
	<br><br><br><br><br><br><br><br><br>
	<%@ include file="footer2.jsp"%>
</body>
</html>