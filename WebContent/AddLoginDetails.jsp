<%@page import="org.hibernate.Session"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>TPA Login Page</title>
<link rel="stylesheet" href="css/style.css" type="text/css">
<link rel="stylesheet" href="css/form.css" type="text/css">
<script type="text/javascript">
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
				<% if(request.getAttribute("added")!=null){ 
					int a=Integer.parseInt(request.getAttribute("added").toString());
					if(a>0){%>
						<h2>Employee Added Successfully</h2>
					<%}else{%>
					<h2>Employee already Exists</h2>
				<%}}%>
				<div class="form-style-10">
					<h1>
						Add Employee<span>Add a new employee</span>
					</h1>
				<form action="AddLoginDetails" method="get">
					<p align="right">Fields marked with asterisk(<span style="color:red">*</span>)are mandatory</p>
						<div class="section">Employee Id</div>
						<div class="inner-wrap">
							<label><h4>Employee Id<span style="color: red">*</span></h4><input type="text" name="EmpId" required/></label> 
							
						</div>


						<div class="button-section">
							<center><input type="submit" name="AddEmployee" /></center>

						</div>
					</form>
					</div>
				<br><br><br><br><br><br><br><br><br><br><br><br>
			</div>
		</div>
	</div>
	<%}else{response.sendRedirect("Login.jsp");} %>
<%@ include file="footer2.jsp"%>
</body>
</html>