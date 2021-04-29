<%@page import="beans.Health_Insurance"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
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
					<% Health_Insurance h=(Health_Insurance)request.getAttribute("health"); %>
					<%if(h.getCustomer_Id()/1000000==2){%>
					<center><h2>Click on the Dependent Id to get dependent details</h2></center>
					<%} %>
					<center><table border="1" height="100" width="400" cellpadding="10">
					<tr><th colspan="2"><center>Health Insurance Details</center></th></tr>
					<tr>
					<td>Health Insurance Id: </td>
					<td><%=h.getHID() %></td>
					</tr>
					<% if(h.getCustomer_Id()/1000000==1){ %>
					<tr><td>Applied For: </td>
					<td>Self</td>
					</tr>
					<%}else if(h.getCustomer_Id()/1000000==2){ %>
					<tr><td>Applied For: </td>
					<td>Beneficiary</td>
					</tr>
					<tr>
					<td>Dependent Id: </td>
					<td><a href="ViewDependentDetails?did=<%=h.getCustomer_Id() %>"><%=h.getCustomer_Id() %></a></td>
					</tr>
					<%} %>
					<tr><td>Policy No</td>
					<td><%=h.getPolicy_No() %></a></td>
					</tr>
					<tr>
					<td>Status</td>
					<td><%=h.getStatus() %></td>
					</tr>
					</table></center>
					<center><input type="button" value="Back" onclick="javascript:history.go(-1)"></center>
				<br><br>
			</div>
		</div>
	</div>
	<%@ include file="footer2.jsp"%>
	<%}else{response.sendRedirect("home.jsp");} %>
</body>
</html>