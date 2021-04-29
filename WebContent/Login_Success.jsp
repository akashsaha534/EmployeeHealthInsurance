<%@page import="beans.Login"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee Login Success Page</title>
<link rel="stylesheet" href="css/style.css" type="text/css">
<script>
  function preventBack(){window.history.forward();}
  setTimeout("preventBack()", 0);
  window.onunload=function(){null};
</script>
</head>
<body>
	<% if(session.getAttribute("login")!=null){ %>
	<%@ include file="headerEmp.jsp"%>
	<div class="wrapper col4">
		<div class="container">
			<div class="content">
				
				<center>
				<% if(session.getAttribute("changePass")!=null){
					session.removeAttribute("login");
					session.removeAttribute("changePass");%>
				<h2> Password Changed Successfully</h2>
				<h2> You will be redirected to login page again after 5 seconds</h2>
				<script>
        			var timer = setTimeout(function() {
            			window.location='loginEmp.jsp';
        				}, 5000);
    			</script>
				<%} else{%>
				<% Login l=(Login)session.getAttribute("login"); %>
				<% if(l.getPassword().equals("ChangePwd@123")){ %>
				<% RequestDispatcher rd=request.getRequestDispatcher("ChangePassword.jsp"); %>
				<% rd.forward(request, response); %>
				<%} %>
				<%}}else{response.sendRedirect("loginEmp.jsp");} %>
				</center>
				<ol type="1"><h1>HEALTH INSURANCE PLAN FOR EMPLOYEES AND THEIR DEPENDENTS:</h1>
					<li>Comprehensive coverage for hospitalization.</li>
					<li>Can insured any amount of money.</li>
					<li>Cash less hospitalization in more than 4000 hospitals across India.</li>
					<li>Lifelong Renewal.</li>
					<li>No Sub-Limits on room rent.</li>
					<li>No Co-Payments.</li>
					<li>No claim-based loadings at policy renewal.</li>
					<li>Restore benefit: 1st of its kind benefit, that restores the entire sum insured in full at no extra cost.</li>
					<li>Multiplier benefit: A unique benefit that offers 50% hike in sum insured for every claim free year, at no extra cost.</li>
				</ol>					
				<br><br><br><br><br><br><br><br>
			</div>
		</div>
	</div>
<%@ include file="footer2.jsp"%>
</body>
</html>