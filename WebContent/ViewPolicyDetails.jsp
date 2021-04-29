<%@page import="beans.Policy"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
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
	<%@ include file="header.jsp"%>
	<div class="wrapper col4">
		<div class="container">
			<div class="content">
				<br><br><br>
					<% Policy pol=(Policy)request.getAttribute("policy");%>
					<center><table border="1" height="100" width="400" cellpadding="10">
					<tr><th colspan="2"><center>Policy Details</center></th></tr>
					<tr>
					<td>Policy No: </td>
					<td><%=pol.getPolicy_No() %></td>
					</tr>
					<tr>
					<td>Start Date: </td>
					<% 
					String date_s = pol.getStartDate().toString(); 
					SimpleDateFormat dt = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss"); 
					Date date = dt.parse(date_s); 
					SimpleDateFormat dt1 = new SimpleDateFormat("dd-MMM-yyyy");
					%>
					<td><%=dt1.format(date) %></td>
					</tr>
					<tr>
					<td>Policy Period: </td>
					<td><%=pol.getPolicy_Period() %>&nbsp; years</td>
					</tr>
					<tr>
					<td>Sum Insured: </td>
					<td><%=pol.getSum_Insured() %>&nbsp; INR</td>
					</tr>
					<tr>
					<td>Premium Amount(Per Annum): </td>
					<td><%=pol.getPremium_Amount() %>&nbsp; INR</td>
					</tr>
					</table>
					</center>
				<br><br>
			</div>
		</div>
	</div>
	<%}else{response.sendRedirect("home.jsp");} %>
	<%@ include file="footer2.jsp"%>
</body>
</html>