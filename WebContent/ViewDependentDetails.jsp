<%@page import="java.util.ArrayList"%>
<%@page import="beans.Dependent"%>
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
</head>
<body>
<%-- <%@ include file="headerEmp.jsp"%> --%>
<% if(session.getAttribute("login")!=null||session.getAttribute("set")!=null){
	%>
	<%@ include file="headerEmp.jsp"%>
	<div class="wrapper col4">
		<div class="container">
			<div class="content">
				<br><br><br>
				<% if(request.getAttribute("dep")!=null){
					int a=Integer.parseInt(request.getAttribute("dep").toString());
					if(a>0){%>
					<h2>Dependent Added Successfully.</h2>
					<h2>Health Insurance Id is: <%=a %></h2>
					<%}else{ %>
					<h2>Error in dependent registration</h2>
				<% }}else if(request.getAttribute("dlist")!=null){
					ArrayList<Dependent> dlist=(ArrayList<Dependent>)request.getAttribute("dlist");
					if(dlist.size()==0){
						%>
						<h2>No dependent found</h2>
					<% }else{%>
					<center><table border="1" cellpadding="5">
					<tr>
					<th>Dependent Id </th>
					<th>Dependent Name</th>
					<th>Date of Birth </th>
					<th>Gender</th>
					<th>Relation</th>
					<th>E-Card</th>
					</tr>
					<% for(Dependent dep:dlist){ %>
					<tr>
					<td><%=dep.getDepId() %></td>
					<td><%=dep.getBeneName() %></td>
					<% 
					String date_s = dep.getDob().toString(); 
					SimpleDateFormat dt = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss"); 
					Date date = dt.parse(date_s); 
					SimpleDateFormat dt1 = new SimpleDateFormat("dd-MMM-yyyy");
					%>
					<td><%=dt1.format(date) %></td>
					<td><%=dep.getGender() %></td>
					<td><%=dep.getRelation() %></td>
					<td><h2><a href="GenerateCard?did=<%=dep.getDepId()%>">Generate</a></h2></td>
					</tr>
					<%} %>
					</table>
					</center>
					<% }}else{
						Dependent dep=(Dependent)request.getAttribute("dependent");%>
					<center><table border="1" height="100" width="400" cellpadding="10">
					<tr><th colspan="2"><center>Beneficiary Details</center></th></tr>
					<tr>
					<td>Dependent Id: </td>
					<td><%=dep.getDepId() %></td>
					</tr>
					<tr>
					<td>Dependent Name</td>
					<td><%=dep.getBeneName() %></td>
					</tr>
					<tr>
					<td>Date of Birth: </td>
					<% 
					String date_s = dep.getDob().toString(); 
					SimpleDateFormat dt = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss"); 
					Date date = dt.parse(date_s); 
					SimpleDateFormat dt1 = new SimpleDateFormat("dd-MMM-yyyy");
					%>
					<td><%=dt1.format(date) %></td>
					</tr>
					<tr>
					<td>Gender</td>
					<td><%=dep.getGender() %></td>
					</tr>
					<tr>
					<td>Relation</td>
					<td><%=dep.getRelation() %></td>
					</tr>
					</table>
					</center>
					<%}%>
				<br><br>
			</div>
		</div>
	</div>
	
	<br><br><br><br><br><br><br><br><br><br>
	<%}else{response.sendRedirect("home.jsp");} %>
	<%@ include file="footer2.jsp"%>
</body>
</html>