<%@page import="beans.Request"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>View Request Page</title>
<link rel="stylesheet" href="style.css" type="text/css">
<script type="text/javascript">
  function preventBack(){window.history.forward();}
  setTimeout("preventBack()", 0);
  window.onunload=function(){null};
</script>
</head>
<body>
<% if(session.getAttribute("login")!=null||session.getAttribute("set")!=null){
	%>
	<%@ include file="headerEmp.jsp"%>
	<div class="wrapper col4">
		<div class="container">
			<div class="content">
				<br><br><br>
					<% ArrayList<Request> rlist=(ArrayList<Request>)request.getAttribute("RequestList");
					if(rlist.size()==0){
						%>
						<h2>You have not requested for anything</h2>
						<br><br><br><br><br><br><br><br><br><br><br><br><br>
					<%
					}
					else{%>
					<center><h2>Click on the Health Insurance Id to get the status of your request</h2></center>
					<center><table border="1">
					<tr><th>Request Id</th><th>Health Insurance Id</th>
					<th>Request Submit Date</th>
					<th>Request Approve Date</th>
					</tr>
					<% for(Request r:rlist){
						%>
						<tr>
						<td><%=r.getRequest_Id() %></td>
						<td><a href="GetHealthInsuranceDetails?hid=<%=r.getHID() %>"><%=r.getHID() %></a></td>
						<td><%=r.getSubmitDate() %></td>
						<% if(r.getApproveDate()!=null){ %>
						<td><%=r.getApproveDate() %></td>
						<%}else{ %>
						<td>-</td>
						<%} %>
						</tr>
					<%} %></table></center>
					<%}%>
				<br><br><br><br><br><br><br><br><br><br><br>
			</div>
		</div>
	</div>
	<%@ include file="footer2.jsp"%>
	<%}else{response.sendRedirect("home.jsp");} %>
</body>
</html>